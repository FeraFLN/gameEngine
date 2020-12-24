/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.game.threads;

import com.ferafln.game.Game;
import com.ferafln.game.gameobjects.GameObjectFactoy;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fernando Limeira
 */
public class AutoCreateObjectsThread extends GameThread {

    private int timeSleep = 500;
    private final Game game;
    private final GameObjectFactoy objectFactoy;

    public AutoCreateObjectsThread(Game game, GameObjectFactoy objectFactoy) {
        this.game = game;
        this.objectFactoy = objectFactoy;
    }

    public void setTimeSleep(int value) {
        this.timeSleep = value;
    }

    @Override
    public void loop(boolean wasLocked) {
        try {
            game.addObject(objectFactoy.create());
            Thread.sleep(timeSleep);
        } catch (InterruptedException ex) {
            Logger.getLogger(AutoCreateObjectsThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
