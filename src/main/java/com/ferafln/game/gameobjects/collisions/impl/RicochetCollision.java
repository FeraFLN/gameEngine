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
public class RicochetCollision extends Collision<MovableGameObject,GameObject>{
    
    public RicochetCollision(MovableGameObject movable, GameObject obstacle) {
        super(movable, obstacle);
    }
    
    @Override
    protected void reactTouchTop() {
        System.out.println("top");
        getMovable().moveDown(getMovable().getVelocityY());
    }

    @Override
    protected void reactTouchBottom() {
        System.out.println("down");
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
