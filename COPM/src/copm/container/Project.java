/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copm.container;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;
import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseMotionListener;
import copm.Objects.Objects;
import copm.COPM;
import copm.mouse_event.PageMouseInputAdapter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 *
 * @author Arsene holmes
 */
public class Project implements Serializable{
    ArrayList<Page> list = new ArrayList<>();
    
    public void initProject(){
        System.out.printf("page Number : %d\n", list.size());
        for(int i = 0; i<list.size(); i++){
            System.out.println("adddmouseinpage");
            list.get(i).setMouseEventInPage();
        }
    }
    public void setMouseInput(int pageNum){
        list.get(pageNum).setMouseEventInPage();
    }
    public ArrayList<Page> getList(){
        return list;
    }
    public Page addNewPage(String title){
        System.out.println("new page");
        Page tmp = new Page();
        tmp.initPage(list.size(), title);
        tmp.setMouseEventInPage();
        addPage(tmp);
        return tmp;
    }
    public void addPage(Page page){
        list.add(page);
    }
    public Page getPage(int num){
        return list.get(num);
    }
    public void addObject(int pageNum, Objects object){
        list.get(pageNum).addObjects(object);
    }
    public void reviseObject(int pageNum, int ObjectNum, int[] resizeData){
        list.get(pageNum).reviseObjects(ObjectNum, resizeData);
    }
    public boolean isItAuthorited(int pageNum, UUID id){
        return list.get(pageNum).isItAuthority(id);
    }
    public boolean getAuthority(int pageNum, UUID id, String nickName){
        return list.get(pageNum).getAuthority(id, nickName);
    }
}
