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
public class DestroyAll extends Collision<MovableGameObject,GameObject>{
    
    public DestroyAll(MovableGameObject movable, GameObject obstacle) {
        super(movable, obstacle);
    }
    
    @Override
    protected void reactTouchTop() {
        getMovable().setDestroy(true);
        getOtherObject().setDestroy(true);
    }

    @Override
    protected void reactTouchBottom() {
        getMovable().setDestroy(true);
        getOtherObject().setDestroy(true);
    }

    @Override
    protected void reactTouchRight() {
        getMovable().setDestroy(true);
        getOtherObject().setDestroy(true);
    }

    @Override
    protected void reactTouchLeft() {
        getMovable().setDestroy(true);
        getOtherObject().setDestroy(true);
    }
}
