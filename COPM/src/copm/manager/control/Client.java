/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copm.manager.control;

import copm.model.container.Page;
import copm.model.container.Project;
import copm.gui.frame.ClientFrame;
import copm.manager.data.AuthorityData;
import copm.manager.data.AuthorityToData;
import copm.manager.data.ExitData;
import copm.manager.data.InitData;
import copm.manager.data.LoadPageData;
import copm.manager.data.NetworkData;
import copm.manager.data.NewObjectData;
import copm.manager.data.NewPageData;
import copm.manager.data.NickNameData;
import copm.manager.data.ReleaseAuthorityData;
import copm.manager.data.RemoveObjectData;
import copm.manager.data.ReviseData;
import copm.manager.data.SocketInfo;
import copm.manager.data.TextBoxTextData;
import copm.model.component.Objects;
import copm.manager.data.ProjectData;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.chart.PieChart;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Arsene holmes
 */
public class Client {
    ClientFrame frame;
    private ServerSocket myServerSocket;
    private Socket mySocket;
    private SocketInfo server;
    private String nickName;
    
    public Client(){
        frame = new ClientFrame();
        frame.init(this);
    }
    public String getNickName(){
        return nickName;
    }
    public void showFrame(){
        frame.showFrame();
    }
    
    public void beClient(String serverIP, int portNum){
        try{
            mySocket = new Socket(serverIP, portNum);
            server = new SocketInfo(mySocket);
            this.nickName = JOptionPane.showInputDialog("Enter nickName");
            InitData initData = (InitData)server.recieveObject();
            ArrayList<String> titles = initData.getTitles();
            ArrayList<UUID> ids = initData.getIds();
            System.out.println("init Pages");
            for(int i = 0; i<ids.size(); i++){
                System.out.println(i + " : " + titles.get(i) + " " + ids.get(i).toString());
                frame.addPageList(titles.get(i), ids.get(i));
            }
            System.out.println("connected");
            Thread ex = new Thread(){
                public void run(){
                    while(true){
                        try {
                            execute(server.recieveObject());
                        } catch (IOException ex1) {
                            JOptionPane.showMessageDialog(null, "server closed");
                            System.exit(0);
                        }
                    }
                }
            };
            ex.start();
            System.out.println("ready to recieve");
        }
        catch(IOException ioex){
            JOptionPane.showMessageDialog(null, "network error : " + ioex.getMessage());
            System.exit(0);
        }
    }
    
    public void loadRequest(UUID id){
        if(id == null){
            System.out.println("null id");
        }
        LoadPageData loadPageData = new LoadPageData(id);
        if(frame.getNowPage() != null && frame.getAuthority()) {
            server.sendObject(new ReleaseAuthorityData(frame.getNowPage().getID()));
        }
        server.sendObject(loadPageData);
        System.out.println("load page request ID : " + id.toString());
    }
    
    public synchronized void execute(NetworkData data){
        switch(data.getCommand()){
            case NetworkData.ADDNEWOBJECT:
                NewObjectData newObjectData = (NewObjectData)data;
                if(frame.getNowPage() == null || frame.getNowPage().getID().compareTo(newObjectData.getPageID()) != 0){
                    return;
                }
                System.out.println("add New object");
                frame.addNewObject(newObjectData.getObjects());
                break;
            case NetworkData.ADDNEWPAGE:
                System.out.println("add new page");
                NewPageData newPageData = (NewPageData)data;
                frame.addPageList(newPageData.getTitle(), newPageData.getPageID());
                break;
            case NetworkData.GETAUTHORITY:
                System.out.println("get Page authority");
                AuthorityData authorityData = (AuthorityData)data;
                frame.setAuthority(authorityData.getApproval());
                break;
            case NetworkData.AUTHORITYTO:
                AuthorityToData authorityToData = (AuthorityToData)data;
                if(frame.getNowPage() == null || frame.getNowPage().getID().compareTo(authorityToData.getPageID()) != 0){
                    return;
                }
                System.out.println("pageID : " + authorityToData.getPageID() + " " +"authority to : " + authorityToData.getNickName());
                frame.authorityTo(authorityToData.getNickName());
                break;
            case NetworkData.RELEASEAUTHORITY:
                ReleaseAuthorityData releaseAuthorityData = (ReleaseAuthorityData)data;
                if(frame.getNowPage() == null || frame.getNowPage().getID().compareTo(releaseAuthorityData.getPageID()) != 0){
                    return;
                }
                System.out.println("release authority");
                frame.setAuthority(false);
                frame.authorityTo(null);
                break;
            case NetworkData.REVISEOBJECT:
                ReviseData reviseData = (ReviseData)data;
                if(frame.getNowPage() == null || frame.getNowPage().getID().compareTo(reviseData.getPageID()) != 0){
                    return;
                }
                System.out.println("revise object");
                frame.reviseObject( reviseData.getObjectID(), (int[])reviseData.getReviseData());
                break;
            case NetworkData.GETPAGE:
                System.out.println("get page");
                LoadPageData loadPageData = (LoadPageData)data;
                frame.loadPage(loadPageData.getPage());
                frame.authorityTo(loadPageData.getNickName());
                break;
            case NetworkData.REMOVEOBJECT:
                RemoveObjectData removeObjectData = (RemoveObjectData)data;
                if(frame.getNowPage() == null || frame.getNowPage().getID().compareTo(removeObjectData.getPageID()) != 0){
                    return;
                }
                System.out.println("remove object");
                frame.removeObject(removeObjectData.getObjectID());
                break;
            case NetworkData.TEXTBOXTEXT:
                TextBoxTextData textBoxTextData = (TextBoxTextData)data;
                if(frame.getNowPage() == null || frame.getNowPage().getID().compareTo(textBoxTextData.getPageID()) != 0){
                    return;
                }
                System.out.println("set text box text");
                frame.setText(textBoxTextData.getObjectID(), textBoxTextData.getText());
                break;
            case NetworkData.PROJECTDATA:
                ProjectData projectData = (ProjectData)data;
                saveProject(projectData.getProject());
                break;
        }
    }
    public void sendData(NetworkData data){
        server.sendObject(data);
    }
    public ClientFrame getFrame(){
        return frame;
    }
    public void close(){
        if(frame.getNowPage() == null){
            sendData(new ExitData(null, frame.getAuthority()));
        }
        else{
            sendData(new ExitData(frame.getNowPage().getID(), frame.getAuthority()));
        }
        server.close();
    }
    public void saveProject(Project project){
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
		System.out.println("Done");
	   }catch(Exception ex){
		   ex.printStackTrace();
	   }
        } else {
            System.out.println("no choose");
        }
    }
}
