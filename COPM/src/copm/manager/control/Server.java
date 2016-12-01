/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copm.manager.control;

import copm.gui.frame.ServerFrame;
import copm.model.container.Page;
import copm.model.container.Project;
import copm.manager.data.AuthorityData;
import copm.manager.data.AuthorityToData;
import copm.manager.data.ExitData;
import copm.manager.data.InitData;
import copm.manager.data.LoadPageData;
import copm.manager.data.NetworkData;
import copm.manager.data.NewObjectData;
import copm.manager.data.NewPageData;
import copm.manager.data.ReleaseAuthorityData;
import copm.manager.data.RemoveObjectData;
import copm.manager.data.ReviseData;
import copm.manager.data.SocketInfo;
import copm.manager.data.TextBoxTextData;
import copm.model.component.Figures;
import copm.model.component.Objects;
import copm.model.component.TextBox;
import copm.manager.data.ProjectData;
import copm.manager.data.SaveData;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Arsene holmes
 */
public class Server {
    private Project project;
    private ServerSocket myServerSocket;
    private Socket mySocket;
    private ArrayList<SocketInfo> clients = new ArrayList<>();
    private HashMap<String, String> authority = new HashMap<String, String>();
    private ServerFrame frame;
    public Server(){
        frame = new ServerFrame();
        frame.init(this);
    }
    public void showFrame(){
        frame.showFrame();
    }
    public void setServerInfo(String portNum){
        frame.setServerInfo(portNum);
    }
    public void appendLog(String line){
        frame.appendLog(line);
    }
    public void openProject(){
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("copm", "copm"));
        chooser.setAcceptAllFileFilterUsed(false);
        int sel;
        if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            File file = chooser.getSelectedFile();
                System.out.println(file.getAbsolutePath());
            try{
                FileInputStream fin = new FileInputStream(file.getAbsolutePath());
                ObjectInputStream ois = new ObjectInputStream(fin);
                project = (Project) ois.readObject();
                ois.close();
                appendLog("open :" + file.getName());
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "load Project error");
                System.exit(0);
            }
        }
        else{
            newProject();
        }
    }
    
    public void saveProject(String name){
        try{
            if(!name.endsWith(".copm")){
                name += ".copm";
            }
            FileOutputStream fout = new FileOutputStream(name);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(project);
            oos.close();
            appendLog("Done");
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public void newProject(){
        project = new Project();
        appendLog("create new Project");
    }
    public void init(){
        Object[] options = {"Create New Project", "Open Project"};
        int n = JOptionPane.showOptionDialog(null,"option","Open Project",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
            null,options,options[1]);
        if(n == 0){
            newProject();
        }
        else{
            openProject();
        }
    }
    public ArrayList<SocketInfo> getClients(){
        return clients;
    }
    public Project getProject(){
        return project;
    }
    public synchronized void beServer(int portNum){
        Thread ser = new Thread(){
            public void run(){
                try {
                    myServerSocket = new ServerSocket(portNum);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "network error : " + ex.getMessage());
                    System.exit(0);
                }
                try {
                    appendLog("open socket\n   -ip: " + InetAddress.getLocalHost().getHostAddress()+ "\n   -portNum : " + portNum);
                } catch (UnknownHostException ex) {
                    
                }
                while(true){
                    try{
                        appendLog("ready to accept");
                        mySocket = myServerSocket.accept();
                        appendLog("connected : " + clients.size());
                        SocketInfo clientInfo = new SocketInfo(mySocket);
                        clientInfo.sendObject(new InitData(project.getTitles(), project.getIDs()));
                        clients.add(clientInfo);
                        Thread acep = new Thread(){
                            public void run(){
                                while(true){
                                    NetworkData data = null;
                                    try {
                                        data = clientInfo.recieveObject();
                                    } catch (IOException ex) {
                                        appendLog("recieve socket error");
                                        return;
                                    }
                                    appendLog("\nrecieve data : " + data.getStringCommand());
                                    if(data.getCommand() == NetworkData.EXIT){
                                        ExitData exitData = (ExitData)data;
                                        clients.remove(clientInfo);
                                        clientInfo.close();
                                        if(exitData.getAuthority()){
                                            authority.remove(exitData.getPageID().toString());
                                            sendData(new ReleaseAuthorityData(exitData.getPageID()));
                                        }
                                        appendLog("EXIT : " + clients.size());
                                        return;
                                    }
                                    else{
                                        execute(data, clientInfo);
                                    }
                                    
                                }
                            }
                        };
                        acep.start();
                        appendLog("ready to recieve");
                    }
                    catch(IOException ioex){
                        JOptionPane.showMessageDialog(null, "network error : " + ioex.getMessage());
                        System.exit(0);
                    }
                }
            }
        };
        ser.start();
    }
    public void execute(NetworkData data, SocketInfo clientInfo){
        switch(data.getCommand()){
            case NetworkData.ADDNEWOBJECT:
                appendLog("new Object");
                NewObjectData newObjectData = (NewObjectData)data;
                System.out.println(newObjectData.getObjectID());
                project.addNewObject(newObjectData.getPageID(), newObjectData.getObjects());
                sendData(newObjectData);
                break;
            case NetworkData.ADDNEWPAGE:
                NewPageData newPageData = (NewPageData)data;
                appendLog("new Page" + " : " + newPageData.getTitle());
                UUID pageID = project.newPage(newPageData.getTitle());
                System.out.println(pageID.toString());
                newPageData.setPageID(pageID);
                sendData(newPageData);
                break;
            case NetworkData.REVISEOBJECT:
                appendLog("revise object");
                ReviseData reviseData = (ReviseData)data;
                System.out.println(reviseData.getObjectID());
                project.reviseObjects(reviseData.getPageID(), reviseData.getObjectID(), reviseData.getReviseData());
                sendData(reviseData);
                break;
            case NetworkData.REMOVEOBJECT:
                appendLog("remove Object");
                RemoveObjectData removeObjectData = (RemoveObjectData)data;
                project.removeObjects(removeObjectData.getPageID(), removeObjectData.getObjectID());
                sendData(removeObjectData);
                break;
            case NetworkData.GETPAGE:
                LoadPageData loadPageData = (LoadPageData)data;
                appendLog("load page : " + loadPageData.getPageID());
                loadPageData.setPage(getProject().getPage(loadPageData.getPageID()));
                loadPageData.setNickName(authority.get(loadPageData.getPageID().toString()));
                clientInfo.sendObject(loadPageData);
                break;
            case NetworkData.GETAUTHORITY:
                AuthorityData authorityData = (AuthorityData)data;
                authorityData.setApproval(!authority.containsKey(authorityData.getPageID()));
                appendLog("get Authority : " + !authority.containsKey(authorityData.getPageID()) + "authority to " + authorityData.getNickName());
                if(!authority.containsKey(authorityData.getPageID().toString())){
                   authority.put(authorityData.getPageID().toString(), authorityData.getNickName());
                   clientInfo.sendObject(authorityData);
                   sendData(new AuthorityToData(authorityData.getPageID(), authorityData.getNickName()));
                }
                break;
            case NetworkData.TEXTBOXTEXT:
                appendLog("eidt TextBox Text");
                TextBoxTextData textBoxTextData = (TextBoxTextData)data;
                project.setText(textBoxTextData.getPageID(), textBoxTextData.getObjectID(), textBoxTextData.getText());
                for(int i = 0; i<getClients().size(); i++){
                    if(getClients().get(i) == clientInfo){
                        continue;
                    }
                    getClients().get(i).sendObject(textBoxTextData);
                }
                break;
            case NetworkData.RELEASEAUTHORITY:
                appendLog("release Authority");
                ReleaseAuthorityData releaseAuthorityData = (ReleaseAuthorityData)data;
                authority.remove(releaseAuthorityData.getPageID().toString());
                sendData(releaseAuthorityData);
                break;
            case NetworkData.SAVE:
                appendLog("server save");
                SaveData saveData = (SaveData)data;
                saveProject(saveData.getName());
                break;
            case NetworkData.PROJECTDATA:
                appendLog("local save");
                ProjectData projectData = (ProjectData)data;
                projectData.setProject(project);
                clientInfo.sendObject(projectData);
                break;
        }
    }
    public void sendPageData(Page page, SocketInfo client){
        ArrayList<Objects> list = page.getObjectsList();
        appendLog("send load page object : " + list.size());
        for(int i = 0; i<list.size(); i++){
            client.sendObject(new NewObjectData(page.getID(), list.get(i)));
            if(list.get(i) instanceof TextBox){
                System.out.println(" " +((TextBox)list.get(i)).getText());
                client.sendObject(new TextBoxTextData(page.getID(), list.get(i).getID(), ((TextBox)list.get(i)).getText()));
            }
        }
    }
    public void sendData(NetworkData data){
        for(int i = 0; i<getClients().size(); i++){
            getClients().get(i).sendObject(data);
        }
    }
    public void close(){
        for(int i = 0; i<getClients().size(); i++){
            getClients().get(i).close();
        }
        try {
            myServerSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void saveProject(){
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        int returnVal = chooser.showSaveDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            //This is where a real application would open the file.
            System.out.println(file.getName());
            try{
                String filePath = file.getAbsolutePath();
                if(!filePath.endsWith(".copm")){
                    filePath += ".copm";
                }
                FileOutputStream fout = new FileOutputStream(filePath);
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(project);
		oos.close();
		appendLog("save Done");
	   }catch(Exception ex){
		   ex.printStackTrace();
	   }
        } else {
            appendLog("no choose");
        }
    }
}
