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
public class AuthorityToData extends NetworkData implements Serializable{
    private UUID pageID;
    private String nickName;

    public AuthorityToData(UUID pageID, String nickName) {
        super(NetworkData.AUTHORITYTO);
        this.pageID = pageID;
        this.nickName = nickName;
    }
    public UUID getPageID(){
        return pageID;
    }
    public String getNickName(){
        return nickName;
    }
}
