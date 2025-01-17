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
public class BigShot extends ThrowableGameObject{
    private static final Image i = new ImageIcon("C:\\Users\\feraf\\OneDrive\\Documentos\\GitHub\\gameEngine\\MM\\bullet2.png").getImage();
    private final Game game;
    private int range =250;
    public BigShot(Game game,int x, int y) {
        super(new ImageRender(i, 15, 15), x+2, y, 15, 15);
        this.game = game;
        moveUp(7);
    }

    
    
    @Override
    protected void updateCollisions() {
        Set<GameObject> s =game.getGameObjects(e-> e.getLeftFace()< getRightFace() && e.getRightFace()>getLeftFace());
        CollisionsBuilder.setCollisionFrom(this)
                .addDestroyAll(s.toArray(GameObject[]::new));
    }

    @Override
    protected int countDistance() {
        return range -= Math.abs(getVelocityY());
    }
    
}
