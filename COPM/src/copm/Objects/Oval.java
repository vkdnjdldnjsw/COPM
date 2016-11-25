/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copm.Objects;

import copm.container.Page;
import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

/**
 *
 * @author Arsene holmes
 */
public class Oval extends Figures implements Serializable{

    public Oval(int initX, int initY, int initWidth, int initHeight, Page page, boolean filled, Color color) {
        super(initX, initY, initWidth, initHeight, page, filled, color);
    }
    
    @Override
    public void draw(Graphics g){
        g.setColor(getColor());
        if(isItFilled()){
            g.fillOval(getX(), getY(), getWidth(), getHeight());
        }
        else{
            g.drawOval(getX(), getY(), getWidth(), getHeight());
        }
    }
}
