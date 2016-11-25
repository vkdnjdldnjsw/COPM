/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copm.mouse_event;

import copm.Objects.Objects;
import copm.Objects.Oval;
import copm.container.Page;
import copm.Objects.Rectangle;
import copm.Objects.TextBox;
import copm.COPM;
import static copm.mouse_event.PageMouseInputAdapter.cursors;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputAdapter;

/**
 *
 * @author Arsene holmes
 */
public class PageMouseInputAdapter extends MouseInputAdapter{
    
    public final static int cursors[] = {
        Cursor.MOVE_CURSOR, Cursor.NW_RESIZE_CURSOR, Cursor.N_RESIZE_CURSOR,
        Cursor.NE_RESIZE_CURSOR, Cursor.E_RESIZE_CURSOR, Cursor.SE_RESIZE_CURSOR,
        Cursor.S_RESIZE_CURSOR, Cursor.SW_RESIZE_CURSOR, Cursor.W_RESIZE_CURSOR, 
    };
    
    int mInitX, mInitY;
    int objectNum = -1;
    boolean pressed = false;
    protected Page page;
    public PageMouseInputAdapter(Page page) {
        this.page = page;
    }
    @Override
    public void mousePressed(MouseEvent e){
        pressed = true;
        if(page.getFocusNum() != -1){
            page.getFocusedObjects().setFocuse(false);
        }
        mInitX = e.getXOnScreen();
        mInitY = e.getYOnScreen();
        
        Objects tmp;
        switch(page.getSelectedShape()){
            case 1:
                tmp = new Rectangle(e.getX(), e.getY(), 0, 0, page, page.isItFilled(), page.getSelectedColor());
                break;
            case 2:
                tmp = new Oval(e.getX(), e.getY(), 0, 0, page, page.isItFilled(), page.getSelectedColor());
                break;
            default :
                tmp = new TextBox(e.getX(), e.getY(), 0, 0);
                break;
        }
        tmp.setMouseInput(page);
        
        page.addObjects(tmp);
        page.setFocusNum(page.getObjectsNumInArrayList(tmp));
        page.getFocusedObjects().setFocuse(true);
        page.setCursor(Cursor.getPredefinedCursor(PageMouseInputAdapter.getCursor(e.getX(), e.getY(), page.getFocusedObjects().getX(), page.getFocusedObjects().getY(), page.getFocusedObjects().getWidth(), page.getFocusedObjects().getHeight())));
    }
    
    @Override
    public void mouseDragged(MouseEvent e){
        if(!pressed){
            return;
        }
        
        Objects objects = page.getFocusedObjects();
        int x = objects.getX(), y = objects.getY(), width = objects.getWidth(), height = objects.getHeight();
        int ex = e.getXOnScreen() - mInitX, ey = e.getYOnScreen() - mInitY;
        
        System.out.println("resize");
        width += ex;
        height += ey;
        System.out.printf("x %d y %d width %d height %d\n", x,y,width,height);
        objects.revise(TextBox.makeReviseData(x, y, width, height));
        page.repaint();
        mInitX = e.getXOnScreen();
        mInitY = e.getYOnScreen();
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        pressed = false;
        page.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        if(page.getFocusedObjects().getWidth() <= 0 || page.getFocusedObjects().getHeight() <= 0){
            page.removeObjectsInArrayList(page.getFocusedObjects());
            page.setFocusNum(-1);
        }
        System.out.println(page.sizeOfObjects());
    }
    
    public static int getCursor(int ex, int ey, int x, int y, int width, int height){
        int side = 5;
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