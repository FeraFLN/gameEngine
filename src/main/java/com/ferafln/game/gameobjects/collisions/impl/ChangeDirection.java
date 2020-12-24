/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.game.gameobjects.collisions.impl;

import com.ferafln.game.gameobjects.collisions.Collision;
import com.ferafln.game.gameobjects.MovableGameObject;

/**
 *
 * @author Fernando Limeira
 */
public class ChangeDirection extends Collision<MovableGameObject,MovableGameObject>{
    
    public ChangeDirection(MovableGameObject movable, MovableGameObject obstacle) {
        super(movable, obstacle);
    }
    
    @Override
    protected void reactTouchTop() {
        getOtherObject().moveUp(5);
    }

    @Override
    protected void reactTouchBottom() {
        getOtherObject().moveDown(5);
    }

    @Override
    protected void reactTouchRight() {
        getOtherObject().moveRight(5);
    }

    @Override
    protected void reactTouchLeft() {
        getOtherObject().moveLeft(5);
    }
    
    
}
