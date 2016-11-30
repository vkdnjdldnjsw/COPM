/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copm.gui.component;

import java.awt.Cursor;
import java.awt.Graphics;
import java.util.UUID;

/**
 *
 * @author Arsene holmes
 */
public interface ObjectsGUI{
    public void draw(Graphics g);
    public void revise(int[] reviseData);
    public void setFocuse(boolean bool);
    public int getX();
    public int getY();
    public int getWidth();
    public int getHeight();
    public UUID getID();
    public int getShape();
    public abstract void setCursor(Cursor cursor);
    public abstract Cursor getCursor();
}
