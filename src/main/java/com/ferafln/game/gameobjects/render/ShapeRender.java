/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.game.gameobjects.render;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Fernando Limeira
 */
public class ShapeRender implements Render{

    private final Color color;

    public ShapeRender(Color color) {
        this.color = color;
    }
    
    
    @Override
    public void renderGraphics(Graphics g, Rectangle shape) {
        g.setColor(color);
        g.fillRect(shape.x, shape.y, shape.width, shape.height);
    }
}
