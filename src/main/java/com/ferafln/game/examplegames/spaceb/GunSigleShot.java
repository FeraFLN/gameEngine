/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.game.examplegames.spaceb;

import com.ferafln.game.Game;
import com.ferafln.game.gameobjects.Gun;
import com.ferafln.game.gameobjects.MovableGameObject;

/**
 *
 * @author Fernando Limeira
 */
public class GunSigleShot extends Gun {

    private final Game game;
    private int fireRate = 500;

    public GunSigleShot(Game game) {
        this.game = game;
    }

    
    @Override
    protected void trigger(int x, int y) {
        MovableGameObject bullet = new BigBomb(game, x - 5, y - 15);
        this.game.addObject(bullet);
    }

    @Override
    protected int fireRate() {
        return fireRate;
    }

}
