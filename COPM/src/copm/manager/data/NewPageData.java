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
public class NewPageData extends NetworkData implements Serializable{
    private UUID pageID;
    private String title;
    
    public NewPageData(String title) {
        super(NetworkData.ADDNEWPAGE);
        this.title = title;
    }
    public void setPageID(UUID id){
        this.pageID = id;
    }
    public UUID getPageID(){
        return pageID;
    }
    public String getTitle(){
        return title;
    }
    
    public String getStringCommand(){
        return "add new page";
    }
}
