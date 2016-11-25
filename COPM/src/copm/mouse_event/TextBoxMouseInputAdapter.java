/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copm.mouse_event;

import copm.Objects.Objects;
import copm.container.Page;
import copm.Objects.TextBox;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputAdapter;

/**
 *
 * @author Arsene holmes
 */
public class TextBoxMouseInputAdapter extends ObjectsMouseInputAdapter{

    public TextBoxMouseInputAdapter(TextBox textBox, Page page) {
        super(textBox, page);
    }
    @Override
    public void mousePressed(MouseEvent e){
        if(e.getClickCount() == 2){
            ((TextBox)object).setEdit(true);
            return;
        }
        super.mousePressed(e);
    }
}
