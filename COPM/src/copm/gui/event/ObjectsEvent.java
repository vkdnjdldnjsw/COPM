/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copm.gui.event;

import copm.model.container.Page;
import copm.gui.component.ObjectsGUI;
import copm.gui.component.PagePanel;
import copm.gui.component.TextBoxGUI;
import copm.manager.control.Client;
import copm.manager.data.NetworkData;
import copm.manager.data.RemoveObjectData;
import copm.manager.data.ReviseData;
import copm.model.component.Objects;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.event.MouseInputAdapter;

/**
 *
 * @author Arsene holmes
 */
public class ObjectsEvent extends MouseInputAdapter{
    protected ObjectsGUI object;
    protected Client manager;
    protected int mInitX, mInitY;
    protected boolean pressed = false;
    protected int initX, initY, initWidth, initHeight;
    
    public ObjectsEvent(ObjectsGUI object, Client manager){
        this.object = object;
        this.manager = manager;
    }
    
     @Override
    public void mousePressed(MouseEvent e){
        System.out.println("Object clicked");
        if(!manager.getFrame().getAuthority()){
            return;
        }
        if(manager.getFrame().getNowPage().getFocuseObjects()!= null){
            manager.getFrame().getNowPage().getFocuseObjects().setFocuse(false);
        }
        manager.getFrame().getNowPage().setFocueObjects(object);
        object.setFocuse(true);
        object.setCursor(Cursor.getPredefinedCursor(PageEvent.getCursor(e.getX(), e.getY(), 0, 0, object.getWidth(), object.getHeight())));
        mInitX = e.getXOnScreen();
        mInitY = e.getYOnScreen();
        initX = object.getX();
        initY = object.getY();
        initWidth = object.getWidth();
        initHeight = object.getHeight();
        pressed = true;
    }
    @Override
    public void mouseDragged(MouseEvent e){
        if(!manager.getFrame().getAuthority()){
            return;
        }
        if(!pressed){
            return;
        }
        int x = initX, y = initY, width = initWidth, height = initHeight;
        int ex = e.getXOnScreen() - mInitX, ey = e.getYOnScreen() - mInitY;
        
        if(object.getCursor().getType() == PageEvent.cursors[0]){
            System.out.println("move");
            x += ex;
            y += ey;
        }
        else{
            System.out.println("resize");
            int cur = object.getCursor().getType();
            if(cur == PageEvent.cursors[1] || cur == PageEvent.cursors[7] || cur == PageEvent.cursors[8]){
                x += ex;
                width -= ex;
            }
            if(cur == PageEvent.cursors[1] || cur == PageEvent.cursors[2] || cur == PageEvent.cursors[3]){
                y += ey;
                height -= ey;
            }
            if(cur == PageEvent.cursors[3] || cur == PageEvent.cursors[4] || cur == PageEvent.cursors[5]){
                width += ex;
            }
            if(cur == PageEvent.cursors[5] || cur == PageEvent.cursors[6] || cur == PageEvent.cursors[7]){
                height += ey;
            }
        }
        manager.sendData(new ReviseData(manager.getFrame().getNowPage().getID(), object.getID(), Objects.makeReviseData(x, y, width, height)));
        manager.getFrame().getNowPage().repaint();
    }
     @Override
    public void mouseReleased(MouseEvent e) {
        if(!manager.getFrame().getAuthority()){
            return;
        }
        if(e.isPopupTrigger()){
            System.out.println("remove");
            JPopupMenu popupRemove = new JPopupMenu();
            JMenuItem remove = new JMenuItem("remove");
            remove.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    manager.sendData(new RemoveObjectData(manager.getFrame().getNowPage().getID(), manager.getFrame().getNowPage().getFocuseObjects().getID()));
                }
            });
            popupRemove.add(remove);
            popupRemove.show((Component)object, e.getX(), e.getY());
        }
        pressed = false;
        object.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        if(object.getWidth() <= 0 || object.getHeight() <= 0){
            System.out.println("remove");
            manager.sendData(new RemoveObjectData(manager.getFrame().getNowPage().getID(), manager.getFrame().getNowPage().getFocuseObjects().getID()));
        }
        System.out.println(manager.getFrame().getNowPage().listSize());
    }
}
