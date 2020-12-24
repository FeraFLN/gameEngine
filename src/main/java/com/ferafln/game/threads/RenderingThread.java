/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.game.threads;

/**
 *
 * @author Fernando Limeira
 */
public class RenderingThread extends GameThread {

    private final Rendering mainGame;
    private final double amountOfTicks = 60.0;
    private final double ns = 1000000000 / amountOfTicks;
    private long lastTime = System.nanoTime();
    private double delta = 0;

    private RenderingThread(Rendering mainGame) {
        this.mainGame = mainGame;
    }

    public static RenderingThread newInstance(Rendering mainGame) {
        return new RenderingThread(mainGame);
    }

    @Override
    public void loop(boolean wasLocked) {
        if(wasLocked)
            lastTime = System.nanoTime();
            
        long now = System.nanoTime();
        delta += (now - lastTime) / ns;
        lastTime = now;
        while (delta > 1) {
            mainGame.act();//act
            delta--;
        }
        mainGame.render();
    }

}
