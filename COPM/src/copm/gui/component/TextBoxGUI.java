/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copm.gui.component;

import copm.gui.event.TextBoxEvent;
import copm.gui.event.TextBoxTextEvent;
import copm.manager.control.Client;
import copm.model.component.Objects;
import copm.model.component.TextBox;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.TextEvent;
import java.util.UUID;
import javax.swing.BorderFactory;
import javax.swing.JTextField;

/**
 *
 * @author Arsene holmes
 */
public class TextBoxGUI  extends JTextField implements ObjectsGUI{
    protected TextBox textBox;
    protected int shape;
    protected UUID objectID;
    public TextBoxGUI(TextBox textBox, Client manager){
        this.textBox = textBox;
        setBounds(textBox.getX(), textBox.getY(), textBox.getWidth(), textBox.getHeight());
        setHorizontalAlignment(JTextField.CENTER);
        setOpaque(false);
        setFont(new Font("Default", 0, Integer.min(getWidth(), getHeight())));
        this.shape = Objects.TEXTBOX;
        this.objectID = textBox.getID();
        TextBoxEvent even  = new TextBoxEvent(this, manager);
        addMouseListener(even);
        addMouseMotionListener(even);
        getDocument().addDocumentListener(new TextBoxTextEvent(this, manager));
    }
    
    @Override
    public void setFocuse(boolean focuse){
        System.out.println(getText() + " focuse " + focuse);
        if(focuse){
            requestFocus();
            setBorder(BorderFactory.createLineBorder(Color.BLUE));
        }
        else{
            setBorder(BorderFactory.createEmptyBorder());
            setEdit(false);
        }
    }
    public void revise(int[] reviseData) {
        textBox.revise(reviseData);
        int x = reviseData[0], y = reviseData[1], width = reviseData[2], height = reviseData[3];
        setBounds(x, y, width, height);
        setFont(new Font("Default", 0, Integer.min(width, height)));
        System.out.printf("revise : x %d y %d width %d height %d\n",getX(), getY(),  getWidth(), getHeight());
    }

    @Override
    public void draw(Graphics g) {
        System.out.println("draw TextBox :" + getX() + " " + getY() + " " + getWidth() + " " + getHeight());
        super.setBounds(textBox.getX(), textBox.getY(), textBox.getWidth(), textBox.getHeight());
    }
    
    public UUID getID(){
        return objectID;
    }
            
    public void setEdit(boolean editable){
        super.setEditable(editable);
        super.getCaret().setVisible(editable);
    }

    @Override
    public int getShape() {
        return shape;
    }
}
