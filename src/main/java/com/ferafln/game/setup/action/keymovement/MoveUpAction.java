/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.game.setup.action.keymovement;

import com.ferafln.game.gameobjects.MovableGameObject;
import com.ferafln.game.setup.action.keymovement.animation.MovementAction;

/**
 *
 * @author Fernando Limeira
 */
public class MoveUpAction implements MovementAction{
    private final MovableGameObject movement;

    public MoveUpAction(MovableGameObject movement) {
        this.movement = movement;
    }
    
    @Override
    public void startMove() {
        this.movement.moveUp(5);
    }

    @Override
    public void stopMove() {
        this.movement.moveUp(0);
    }

}
