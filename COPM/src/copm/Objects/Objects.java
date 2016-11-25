/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copm.Objects;

import copm.container.Page;
import java.awt.Cursor;
import java.awt.Graphics;

/**
 *
 * @author Arsene holmes
 */
public interface Objects{
    public abstract void setFocuse(boolean isItFoucus);
    public abstract void draw(Graphics  g);
    public abstract void revise(int[] reviseData);
    public abstract int getX();
    public abstract int getY();
    public abstract int getWidth();
    public abstract int getHeight();
    public abstract boolean contains(int x, int y);
    public abstract void setMouseInput(Page page);
    public abstract void setCursor(Cursor cursor);
    public abstract Cursor getCursor();
}
