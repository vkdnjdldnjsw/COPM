/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copm.model.component;

import java.awt.Color;

/**
 *
 * @author Arsene holmes
 */
public class Line extends Objects {
    private Color color;
    public Line(int x, int y, int width, int height, Color color) {
        super(x, y, width, height);
        this.color = color;
        this.shape = Objects.LINE;
    }
    public void setColor(Color color) {
        color = color;
    }
    public Color getColor() {
        return color;
    }
}
