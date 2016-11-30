/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copm.manager.data;

import copm.model.component.Objects;
import java.io.Serializable;
import java.util.UUID;

/**
 *
 * @author Arsene holmes
 */
public class NewObjectData extends NetworkData implements Serializable{
    private UUID pageID;
    private UUID objectID;
    private Objects object;
    
    public NewObjectData(UUID pageID, Objects object) {
        super(NetworkData.ADDNEWOBJECT);
        this.pageID = pageID;
        this.object = object;
    }
    public void setObjectID(UUID id){
        this.objectID = id;
    }
    public UUID getPageID(){
        return pageID;
    }
    public UUID getObjectID(){
        return objectID;
    }
    public Objects getObjects(){
        return object;
    }
}
