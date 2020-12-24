/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.game;

import com.ferafln.game.threads.RenderingThread;
import com.ferafln.game.threads.Rendering;
import com.ferafln.game.gameobjects.GameObject;
import com.ferafln.game.gameobjects.MovableGameObject;
import com.ferafln.game.setup.KeySetup;
import com.ferafln.game.threads.GameThread;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.image.BufferStrategy;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author Fernando Limeira
 */
public abstract class Game implements Rendering, KeySetup{
    private final int D_WIDTH, D_HEIGHT;
    private final Set<GameObject>  gameObjects = new HashSet<>();
    private final Set<KeyAdapter>  keys = new HashSet<>();
    private final Canvas canvas;
    private final Set<GameThread> threads = new HashSet<>();
    private boolean running = false;
   
    protected abstract boolean isGameOver();
    protected abstract void setupMovementsKey();
    protected abstract void setGraphics(Graphics g);
    protected abstract void setAllObjects();
    protected abstract Set<GameObject> initGameObjects();
    
    public Game(String title, int width, int height){
        this.D_HEIGHT = height;
        this.D_WIDTH = width;
        this.canvas = new Canvas();
        Window.create(D_HEIGHT, D_WIDTH, title, canvas);
    }
    
    public final void start() {
        if(running)
            return;
       
        initGameObjects();
        setupMovementsKey();
        setAllObjects();
        this.canvas.requestFocus();
        this.threads.add(RenderingThread.newInstance(this));
        this.threads.parallelStream().forEach(t -> t.start());
        running=true;
    }
    
    public final void addGameThread(GameThread gameThread){
        this.threads.add(gameThread);
    }
    
    public void pause(){
        this.threads.forEach(t -> t.pause());
    }
    
    public void restart(){
        if(!running)
            return;
        this.threads.parallelStream().forEach(t -> t.stop());
        this.clear();
        this.running = false;
        this.start();
        
    }
    
    private void clear(){
        this.threads.clear();
        this.gameObjects.clear();
        removeAllKeys();
    }
    
    private void removeAllKeys(){
        keys.forEach(e->this.canvas.removeKeyListener(e));
        this.keys.clear();
    }
    
    public Set<GameObject> getGameObjects(Predicate<GameObject> p){
        System.out.println("GameObjects size "+gameObjects.size());
        return getGameObjects().parallelStream().filter(p).collect(Collectors.toSet());
    }
    
    public final synchronized void addAllObject(GameObject... gameObject) {
        gameObjects.addAll(Arrays.asList(gameObject));
    }
    
    public final synchronized void addObject(GameObject gameObject){
        addAllObject(gameObject);
    }
    
    @Override
    public void addKey(KeyAdapter adapter){
       this.canvas.addKeyListener(adapter);
       this.keys.add(adapter);
    }

    
    private synchronized Set<GameObject> getGameObjects(){
        return gameObjects;
    }
    @Override
    public synchronized void act(){
        destroyOutOfScreen();
        getGameObjects().removeIf(o -> o.isDestroy());
        getGameObjects().forEach((o1) -> {
            if (o1 instanceof MovableGameObject) {
                ((MovableGameObject)o1).act();
            }
        });
        
    }
    @Override
    public synchronized void render() {//TODO
        BufferStrategy bs = this.canvas.getBufferStrategy();
        if(bs==null){
             this.canvas.createBufferStrategy(3);
             return;
        }
        Graphics g = bs.getDrawGraphics();
        setGraphics(g);
        getGameObjects().parallelStream().forEach(r->r.render(g));
        g.dispose();
         this.canvas.getBufferStrategy().show();        
        
    }
    
    private synchronized void destroyOutOfScreen(){
        getGameObjects().removeIf(e->{
            return e.getPositionX() < -10 || e.getPositionX() > D_WIDTH+10 || e.getPositionY() < -10 || e.getPositionY() > D_HEIGHT;
        });
    }
    


}
