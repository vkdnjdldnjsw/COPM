/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copm.model.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.Serializable;
import java.util.UUID;
import javax.swing.BorderFactory;
import javax.swing.JTextField;

/**
 *
 * @author Arsene holmes
 */
public class TextBox extends Objects implements   Serializable{
    protected String text ="";
    
    /**
     *
     */
    public TextBox(int x, int y, int width, int height){
        super(x,y,width, height);
        this.shape = Objects.TEXTBOX;
    }
    
    public String getText(){
        return text;
    }
    public void setText(String text){
        this.text = text;
    }
}
