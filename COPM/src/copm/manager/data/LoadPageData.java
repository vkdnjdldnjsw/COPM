/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copm.manager.data;

import copm.model.container.Page;
import copm.manager.control.Client;
import java.io.Serializable;
import java.util.UUID;

/**
 *
 * @author Arsene holmes
 */
public class LoadPageData extends NetworkData implements Serializable{
    private UUID pageID;
    private Page page;
    private String nickName;
    
    public LoadPageData(UUID pageID) {
        super(NetworkData.GETPAGE);
        this.pageID = pageID;
    }
    public void setNickName(String nickName){
        this.nickName = nickName;
    }
    public String getNickName(){
        return nickName;
    }
    public void setPage(Page page){
        this.page = page;
    }
    public Page getPage(){
        return page;
    }
    public UUID getPageID(){
        return pageID;
    }
}
