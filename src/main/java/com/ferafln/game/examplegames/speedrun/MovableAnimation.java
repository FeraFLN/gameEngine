/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.game.examplegames.speedrun;

import com.ferafln.game.gameobjects.render.ImageRender;
import java.awt.Image;

/**
 *
 * @author Fernando Limeira
 */
public class MovableAnimation extends ImageRender{
    private ImagesAnimation up;
    private ImagesAnimation left;
    private ImagesAnimation right;
    private ImagesAnimation down;
    private Image image;

    public MovableAnimation(ImagesAnimation up, ImagesAnimation left, ImagesAnimation right, ImagesAnimation down, Image image, int width, int hight ) {
        super(image, width, hight);
        this.image=image;
        this.up = up;
        this.left = left;
        this.right = right;
        this.down = down;
        this.image = image;
    }
    
    public void leftAnimation(int vel){
        if(vel == 0){
            image = left.getStopImage();
        }else{
            image = left.nextImage();
        }
        
    }
    public void rightAnimation(int vel){
        if(vel ==0){
            image = right.getStopImage();
        }else{
            image = right.nextImage();
        }
    }
    
    public void downAnimation(int vel){
        if(vel ==0){
            image = down.getStopImage();
        }else{
            image = down.nextImage();
        }
    }    
    public void upAnimation(int vel){
        if(vel ==0){
            image = up.getStopImage();
        }else{
            image = up.nextImage();
        }
    }

    @Override
    protected synchronized Image getImage() {
        return image;
    }
    
}
