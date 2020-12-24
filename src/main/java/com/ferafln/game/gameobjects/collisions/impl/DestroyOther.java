/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.game.gameobjects.collisions.impl;

import com.ferafln.game.gameobjects.GameObject;
import com.ferafln.game.gameobjects.collisions.Collision;
import com.ferafln.game.gameobjects.MovableGameObject;

/**
 *
 * @author Fernando Limeira
 */
public class DestroyOther extends Collision<MovableGameObject,GameObject>{
    
    public DestroyOther(MovableGameObject movable, GameObject obstacle) {
        super(movable, obstacle);
    }
    
    @Override
    protected void reactTouchTop() {
        getOtherObject().setDestroy(true);
    }

    @Override
    protected void reactTouchBottom() {
        getOtherObject().setDestroy(true);
    }

    @Override
    protected void reactTouchRight() {
        getOtherObject().setDestroy(true);
    }

    @Override
    protected void reactTouchLeft() {
        getOtherObject().setDestroy(true);
    }
    
    
}
