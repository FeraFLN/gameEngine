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
import com.ferafln.game.examplegames.speedrun.animation.LeftAnimation;
import java.awt.Image;

/**
 *
 * @author Fernando Limeira
 */
public class AMoveLeftAction implements MovementAction{

    private ImagesAnimation i;
    private ImageRenderMovements r;
    private final MovableGameObject movement;
    
    public AMoveLeftAction(MovableGameObject movement, ImageRenderMovements render) {
        i=new LeftAnimation();
        r = render;
        this.movement = movement;
    }
    
    
    
    @Override
    public void startMove() {
        r.setImage(i.nextImage());
        this.movement.moveLeft(5);
    }

    @Override
    public void stopMove() {
        r.setImage(i.getStopImage());
        this.movement.moveLeft(0);
    }
    
    
    
}
