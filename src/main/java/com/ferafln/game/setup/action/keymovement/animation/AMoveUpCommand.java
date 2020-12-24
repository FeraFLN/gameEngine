/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.game.setup.action.keymovement.animation;

import com.ferafln.game.gameobjects.MovableGameObject;
import com.ferafln.game.gameobjects.render.ImageRenderMovements;
import com.ferafln.game.examplegames.speedrun.ImagesAnimation;

/**
 *
 * @author Fernando Limeira
 */
public class AMoveUpCommand implements MovementAction{

    private final ImagesAnimation i;
    private final ImageRenderMovements r;
    private final MovableGameObject movement;
   
    public AMoveUpCommand(MovableGameObject movement, ImagesAnimation image,ImageRenderMovements render) {
        i=image;
        r = render;
        this.movement = movement;
    }

    @Override
    public void startMove() {
        r.setImage(i.nextImage());
        System.out.println("up");
//        this.movement.moveUp(0);
        
    }

    @Override
    public void stopMove() {
        r.setImage(i.getStopImage());
        this.movement.moveUp(0);
    }
    
    
    
}
