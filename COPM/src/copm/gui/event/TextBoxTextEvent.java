/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copm.gui.event;

import copm.gui.component.TextBoxGUI;
import copm.manager.control.Client;
import copm.manager.data.TextBoxTextData;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Arsene holmes
 */
public class TextBoxTextEvent implements DocumentListener{
    private TextBoxGUI object;
    private Client manager;
    public TextBoxTextEvent(TextBoxGUI object, Client manager){
        this.object = object;
        this.manager = manager;
    }
    
    @Override
    public void insertUpdate(DocumentEvent e) {
        if(!manager.getFrame().getAuthority()){
            return;
        }
        sendData();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        if(!manager.getFrame().getAuthority()){
            return;
        }
        sendData();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        
    }
    public void sendData(){
        System.out.println("text changed : " + object.getText());
        manager.sendData(new TextBoxTextData(manager.getFrame().getNowPage().getID(), object.getID(), object.getText()));
    }
    
}
