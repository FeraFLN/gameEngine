/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.game.gameobjects.render;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Fernando Limeira
 */
public class ImageRender implements Render {

    private Image image;

    private final int height;
    private final int width;
    private int index = 0;

    public ImageRender(Image image, int width, int hight) {
        this.height = hight;
        this.width = width;
        this.image = image;
    }

    @Override
    public void renderGraphics(Graphics g, Rectangle r) {
        synchronized (image) {
            int xi = (r.width / 2) - (width / 2);
            int yi = (r.height / 2) - (height / 2);
            g.drawImage(getImage(), r.x + xi, r.y + yi, width, height, null);
//        g.setColor(Color.RED);
//        g.fillRect(r.x, r.y, r.width, r.height);
        }

    }

    protected synchronized Image getImage(){
        return image;
    }
    public void setImage(Image i) {
        synchronized (image) {
            this.image = i;
        }
    }

}
