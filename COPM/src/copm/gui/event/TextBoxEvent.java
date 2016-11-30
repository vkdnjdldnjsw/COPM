/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copm.gui.event;

import copm.gui.component.ObjectsGUI;
import copm.gui.component.TextBoxGUI;
import copm.manager.control.Client;
import copm.model.component.TextBox;
import java.awt.event.MouseEvent;

/**
 *
 * @author Arsene holmes
 */
public class TextBoxEvent extends ObjectsEvent{
    
    public TextBoxEvent(ObjectsGUI object, Client manager) {
        super(object, manager);
        ((TextBoxGUI)object).setEdit(false);
    }
    
    @Override
    public void mousePressed(MouseEvent e){
        if(!manager.getFrame().getAuthority()){
            return;
        }
        if(e.getClickCount() == 2){
            ((TextBoxGUI)object).setEdit(true);
            return;
        }
        super.mousePressed(e);
    }
}
