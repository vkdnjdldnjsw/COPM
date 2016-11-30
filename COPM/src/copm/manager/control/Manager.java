/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copm.manager.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Arsene holmes
 */
public class Manager {
    public Manager(){
        Object[] options = {"Server", "Client"};
        int n = JOptionPane.showOptionDialog(null,"option","Choice",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
            null,options,options[1]);
        if(n == 0){
            Server server = new Server();
            server.showFrame();
            server.init();
            String portNum = JOptionPane.showInputDialog("Enter portNum");
            try{
            server.beServer(Integer.parseInt(portNum));
            } catch(Exception e){
                JOptionPane.showMessageDialog(null, "no integer port Number");
                System.exit(0);
            }
            server.setServerInfo(portNum);
        }
        else{
            String ipNum = JOptionPane.showInputDialog("Enter ServerIP");
            String portNum = JOptionPane.showInputDialog("Enter portNum");
            
            Client client = new Client();
            try{
            client.beClient(ipNum, Integer.parseInt(portNum));
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "no intger portNum ");
                System.exit(0);
            }
            client.showFrame();
        }
    }
}
