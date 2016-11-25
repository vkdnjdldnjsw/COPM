/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copm.frame;

import copm.container.Page;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JToggleButton;

/**
 *
 * @author Arsene holmes
 */
public class pageListButton extends JToggleButton implements ActionListener{
    Page page;
    ProjectFrame frame;
    public pageListButton(Page page, ProjectFrame frame){
        super(page.getTitle());
        this.page = page;
        this.frame = frame;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(page.getTitle());
        frame.loadPage(page);
    }
}
