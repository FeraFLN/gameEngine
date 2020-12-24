/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.game.gameobjects;

/**
 *
 * @author Fernando Limeira
 */
public abstract class Gun {
    private long lastShot = System.currentTimeMillis();
    
    protected abstract void trigger(int x, int y);
    
    protected abstract int fireRate();
    
    public final void shoot(int x, int y){
        long now = System.currentTimeMillis();
        if(now-lastShot>=fireRate()){
            trigger(x, y);
            lastShot = now;
        }
    }
    
    
//    int getDistance();
    
}
