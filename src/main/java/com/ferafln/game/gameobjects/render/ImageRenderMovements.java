/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.game.gameobjects.render;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

/**
 *
 * @author Fernando Limeira
 */
public class ImageRenderMovements implements RenderMovements {

    private Image image;
    private final int height;
    private final int width;
    

    public ImageRenderMovements(Image image, int width, int hight) {
        this.height = hight;
        this.width = width;
        this.image = image;
    }

    @Override
    public void renderGraphics(Graphics g, Rectangle r) {
        synchronized (image) {
            int xi = (r.width / 2) - (width / 2);
            int yi = (r.height / 2) - (height / 2);
            g.drawImage(image, r.x + xi, r.y + yi, width, height, null);
        }
    }
    
    @Override
    public void setImage(Image i){
        this.image = i;
    }

}
