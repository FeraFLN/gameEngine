/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.game.gameobjects;

import com.ferafln.game.gameobjects.render.Render;
import com.ferafln.game.examplegames.speedrun.MovableAnimation;

/**
 *
 * @author Fernando Limeira
 */
public class MovableGameObject extends GameObject{
    private int velX, velY;
//    private MovableAnimation animation;
    public MovableGameObject(Render animation,int x, int y,int width, int height) {
        super(animation, x, y, width, height);
//        this.animation = animation;
    }

    
    public void mainAct() {
        addPositionX(velX);
        addPositionY(velY);
    }

    public synchronized void act(){
        cleanDestroied();        
        if(reactionList.isEmpty() || !isAnyReaction()){
            mainAct();
        }
    }
    
   
    public int getVelocityX() {
        return velX;
    }

    public int getVelocityY() {
        return velY;
    }

    public void moveUp(int vel) {
        this.velY = -Math.abs(vel);
//        this.animation.upAnimation(vel);
    }

    public void moveDown(int vel) {
        this.velY = Math.abs(vel);
//        this.animation.downAnimation(vel);
    }

    public void moveRight(int vel) {
        this.velX = Math.abs(vel);
//        this.animation.rightAnimation(vel);
        
    }

    public void moveLeft(int vel) {
        this.velX = -Math.abs(vel);
//        this.animation.leftAnimation(vel);        
    }
    
}
