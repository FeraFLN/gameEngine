/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.game.setup.action.keyothers;

import com.ferafln.game.gameobjects.ShootableGameObject;
import com.ferafln.game.setup.action.keymovement.animation.MovementAction;

/**
 *
 * @author Fernando Limeira
 */
public class ShootAction implements MovementAction{
    private final ShootableGameObject movement;

    public ShootAction(ShootableGameObject movement) {
        this.movement = movement;
    }
    
    
    @Override
    public void startMove() {
        this.movement.trigger(true);
    }

    @Override
    public void stopMove() {
        this.movement.trigger(true);
    }
    
    
    
}
