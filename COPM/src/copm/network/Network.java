/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copm.network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import copm.COPM;
import copm.Objects.Objects;
import copm.container.Project;
/**
 *
 * @author Arsene holmes
 */
public class Network {
    private ServerSocket myServerSocket;
    private Socket mySocket;
    public ObjectOutputStream objectSender;
    public ObjectInputStream ObjectReciever;
    private int portNum;
    private  String serverIP;
    private boolean isItServer;
    private ArrayList<SocketInfo> clients = new ArrayList<>();
    private SocketInfo server;
    private COPM copm;
    
    
    public void beServer(int portNum, COPM copm){
        isItServer = true;
        this.copm = copm;
        new Thread(){
            public void run(){
                while(true){
                    try{
                        myServerSocket = new ServerSocket(portNum);
                        mySocket = myServerSocket.accept();
                        SocketInfo tmp = new SocketInfo(mySocket);
                        String name = (String)tmp.recieveObject().getContent();
                        tmp.setName(name);
                        tmp.sendObject(new NetworkData(NetworkData.INIT, copm));
                        clients.add(tmp);
                        new Thread(){
                            public void run(){
                                while(true){
                                    NetworkData data = tmp.recieveObject();
                                    execute(data);
                                    for(int i = 0; i<clients.size(); i++){
                                        clients.get(i).sendObject(data);
                                    }
                                }
                            }
                        };
                    }
                    catch(IOException ioex){
                        System.out.println(ioex);
                    }
                }
            }
        };
        
    }
    
    public void beClient(String serverIP, int portNum, String nickName, COPM copm){
        this.copm = copm;
        isItServer = false;
        this.serverIP = serverIP;
        try{
            mySocket = new Socket(serverIP, portNum);
            SocketInfo controller = new SocketInfo(mySocket);
            controller.sendObject(new NetworkData(NetworkData.CONNECT, nickName));
            copm.setProject((Project)controller.recieveObject().getContent());
            server = controller;
            new Thread(){
                public void run(){
                    while(true){
                        execute(controller.recieveObject());
                    }
                }
            };
        }
        catch(IOException ioex){
            System.out.println(ioex);
        }
    }
    
    public void sendData(NetworkData data){
        server.sendObject(data);
    }
    
    public void execute(NetworkData data){
        switch(data.getCommand()){
            case NetworkData.ADDNEWOBJECT:
                if(!copm.isItAuthorited(data.getPageNum(), data.getID())){
                    return;
                }
                copm.addObject(data.getPageNum(), (Objects)data.getContent());
                break;
            case NetworkData.ADDNEWPAGE:
                copm.newPage((String)data.getContent());
                break;
            case NetworkData.GETAUTHORITY:
                copm.getAuthority(data.getPageNum(), data.getID(), (String)data.getContent());
            case NetworkData.REVISEOBJECT:
                if(!copm.isItAuthorited(data.getPageNum(), data.getID())){
                    return;
                }
                copm.reviseObject(data.getPageNum(), data.getObjectNum(), (int[])data.getContent());
                break;
        }
    }
}
