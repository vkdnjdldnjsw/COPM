/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copm.gui.component;

import copm.manager.control.Client;
import copm.model.component.Figures;
import copm.model.component.Objects;
import java.awt.Graphics;

/**
 *
 * @author Arsene holmes
 */
public class RectangleGUI extends FiguresGUI{
    
    public RectangleGUI(Figures f, Client manager) {
        super(f, manager);
        shape = Objects.RECTANGLE;
    }
    
    @Override
    public void paintComponent(Graphics g){
        g.setColor(f.getColor());
        System.out.println("draw Rectangle ");
        if(f.isItFilled()){
            g.fillRect(0, 0, textBox.getWidth(), textBox.getHeight());
        }
        else{
            g.drawRect(0, 0, textBox.getWidth()-1, textBox.getHeight()-1);
        }
        super.paintComponent(g);
    }
}
