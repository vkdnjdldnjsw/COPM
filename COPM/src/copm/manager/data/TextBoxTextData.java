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
public class TextBoxTextData extends NetworkData{
    private UUID pageID, objectID;
    private String text;

    public TextBoxTextData(UUID pageID, UUID objectID, String text) {
        super(NetworkData.TEXTBOXTEXT);
        this.pageID = pageID;
        this.objectID = objectID;
        this.text = text;
    }
    public UUID getPageID(){
        return pageID;
    }
    public UUID getObjectID(){
        return objectID;
    }
    public String getText(){
        return text;
    }
    
    public String getStringCommand(){
        return "eidt text";
    }
}
