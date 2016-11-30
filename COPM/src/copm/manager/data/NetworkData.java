/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copm.manager.data;

import com.sun.corba.se.impl.orbutil.closure.Constant;
import java.io.Serializable;
import java.util.UUID;

/**
 *
 * @author Arsene holmes
 */
public class NetworkData implements Serializable{
    public static final int CONNECT = -1;
    public static final int INIT = 0;
    public static final int ADDNEWPAGE = 1;
    public static final int ADDNEWOBJECT = 2;
    public static final int REVISEOBJECT = 3;
    public static final int GETAUTHORITY = 4;
    public static final int GETPAGE = 5;
    public static final int REMOVEOBJECT = 6;
    public static final int EXIT = 7;
    public static final int AUTHORITYTO = 8;
    public static final int RELEASEAUTHORITY = 9;
    public static final int TEXTBOXTEXT = 10;
    public static final int SAVE = 11;
    public static final int PROJECTDATA = 12;
    
    private int command;
    
    public NetworkData(int command){
        this.command = command;
    }
    public int getCommand(){
        return command;
    }
}
