/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copm;

import copm.frame.ProjectFrame;
import copm.Objects.Objects;
import copm.container.*;
import copm.network.NetworkData;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.UUID;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Arsene holmes
 */
public class COPM {
    /**
     * @param args the command line arguments
     */
    ProjectFrame frame;
    Project project;
    
    public COPM(){
        Object[] options = {"Server", "Client"};
        int n = JOptionPane.showOptionDialog(null,"option","Choice",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
            null,options,options[1]);
        if(n == 0){
            initProject();
        }
        else{
            openProject();
        }
    }
    
    public void showFrame(){
        frame = new ProjectFrame();
        frame.init(project, this);
        frame.setSize(600,600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void initProject(){
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
    public void getMouseInput(int pageNum){
        project.setMouseInput(pageNum);
    }
    public void newProject(){
        project = new Project();
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
                project.initProject();
                ois.close();
            }catch(Exception ex){
                
                   ex.printStackTrace();
            }
        }
        else{
            newProject();
        }
    }
    public void setProject(Project project){
        this.project = project;
        project.initProject();
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
                
		System.out.println("Done");
	   }catch(Exception ex){
		   ex.printStackTrace();
	   }
        } else {
            System.out.println("no choose");
        }
    }
    
    public void addObject(int pageNum, Objects objects){
        project.addObject(pageNum, objects);
    }
    public void reviseObject(int pageNum, int objectNum, int[] reviseData){
        project.reviseObject(pageNum, objectNum, reviseData);
    }
    public void newPage(String title){
        frame.addPageList(project.addNewPage(title));
    }
    public boolean isItAuthorited(int pageNum, UUID id){
        return project.isItAuthorited(pageNum, id);
    }
    public boolean getAuthority(int pageNum, UUID id, String nickName){
        return project.getAuthority(pageNum, id, nickName);
    }
    public Project getProject(){
        return project;
    }
}
