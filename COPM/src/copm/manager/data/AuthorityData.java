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
public class AuthorityData extends NetworkData implements Serializable{
    private UUID pageID;
    private String nickName;
    private boolean approval;
    
    public AuthorityData(UUID pageID, String nickName){
        super(NetworkData.GETAUTHORITY);
        this.pageID = pageID;
        this.nickName = nickName;
    }
    public UUID getPageID(){
        return pageID;
    }
    public String getNickName(){
        return nickName;
    }
    public boolean getApproval(){
        return approval;
    }
    public void setApproval(boolean approval){
        this.approval = approval;
    }
    
}
