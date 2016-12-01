/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copm.gui.component;

import copm.model.container.Page;
import copm.gui.event.PageEvent;
import copm.gui.event.TextBoxEvent;
import copm.gui.frame.ClientFrame;
import copm.manager.control.Manager;
import copm.manager.control.Client;
import copm.model.component.Figures;
import copm.model.component.Line;
import copm.model.component.Objects;
import copm.model.component.TextBox;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.UUID;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

/**
 *
 * @author Arsene holmes
 */
public class PagePanel extends JPanel{
    private ArrayList<ObjectsGUI> list = new ArrayList<ObjectsGUI>();
    private ClientFrame frame;
    private ObjectsGUI focuseObject = null;
    private PageEvent even = null;
    private boolean active = false;
    private UUID id;
    
    public ObjectsGUI getFocuseObjects(){
        return focuseObject;
    }
    public void setFocueObjects(ObjectsGUI o){
        if(focuseObject != null){
            focuseObject.setFocuse(false);
        }
        if(o == null){
            this.focuseObject = null;
            return;
        }
        this.focuseObject = o;
        o.setFocuse(true);
    }
    public PagePanel(Page page, Client manager){
        System.out.println("page size : " + page.size());
        for(int i = 0; i< page.size(); i++){
            Objects tmp = page.getObject(i);
            System.out.println("shape " + tmp.getShape() + " x " + tmp.getX() + " y " + tmp.getY() + " width " + tmp.getWidth() + " height "+ tmp.getHeight());
            addNewObjects(page.getObject(i), manager);
        }
        this.id = page.getID();
        even  = new PageEvent(manager);
        addMouseListener(even);
        addMouseMotionListener(even);
    }
    public UUID getID(){
        return id;
    }
    public ArrayList<ObjectsGUI> getObjectsList(){
        return list;
    }
    public void removeObjects(UUID id){
        super.remove((Component)getObjects(id));
        if(focuseObject != null && focuseObject.getID().compareTo(id) == 0){
            focuseObject = null;
        }
        list.remove(getObjects(id));
        repaint();
    }
    public void addNewObjects(Objects tmp, Client manager){
        ObjectsGUI o = null;
        switch(tmp.getShape()){
            case Objects.TEXTBOX:
                System.out.println("new TexBox");
                o = new TextBoxGUI((TextBox)tmp, manager);
                ((TextBoxGUI)o).setText(((TextBox)tmp).getText());
                list.add(o);
                add((TextBoxGUI)o);
                break;
            case Objects.OVAL:
                System.out.println("new Oval");
                o = new OvalGUI((Figures)tmp, manager);
                ((TextBoxGUI)o).setText(((TextBox)tmp).getText());
                list.add(o);
                add((OvalGUI)o);
                break;
            case Objects.RECTANGLE:
                System.out.println("new Rect");
                o = new RectangleGUI((Figures)tmp, manager);
                ((TextBoxGUI)o).setText(((TextBox)tmp).getText());
                list.add(o);
                add((RectangleGUI)o);
                break;
            case Objects.LINE:
                System.out.println("new Line");
                o = new LineGUI((Line)tmp, manager);
                list.add(o);
                add((LineGUI)o);
                break;
            default:
                System.out.println("Nop");
                break;
        }
        System.out.println(tmp.toString());
        setFocueObjects(o);
    }
    public void revise(UUID objectID, int[] reviseData){
        getObjects(objectID).revise(reviseData);
    }
    public ObjectsGUI getObjects(UUID id){
        for(int i = 0; i<list.size(); i++){
            if(id.compareTo(list.get(i).getID()) == 0){
                return list.get(i);
            }
        }
        return null;
    }
    @Override
    public void update(Graphics g){
        super.update(g);
        System.out.println("update");
        repaint();
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        System.out.println("painted");
        for(int i = 0; i<list.size(); i++){
            System.out.println("repaint : " + list.get(i).getID());
            list.get(i).draw(g);
        }
        System.out.println("complete painted");
        setBackground(Color.WHITE);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);  // paint parent's background
        for(int i = 0; i<list.size(); i++){
            System.out.println("repaint : " + list.get(i).getID());
            list.get(i).draw(g);
        }
        System.out.println("complete repainted");
        setBackground(Color.WHITE);
    }
    public int listSize(){
        return list.size();
    }
    public int getObjectsNum(ObjectsGUI o){
        return list.indexOf(o);
    }
    public void setText(UUID objectID, String text){
        if(((TextBoxGUI)getObjects(objectID)).getText().compareTo(text) != 0){
            ((TextBoxGUI)getObjects(objectID)).setText(text);
        }
    }
}
