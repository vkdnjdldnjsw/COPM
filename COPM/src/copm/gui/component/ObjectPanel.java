/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copm.gui.component;

import copm.model.component.Objects;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.UUID;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author Arsene holmes
 */
public class ObjectPanel extends JPanel implements ObjectsGUI{
    protected Objects object;
    protected UUID objectID;
    protected int shape;
    
    public ObjectPanel(Objects object, int shape){
        super();
        this.object = object;
        this.objectID = object.getID();
        this.shape = shape;
        this.setBounds(object.getX(), object.getY(), object.getWidth(), object.getHeight());
        setOpaque(false);
    }
    
    @Override
    public void draw(Graphics g) {
        System.out.println("draw TextBox :" + getX() + " " + getY() + " " + getWidth() + " " + getHeight());
        super.setBounds(object.getX(), object.getY(), object.getWidth(), object.getHeight());
    }

    @Override
    public void revise(int[] reviseData) {
        object.revise(reviseData);
        int x = reviseData[0], y = reviseData[1], width = reviseData[2], height = reviseData[3];
        setBounds(x, y, width, height);
        System.out.printf("revise : x %d y %d width %d height %d\n",getX(), getY(),  getWidth(), getHeight());
    }

    @Override
    public void setFocuse(boolean bool) {
        System.out.println(" focuse " + bool);
        if(bool){
            requestFocus();
            setBorder(BorderFactory.createLineBorder(Color.BLUE));
        }
        else{
            setBorder(BorderFactory.createEmptyBorder());
        }
    }

    @Override
    public UUID getID() {
        return objectID;
    }

    @Override
    public int getShape() {
        return shape;
    }
    
}
