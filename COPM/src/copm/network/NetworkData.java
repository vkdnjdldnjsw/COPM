/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copm.network;

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
    
    private UUID id;
    private int command;
    private int pageNum;
    private int objectNum;
    private Object content;
    
    public NetworkData(int command, Object content){
        this.command = command;
        this.content = content;
    }
    public NetworkData(int command,int pageNum, Object content){
        this.command = command;
        this.pageNum = pageNum;
        this.content = content;
    }
    public NetworkData(int command, int pageNum, int objectNum, Object content){
        this.command = command;
        this.pageNum = pageNum;
        this.objectNum = objectNum;
        this.content = content;
    }
    public int getCommand(){
        return command;
    }
    public Object getContent(){
        return content;
    }
    public void setID(UUID id){
        this.id = id;
    }
    public UUID getID(){
        return this.id;
    }
    public int getPageNum(){
        return pageNum;
    }
    public int getObjectNum(){
        return objectNum;
    }
}
