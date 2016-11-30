/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copm.gui.component;

import copm.manager.control.Client;
import copm.model.component.Figures;
import copm.model.component.TextBox;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Arsene holmes
 */
public abstract class FiguresGUI extends TextBoxGUI{
    Figures f;
    public FiguresGUI(Figures f, Client manager) {
        super(f, manager);
        this.f = f;
    }
}
