/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copm.manager.data;

import java.io.Serializable;
import java.util.UUID;

/**
 *
 * @author Arsene holmes
 */
public class ReviseData extends NetworkData implements Serializable{
    private UUID pageID;
    private UUID objectID;
    private int[] reviseData;
    
    public ReviseData(UUID pageID, UUID objectID, int[] reviseData) {
        super(NetworkData.REVISEOBJECT);
        this.pageID = pageID;
        this.objectID = objectID;
        this.reviseData = reviseData;
    }
    public UUID getPageID(){
        return pageID;
    }
    public UUID getObjectID(){
        return objectID;
    }
    public int[] getReviseData(){
        return reviseData;
    }
    
    public String getStringCommand(){
        return "revise object";
    }
}
