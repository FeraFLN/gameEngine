/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.game.setup.action.keymovement.animation;

import com.ferafln.game.gameobjects.MovableGameObject;
import com.ferafln.game.gameobjects.render.ImageRenderMovements;
import com.ferafln.game.examplegames.speedrun.ImagesAnimation;
import java.awt.Image;

/**
 *
 * @author Fernando Limeira
 */
public class AMoveRightCommand implements MovementAction{

    private ImagesAnimation i;
    private ImageRenderMovements r;
    private final MovableGameObject movement;
    private int maxSpeed =0;
    public AMoveRightCommand(MovableGameObject movement,ImagesAnimation image,ImageRenderMovements render) {
        i=image;
        r = render;
        this.movement = movement;
    }
    
    
    
    @Override
    public void startMove() {
        Image ii = i.nextImage();
        System.out.println("new image "+ii);
        r.setImage(ii);
        if(maxSpeed<5)
            maxSpeed++;
        this.movement.moveRight(maxSpeed);
    }

    @Override
    public void stopMove() {
        r.setImage(i.getStopImage());
        this.movement.moveRight(0);
    }
    
    
    
}
