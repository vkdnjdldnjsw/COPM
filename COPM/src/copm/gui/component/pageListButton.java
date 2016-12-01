/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copm.gui.component;

import copm.model.container.Page;
import copm.manager.control.Client;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;
import javax.swing.BorderFactory;
import javax.swing.JToggleButton;

/**
 *
 * @author Arsene holmes
 */
public class pageListButton extends JToggleButton implements ActionListener{
    UUID pageID;
    Client manager;
    public pageListButton(UUID pageID, String title, Client manager){
        super(title);
        this.pageID = pageID;
        this.manager = manager;
        setBackground(Color.WHITE);
        setForeground(Color.BLACK);
        addActionListener(this);
        setBorderPainted(false);
        setPreferredSize(new Dimension(100, getHeight()));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("clicked : " +getText()+" ID : " + pageID.toString());
        manager.loadRequest(pageID);
    }
}
