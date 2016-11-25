/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copm.network;

import copm.COPM;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arsene holmes
 */
public class SocketInfo extends Thread {
    UUID uid;
    String nickName;
    public ObjectOutputStream objectSender;
    public ObjectInputStream ObjectReciever;
    
    public SocketInfo(Socket socket){
        uid = UUID.randomUUID();
        this.nickName = nickName;
        try {
            objectSender = new ObjectOutputStream(socket.getOutputStream());
            ObjectReciever = new ObjectInputStream(socket.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(SocketInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void sendObject(NetworkData data){
        try {
            data.setID(uid);
            objectSender.writeObject(data);
        } catch (IOException ex) {
            Logger.getLogger(Network.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public NetworkData recieveObject(){
        try {
            return (NetworkData)ObjectReciever.readObject();
        } catch (IOException ex) {
            Logger.getLogger(SocketInfo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SocketInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void close(){
        try {
            objectSender.close();
            ObjectReciever.close();
        } catch (IOException ex) {
            Logger.getLogger(Network.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
