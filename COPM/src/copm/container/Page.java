/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copm.container;

import copm.Objects.Objects;
import copm.Objects.TextBox;
import copm.mouse_event.PageMouseInputAdapter;
import copm.mouse_event.TextBoxMouseInputAdapter;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.MouseInputAdapter;

/**
 *
 * @author Arsene holmes
 */
public class Page extends JPanel implements Serializable{
    private String title = "";
    private ArrayList<Objects> o = new ArrayList<>();
    private int selectedShape = 0;
    private Color selectedColor = Color.BLACK;
    private int focusNum = -1;
    private boolean filled = false;
    private int pageNum;
    private UUID authorityID = null;
    private String authorityNickName;
    
    public boolean getAuthority(UUID id, String nickName){
        if(authorityID == null){
            authorityID = id;
            authorityNickName = nickName;
            return true;
        }
        return false;
    }
    public boolean isItAuthority(UUID id){
        if(authorityID.compareTo(id) == 0){
            return true;
        }
        return false;
    }
    
    public Page(){
        setLayout(null);
    }
    public void initPage(int pageNum, String title){
        this.title = title;
        this.pageNum = pageNum;
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);  // paint parent's background
        for(int i = 0; i<o.size(); i++){
            o.get(i).draw(g);
        }
        setBackground(Color.WHITE);
    }
    public void setMouseEventInPage(){
        PageMouseInputAdapter A = new PageMouseInputAdapter(this);
        this.addMouseListener(A);
        this.addMouseMotionListener(A);
        for(int i = 0; i< o.size(); i++){
            o.get(i).setMouseInput(this);
        }
    }
    
    public int sizeOfObjects(){
        return o.size();
    }
    public Objects getObjects(int num){
        return o.get(num); 
    }
    public int getSelectedShape() {
        return selectedShape;
    }
    public void setSelectedShape(int selectedShape) {
        this.selectedShape = selectedShape;
    }
    public Color getSelectedColor() {
        return selectedColor;
    }
    public void setSelectedColor(Color selectedColor) {
        this.selectedColor = selectedColor;
    }
    public boolean isItFilled() {
        return filled;
    }
    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setPageNum(int pageNum){
        this.pageNum = pageNum;
    }
    public String getTitle(){
        return title;
    }
    public int getPageNum(){
        return pageNum;
    }
    public void setShape(int select){
        this.selectedShape = select;
    }
    public void setObjectsArrayList(ArrayList<Objects> o){
        this.o = o;
    }
    public int getObjectsNumInArrayList(Objects o){
        return this.o.indexOf(o);
    }
    public void removeObjectsInArrayList(Objects o){
        this.o.remove(o);
    }
    public void addObjects(Objects o){
        super.add((TextBox)o);
        this.o.add(o);
        repaint();
    }
    public int getFocusNum(){
        return focusNum;
    }
    public void setFocusNum(int num){
        focusNum = num;
    }
    public Objects getFocusedObjects(){
        return o.get(focusNum);
    }
    public void reviseObjects(int objectNum, int[] resizeData){
        o.get(objectNum).revise(resizeData);
    }
}
