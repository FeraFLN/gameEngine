/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.game.gameobjects;

import com.ferafln.game.gameobjects.render.Render;

/**
 *
 * @author Fernando Limeira
 */
public abstract class ThrowableGameObject extends MovableGameObject{
    private int counter = 0;
    private int countDistance=0;
    public ThrowableGameObject(Render render, int x, int y,int width,int height){
        super(render, x, y, width, height);
    }
    
    @Override
    public synchronized void act() {
        super.act(); 
        checkDistance();
        if(counter<=0){
            updateCollisions();
            
            counter = 5;
        }
        counter--;
    }

    protected void checkDistance() {
        if(Math.abs(countDistance())<=0){
            setDestroy(true);
        }
    }
    
    
    
    protected  abstract int countDistance();
    
    protected abstract void updateCollisions();
    
}
