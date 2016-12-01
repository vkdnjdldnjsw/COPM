/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copm.manager.data;

import java.util.UUID;

/**
 *
 * @author Arsene holmes
 */
public class RemoveObjectData extends NetworkData{
    
    private UUID pageID;
    private UUID objectID;
    
    public RemoveObjectData(UUID pageID, UUID objectiD) {
        super(NetworkData.REMOVEOBJECT);
        this.pageID = pageID;
        this.objectID = objectiD;
    }
    public UUID getPageID(){
        return pageID;
    }
    public UUID getObjectID(){
        return objectID;
    }
    
    public String getStringCommand(){
        return "remove object";
    }
}
