/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copm.manager.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author Arsene holmes
 */
public class InitData extends NetworkData implements Serializable{
    private ArrayList<String> titles;
    private ArrayList<UUID> ids;
    
    public InitData(ArrayList<String> titles, ArrayList<UUID> ids) {
        super(NetworkData.INIT);
        this.titles = titles;
        this.ids = ids;
    }
    public ArrayList<String> getTitles(){
        return titles;
    }
    public ArrayList<UUID> getIds(){
        return ids;
    }
}
