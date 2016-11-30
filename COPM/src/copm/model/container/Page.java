/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copm.model.container;

import copm.model.component.Objects;
import copm.model.component.TextBox;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author Arsene holmes
 */
public class Page implements Serializable{
    private ArrayList<Objects> objectList;
    private String title;
    private UUID id = UUID.randomUUID();
    
    public Page(String title){
        objectList = new ArrayList<Objects>();
        this.title = title;
    }
    public void addNewObject(Objects o){
        objectList.add(o);
    }
    public int getObjectNum(Object o){
        return objectList.indexOf(o);
    }
    public Objects getObject(int num){
        return objectList.get(num);
    }
    public ArrayList<Objects> getObjectsList(){
        return objectList;
    }
    public String getTitle(){
        return title;
    }
    public int size(){
        return objectList.size();
    }
    public void reviseObjects(UUID objectID, int[] reviseData){
        getObjects(objectID).revise(reviseData);
    }
    public Objects getObjects(UUID id){
        for(int i = 0; i<objectList.size(); i++){
            if(id.compareTo(objectList.get(i).getID()) == 0){
                return objectList.get(i);
            }
        }
        System.out.println("no object in Page");
        return null;
    }
    public UUID getID(){
        return id;
    }
    public void setID(UUID id){
        this.id = id;
    }
    public void removeObjects(UUID id){
        objectList.remove(getObjects(id));
    }
    public void setText(UUID objectID, String text){
        ((TextBox)getObjects(objectID)).setText(text);
    }
}
