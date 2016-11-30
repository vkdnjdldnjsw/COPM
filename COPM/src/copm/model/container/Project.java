package copm.model.container;

import copm.model.component.Objects;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arsene holmes
 */
public class Project implements Serializable{
    private ArrayList<Page> pageList = new ArrayList<>();
    
    public void addNewObject(UUID pageID, Objects o){
        getPage(pageID).addNewObject(o);
    }
    public int getObjectNum(int pageNum, Object o){
        return pageList.get(pageNum).getObjectNum(o);
    }
    public Objects getObject(int pageNum, int num){
        return pageList.get(pageNum).getObject(num);
    }
    public UUID newPage(String title){
        Page tmp = new Page(title);
        pageList.add(tmp);
        return tmp.getID();
    }
    public Page getPage(UUID id){
        for(int i = 0; i<pageList.size(); i++){
            Page tmp = pageList.get(i);
            if(tmp.getID().compareTo(id) == 0){
                return tmp;
            }
        }
        return null;
    }
    public void reviseObjects(UUID pageID, UUID objectID, int[] reviseData){
        getPage(pageID).reviseObjects(objectID, reviseData);
    }
    public ArrayList<String> getTitles(){
        ArrayList<String> titles = new ArrayList<>();
        for(int i = 0; i<pageList.size(); i++){
            titles.add(pageList.get(i).getTitle());
        }
        return titles;
    }
    public ArrayList<UUID> getIDs(){
        ArrayList<UUID> ids = new ArrayList<>();
        for(int i = 0; i<pageList.size(); i++){
            ids.add(pageList.get(i).getID());
        }
        return ids;
    }
    public void removeObjects(UUID pageID, UUID objectID){
        getPage(pageID).removeObjects(objectID);
    }
    public void setText(UUID pageID, UUID objectID, String text){
        getPage(pageID).setText(objectID, text);
    }
}
