/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copm.model.component;

import java.awt.Cursor;
import java.awt.Graphics;
import java.io.Serializable;
import java.util.UUID;

/**
 *
 * @author Arsene holmes
 */
public abstract class Objects implements Serializable{
    
    public final static int TEXTBOX = 0;
    public final static int OVAL = 1;
    public final static int RECTANGLE = 2;
    public final static int LINE = 3;
    
    protected int x, y, width, height;
    protected int shape;
    protected UUID objectID = UUID.randomUUID();
    
    public Objects(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    public void revise(int[] resizeData) {
        this.x = resizeData[0];
        this.y = resizeData[1];
        this.width = resizeData[2];
        this.height = resizeData[3];
        System.out.printf("width %d height %d\n", width, height);
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    public int getShape(){
        return shape;
    }
    public UUID getID() {
        return objectID;
    }
    public static int[] makeReviseData(int x, int y, int width, int height){
        int[] tmp = new int[4];
        tmp[0] = x;
        tmp[1] = y;
        tmp[2] = width;
        tmp[3] = height;
        return tmp;
    }
}
