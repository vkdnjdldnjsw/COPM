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
public class OvalGUI extends FiguresGUI{

    public OvalGUI(Figures f, Client manager) {
        super(f, manager);
        shape = Objects.OVAL;
    }
    
    @Override
    public void paintComponent(Graphics g){
        g.setColor(f.getColor());
        System.out.println("draw Oval");
        if(f.isItFilled()){
            g.fillOval(0,0, textBox.getWidth(), textBox.getHeight());
        }
        else{
            g.drawOval(0,0, textBox.getWidth(), textBox.getHeight());
        }
        super.paintComponent(g);
        
    }
}
