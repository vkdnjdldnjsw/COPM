/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copm.Objects;

import copm.container.Page;
import copm.mouse_event.TextBoxMouseInputAdapter;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.Serializable;
import javax.swing.BorderFactory;
import javax.swing.JTextField;

/**
 *
 * @author Arsene holmes
 */
public class TextBox extends JTextField implements Objects, Serializable{
    boolean focus = false;
    public TextBox(int initX, int initY, int initWidth, int initHeight){
        setHorizontalAlignment(JTextField.CENTER);
        setOpaque(false);
        setBounds(initX, initY, initWidth, initHeight);
    }
    @Override
    public void setMouseInput(Page page){
        TextBoxMouseInputAdapter A = new TextBoxMouseInputAdapter(this, page);
        addMouseListener(A);
        addMouseMotionListener(A);
    }
    @Override
    public void setFocuse(boolean isItFocus) {
        this.focus = isItFocus;
        System.out.println(getText() + " focuse " + focus);
        if(isItFocus){
            setBorder(BorderFactory.createLineBorder(Color.BLUE));
        }
        else{
            setBorder(BorderFactory.createEmptyBorder());
            setEdit(false);
        }
    }
    @Override
    public void draw(Graphics g) {
        super.setBounds(getX(), getY(), getWidth(), getHeight());
    }

    
    public static int[] makeReviseData(int x, int y, int width, int height){
        int[] tmp = new int[4];
        tmp[0] = x;
        tmp[1] = y;
        tmp[2] = width;
        tmp[3] = height;
        return tmp;
    }
    @Override
    public void revise(int[] resizeData) {
        int x = resizeData[0], y = resizeData[1], width = resizeData[2], height = resizeData[3];
        System.out.printf("width %d height %d\n", width, height);
        setBounds(x, y, width, height);
        setFont(new Font("Default", 0, Integer.min(width, height)));
    }
    
    public void setEdit(boolean editable){
        super.setEditable(editable);
        super.getCaret().setVisible(editable);
    }

    public boolean isItFocus(){
        return focus;
    }
}

