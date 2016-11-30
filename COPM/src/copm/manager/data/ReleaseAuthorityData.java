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
public class ReleaseAuthorityData extends NetworkData implements Serializable{
    private UUID pageID;
    
    public ReleaseAuthorityData(UUID pageID) {
        super(NetworkData.RELEASEAUTHORITY);
        this.pageID = pageID;
    }
    public UUID getPageID(){
        return pageID;
    }
    
}
