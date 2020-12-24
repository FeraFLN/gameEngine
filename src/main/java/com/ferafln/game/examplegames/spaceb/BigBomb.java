/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.game.examplegames.spaceb;

import com.ferafln.game.gameobjects.ThrowableGameObject;
import com.ferafln.game.Game;
import com.ferafln.game.gameobjects.GameObject;
import com.ferafln.game.gameobjects.collisions.impl.CollisionsBuilder;
import com.ferafln.game.gameobjects.render.ImageRender;
import java.awt.Image;
import java.util.Set;
import javax.swing.ImageIcon;

/**
 *
 * @author Fernando Limeira
 */
public class BigBomb extends ThrowableGameObject{
    private static final Image i = new ImageIcon("{{PATH}}\\Documents\\NetBeansProjects\\SecondGame\\super.png").getImage();
    private final Game game;
    private int range =250;
    public BigBomb(Game game,int x, int y) {
        super(new ImageRender(i, 65, 65), x-12, y-15, 65, 15);
        this.game = game;
        moveUp(7);
//        setMaxHeight(0);
    }

    
    
    @Override
    protected void updateCollisions() {
//        int mid = (getLeftFace()+getRightFace())/2;
        Set<GameObject> s =game.getGameObjects(e-> e.getLeftFace()< getRightFace() && e.getRightFace()>getLeftFace());
        CollisionsBuilder.setCollisionFrom(this)
                .addDestroyOther(s.toArray(GameObject[]::new));
    }

    @Override
    protected int countDistance() {
        return range -= Math.abs(getVelocityY());
    }
    
}
