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
public class StopMove extends Collision<MovableGameObject,GameObject>{
    
    public StopMove(MovableGameObject movable, GameObject obstacle) {
        super(movable, obstacle);
    }
    
    @Override
    protected void reactTouchTop() {
        getMovable().moveUp(0);
    }

    @Override
    protected void reactTouchBottom() {
        getMovable().moveDown(0);
    }

    @Override
    protected void reactTouchRight() {
        getMovable().moveRight(0);
    }

    @Override
    protected void reactTouchLeft() {
        getMovable().moveLeft(0);
    }
    
    
}
