/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copm.gui.event;

import copm.model.component.Objects;
import copm.model.component.Figures;
import copm.model.component.TextBox;
import copm.model.container.Page;
import copm.gui.component.ObjectsGUI;
import copm.gui.component.PagePanel;
import copm.gui.frame.ClientFrame;
import copm.gui.component.TextBoxGUI;
import copm.manager.control.Manager;
import copm.manager.control.Client;
import copm.model.component.Line;
import copm.manager.data.NetworkData;
import copm.manager.data.NewObjectData;
import copm.manager.data.RemoveObjectData;
import copm.manager.data.ReviseData;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputAdapter;

/**
 *
 * @author Arsene holmes
 */
public class PageEvent extends MouseInputAdapter{
    public final static int cursors[] = {
        Cursor.MOVE_CURSOR, Cursor.NW_RESIZE_CURSOR, Cursor.N_RESIZE_CURSOR,
        Cursor.NE_RESIZE_CURSOR, Cursor.E_RESIZE_CURSOR, Cursor.SE_RESIZE_CURSOR,
        Cursor.S_RESIZE_CURSOR, Cursor.SW_RESIZE_CURSOR, Cursor.W_RESIZE_CURSOR, 
    };
    private int mInitX, mInitY, initX, initY;
    boolean pressed = false;
    Client manager;
    ClientFrame frame;
    
    public PageEvent(Client manager){
        this.manager = manager;
        this.frame = manager.getFrame();
    }
    
    @Override
    public void mousePressed(MouseEvent e){
        System.out.println("Clicked, active : " + manager.getFrame().getAuthority());
        if(!manager.getFrame().getAuthority()){
            return;
        }
        pressed = true;
        PagePanel pagePanel = frame.getNowPage();
        if(pagePanel.getFocuseObjects() != null){
            pagePanel.getFocuseObjects().setFocuse(false);
        }
        Objects tmp = null;
        switch(frame.getSelectedShape()){
            case Objects.TEXTBOX:
                tmp = new TextBox(e.getX(), e.getY(), 0, 0);
                break;
            case Objects.OVAL:
                tmp = new Figures(e.getX(), e.getY(), 0, 0, frame.isItFilled(),frame.getSelectedColor(),frame.getSelectedShape());
                break;
            case Objects.RECTANGLE:
                tmp = new Figures(e.getX(), e.getY(), 0, 0, frame.isItFilled(),frame.getSelectedColor(),frame.getSelectedShape());
                break;
            case Objects.LINE:
                tmp = new Line(e.getX(), e.getY(), 0, 0, frame.getSelectedColor());
                break;
            default:
                System.out.println("Nop");
                break;
        }
        manager.sendData(new NewObjectData(frame.getNowPage().getID(), tmp));
        frame.getNowPage().setCursor(Cursor.getPredefinedCursor(PageEvent.getCursor(e.getX(), e.getY(), tmp.getX(), tmp.getY(), tmp.getWidth(), tmp.getHeight())));
        mInitX = e.getXOnScreen();
        mInitY = e.getYOnScreen();
        initX = e.getX();
        initY = e.getY();
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
        
        ObjectsGUI objects = frame.getNowPage().getFocuseObjects();
        if(objects == null){
            return;
        }
//        int x = objects.getX(), y = objects.getY(), width = objects.getWidth(), height = objects.getHeight();

        int x = initX, y = initY, width = 0, height = 0;
        int ex = e.getXOnScreen() - mInitX, ey = e.getYOnScreen() - mInitY;
        width += ex;
        height += ey;
        System.out.printf("resize : x %d y %d width %d height %d mX mY\n", x,y,width,height);
        System.out.println(frame.getNowPage().getObjectsNum(objects));
        manager.sendData(new ReviseData(frame.getNowPage().getID(), objects.getID(), Objects.makeReviseData(x, y, width, height)));

//            mInitX = e.getXOnScreen();
//            mInitY = e.getYOnScreen();
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
        if(!manager.getFrame().getAuthority()){
            return;
        }
        pressed = false;
        frame.getNowPage().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        if(frame.getNowPage().getFocuseObjects().getWidth() <= 0 || frame.getNowPage().getFocuseObjects().getHeight() <= 0){
            System.out.println("remove");
            manager.sendData(new RemoveObjectData(frame.getNowPage().getID(), frame.getNowPage().getFocuseObjects().getID()));
        }
        System.out.println(frame.getNowPage().listSize());
    }
    public boolean isItPressed(){
        return pressed;
    }
    
    public static int getCursor(int ex, int ey, int x, int y, int width, int height){
        int side = 3;
        if(ex > x + width - side && ex < x + width + side){
            if(ey > y + height - side && ey < y + height + side){
                return cursors[5];
            }
            else if(ey > y - side && ey < y + side){
                return cursors[3];
            }
            return cursors[4];
        }
        else if(ex > x - side && ex < x + side){
            if(ey > y - side && ey < y + side){
                return cursors[1];
            }
            else if(ey > y + height - side && ey < y + height + side){
                return cursors[7];
            }
            return cursors[8];
        }
        
        if(ey > y - side && ey < y + side){
            return cursors[2];
        }
        else if(ey > y + height - side && ey < y + height + side){
            return cursors[6];
        }
        return cursors[0];
    }
}
