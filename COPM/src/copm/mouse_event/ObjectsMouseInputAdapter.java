/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copm.mouse_event;

import copm.Objects.ObjectPanel;
import copm.Objects.Objects;
import copm.Objects.TextBox;
import copm.container.Page;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

/**
 *
 * @author Arsene holmes
 */
public class ObjectsMouseInputAdapter extends MouseInputAdapter{
    int mInitX, mInitY;
    Objects object;
    boolean pressed = false;
    Page page;
    
    public ObjectsMouseInputAdapter(Objects object, Page page) {
        this.page = page;
        this.object = object;
    }
    
    @Override
    public void mousePressed(MouseEvent e){
        if(page.getFocusNum() != -1){
            page.getFocusedObjects().setFocuse(false);
        }
        page.setFocusNum(page.getObjectsNumInArrayList(object));
        object.setFocuse(true);
        object.setCursor(Cursor.getPredefinedCursor(PageMouseInputAdapter.getCursor(e.getX(), e.getY(), 0, 0, object.getWidth(), object.getHeight())));
        mInitX = e.getXOnScreen();
        mInitY = e.getYOnScreen();
        pressed = true;
    }
    
    @Override
    public void mouseDragged(MouseEvent e){
        if(!pressed){
            return;
        }
        int x = object.getX(), y = object.getY(), width = object.getWidth(), height = object.getHeight();
        int ex = e.getXOnScreen() - mInitX, ey = e.getYOnScreen() - mInitY;
        
        if(object.getCursor().getType() == PageMouseInputAdapter.cursors[0]){
            x += ex;
            y += ey;
        }
        else{
            System.out.println("resize");
            int cur = object.getCursor().getType();
            if(cur == PageMouseInputAdapter.cursors[1] || cur == PageMouseInputAdapter.cursors[7] || cur == PageMouseInputAdapter.cursors[8]){
                x += ex;
                width -= ex;
            }
            if(cur == PageMouseInputAdapter.cursors[1] || cur == PageMouseInputAdapter.cursors[2] || cur == PageMouseInputAdapter.cursors[3]){
                y += ey;
                height -= ey;
            }
            if(cur == PageMouseInputAdapter.cursors[3] || cur == PageMouseInputAdapter.cursors[4] || cur == PageMouseInputAdapter.cursors[5]){
                width += ex;
            }
            if(cur == PageMouseInputAdapter.cursors[5] || cur == PageMouseInputAdapter.cursors[6] || cur == PageMouseInputAdapter.cursors[7]){
                height += ey;
            }
        }
        object.revise(TextBox.makeReviseData(x, y, width, height));
        page.repaint();
        mInitX = e.getXOnScreen();
        mInitY = e.getYOnScreen();
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
        
        pressed = false;
        object.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        if(page.getFocusedObjects().getWidth() <= 0 || page.getFocusedObjects().getHeight() <= 0){
            page.removeObjectsInArrayList(page.getFocusedObjects());
            page.setFocusNum(-1);
        }
        System.out.println(page.sizeOfObjects());
    }
}
