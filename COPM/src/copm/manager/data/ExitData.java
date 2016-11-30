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
public class ExitData extends NetworkData implements Serializable{
    private UUID pageID;
    private boolean authority;

    public ExitData(UUID pageID, boolean authority) {
        super(NetworkData.EXIT);
        this.pageID = pageID;
        this.authority = authority;
    }
    public UUID getPageID(){
        return pageID;
    }
    public boolean getAuthority(){
        return authority;
    }
}
