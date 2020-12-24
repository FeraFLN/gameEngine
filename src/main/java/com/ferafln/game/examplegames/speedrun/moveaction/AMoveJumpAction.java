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
public class AMoveJumpAction implements MovementAction {

    private final ImagesAnimation i;
    private final ImageRenderMovements r;
    private final MovableGameObject movement;
    private int maxHeight = 5;
    private boolean touchMax = false;

    public AMoveJumpAction(MovableGameObject movement, ImageRenderMovements render) {
        i = new UpAnimation();
        r = render;
        this.movement = movement;
    }

    @Override
    public void startMove() {
//        r.setImage(i.nextImage());
         System.out.println("max "+ maxHeight);   
        for (int j = 0; j < maxHeight; j++) {
            this.movement.moveUp(5);
        }
        maxHeight=0;
        stopMove();

    }

    @Override
    public void stopMove() {
        
        for (int j = maxHeight; j < 5; j++) {
            this.movement.moveDown(5);
        }
        maxHeight=5;
//        r.setImage(i.getStopImage());
//        this.movement.moveUp(0);
    }

}
