/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copm.Objects;

import copm.container.Page;
import java.awt.Color;
import java.io.Serializable;
import javax.swing.BorderFactory;

/**
 *
 * @author Arsene holmes
 */
public abstract class Figures extends TextBox implements Serializable{
    private boolean filled = true;
    private Color color;
    
    public Figures(int initX, int initY, int initWidth, int initHeight, Page page, boolean filled , Color color) {
        super(initX, initY, initWidth, initHeight);
        this.filled = filled;
        this.color = color;
    }
    
    public void setFill(boolean filled) {
        filled = filled;
    }
    public boolean isItFilled() {
        return filled;
    }
    public void setColor(Color color) {
        color = color;
    }
    public Color getColor() {
        return color;
    }
   
}
