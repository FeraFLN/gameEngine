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
public class Hit extends Collision{
    private MovableGameObject obstacle;
    
    public Hit(MovableGameObject movable, MovableGameObject obstacle) {
        super(movable, obstacle);
        this.obstacle = obstacle;
    }
    
    @Override
    protected void reactTouchTop() {
        getMovable().moveDown(getMovable().getVelocityY());
    }

    @Override
    protected void reactTouchBottom() {
        getMovable().moveUp(getMovable().getVelocityY());
    }

    @Override
    protected void reactTouchRight() {
        getMovable().moveLeft(getMovable().getVelocityX());
    }

    @Override
    protected void reactTouchLeft() {
        getMovable().moveRight(getMovable().getVelocityX());
    }
    
    
}
