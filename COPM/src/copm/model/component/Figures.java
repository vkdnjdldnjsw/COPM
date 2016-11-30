/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copm.model.component;

import java.awt.Color;
import java.io.Serializable;

/**
 *
 * @author Arsene holmes
 */
public class Figures extends TextBox implements Serializable{
    private boolean filled = true;
    private Color color;
    
    public Figures(int initX, int initY, int initWidth, int initHeight, boolean filled , Color color, int shape) {
        super(initX, initY, initWidth, initHeight);
        this.filled = filled;
        this.color = color;
        this.shape = shape;
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
