/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copm.Objects;

import copm.container.Page;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;
import java.io.Serializable;

/**
 *
 * @author Arsene holmes
 */
public class Rectangle extends Figures implements Serializable{
    
    public Rectangle(int initX, int initY, int initWidth, int initHeight, Page page, boolean filled , Color color) {
        super(initX, initY, initWidth, initHeight, page, filled, color);
    }
    
    
    @Override
    public void draw(Graphics g){
        g.setColor(getColor());
        if(isItFilled()){
            g.fillRect(getX(), getY(), getWidth(), getHeight());
        }
        else{
            g.drawRect(getX(), getY(), getWidth(), getHeight());
        }
    }
}
