/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.game.setup.action.keymovement;

import com.ferafln.game.gameobjects.MovableGameObject;
import com.ferafln.game.setup.action.keymovement.animation.MovementAction;
import java.awt.Image;

/**
 *
 * @author Fernando Limeira
 */
public class MoveLeftAction implements MovementAction{

    private final MovableGameObject movement;

    public MoveLeftAction(MovableGameObject movement) {
        this.movement = movement;
    }
    
    @Override
    public void startMove() {
        movement.moveLeft(5);
    }

    @Override
    public void stopMove() {
        movement.moveLeft(0);
    }
    
    
    
}
