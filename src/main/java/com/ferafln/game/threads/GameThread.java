/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.game.threads;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fernando Limeira
 */
public abstract class GameThread {

    private Thread thread;
    private final Object pauseLock = new Object();
    private boolean running = false, pause = false;

    public abstract void loop(boolean wasLocked);

    public synchronized void start() {
        if (!running) {
            thread = new Thread(new Run());
            this.running = true;
            thread.start();
        }
    }

    public synchronized void stop() {
        if (running) {
            try {
                this.running = false;
                this.thread.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(GameThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void pause() {
        this.pause = !this.pause;
        if (!this.pause) {
            resume();
        }
    }

    public void resume() {
        synchronized (pauseLock) {
            pauseLock.notifyAll();
        }
    }

    private class Run implements Runnable {

        @Override
        public void run() {
            while (running) {
                synchronized (pauseLock) {
                    boolean wasLocked = false;
                    if (pause) {
                        lock();
                        wasLocked = true;
                    }
                    loop(wasLocked);
                }
            }
        }
    }

    private synchronized void lock() {
        synchronized (pauseLock) {
            try {
                pauseLock.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(RenderingThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
