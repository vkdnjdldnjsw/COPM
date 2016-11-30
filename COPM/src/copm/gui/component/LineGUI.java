/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copm.gui.component;

import copm.gui.event.ObjectsEvent;
import copm.gui.event.TextBoxEvent;
import copm.gui.event.TextBoxTextEvent;
import copm.manager.control.Client;
import copm.model.component.Line;
import copm.model.component.Objects;
import java.awt.Graphics;

/**
 *
 * @author Arsene holmes
 */
public class LineGUI extends ObjectPanel{
    
    public LineGUI(Line object, Client manager) {
        super(object, Objects.LINE);
        ObjectsEvent even  = new ObjectsEvent(this, manager);
        addMouseListener(even);
        addMouseMotionListener(even);
    }
    @Override
    public void paintComponent(Graphics g){
        g.setColor(((Line)object).getColor());
        System.out.println("draw Rectangle ");
        g.drawLine(5, 5, ((Line)object).getWidth()-5, ((Line)object).getHeight()-5);
        super.paintComponent(g);
    }
}
