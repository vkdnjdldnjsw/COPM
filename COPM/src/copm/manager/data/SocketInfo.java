/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copm.manager.data;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
            JOptionPane.showMessageDialog(null, "network error : " + ex.getMessage());
            System.exit(0);
        }
    }
    public void sendObject(NetworkData data){
        try {
            objectSender.reset();
            objectSender.writeObject(data);
            objectSender.flush();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "network error : " + ex.getMessage());
            System.exit(0);
        }
    }
    public NetworkData recieveObject() throws IOException {
        try {
            NetworkData tmp = (NetworkData)ObjectReciever.readObject();
            return tmp;
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "network error : " + ex.getMessage());
            System.exit(0);
        }
        return null;
    }
    
    public void close(){
        try {
            objectSender.close();
            ObjectReciever.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "network error : " + ex.getMessage());
            System.exit(0);
        }
    }
}
