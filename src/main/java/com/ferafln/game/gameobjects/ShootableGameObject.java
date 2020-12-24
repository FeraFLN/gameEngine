/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.game.gameobjects;

import com.ferafln.game.gameobjects.render.Render;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fernando Limeira
 */
public class ShootableGameObject extends MovableGameObject{
    private final List<Gun> guns = new ArrayList<>();
    private Gun gun;
    private int indexGun = 0;
    private int maxDistance = 9000000;
//    private boolean pressTrigger = false;
    public ShootableGameObject(Render image, int x, int y, int width, int height) {
        super(image, x, y, width, height);
    }

    @Override
    public synchronized void act(){
        super.act();
        
    }
    
    public void addGun(Gun gun) {
        this.guns.add(gun);
        if(this.gun==null){
            this.gun = gun;
        }
    }
    
    public void nextGun(){
        indexGun++;
        if(guns.size()-1 < indexGun){
            indexGun=0;
        }
        this.gun = guns.get(indexGun);
    }

    public void trigger(boolean pressTrigger){
        if(pressTrigger && !isDestroy()){
            this.gun.shoot(getBounds().x,getBounds().y);
        }
    }    
    
    
}
