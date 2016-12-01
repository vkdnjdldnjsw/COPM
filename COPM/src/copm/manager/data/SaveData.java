/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copm.manager.data;

import java.io.Serializable;

/**
 *
 * @author Arsene holmes
 */
public class SaveData extends NetworkData implements Serializable{
    private String name;

    public SaveData(String name) {
        super(NetworkData.SAVE);
        this.name = name;
    }
    public String getName(){
        return name;
    }
    
    public String getStringCommand(){
        return "save";
    }
}
