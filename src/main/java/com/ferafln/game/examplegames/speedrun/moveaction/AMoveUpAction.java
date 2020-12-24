/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.game.examplegames.speedrun.moveaction;

import com.ferafln.game.setup.action.keymovement.animation.MovementAction;
import com.ferafln.game.gameobjects.MovableGameObject;
import com.ferafln.game.gameobjects.render.ImageRenderMovements;
import com.ferafln.game.examplegames.speedrun.ImagesAnimation;
import com.ferafln.game.examplegames.speedrun.animation.UpAnimation;

/**
 *
 * @author Fernando Limeira
 */
public class AMoveUpAction implements MovementAction{

    private final ImagesAnimation i;
    private final ImageRenderMovements r;
    private final MovableGameObject movement;
   
    public AMoveUpAction(MovableGameObject movement,ImageRenderMovements render) {
        i= new UpAnimation();
        r = render;
        this.movement = movement;
    }

    @Override
    public void startMove() {
        r.setImage(i.nextImage());
        this.movement.moveUp(0);
        this.movement.moveLeft(0);        
    }

    @Override
    public void stopMove() {
        r.setImage(i.getStopImage());
        this.movement.moveUp(0);
    }
    
    
    
}
