/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.game.gameobjects;

import com.ferafln.game.gameobjects.render.Render;
import com.ferafln.game.gameobjects.collisions.Collision;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fernando Limeira
 */
public class GameObject{
    protected final List<Collision> reactionList =  new ArrayList<>();
    private final Rectangle shape;
    private boolean render = true,destoy = false;
    protected final Render renderShape;
    private int xx = 0;
    
    public GameObject(Render renderShape,int x, int y,int width, int height) {
        this.shape = new Rectangle(x, y, width, height);
        this.renderShape = renderShape;
    }

    
    public Rectangle getBounds(){
        return shape;
    }
    
    public int getRightFace(){
        return getPositionX()+getBounds().width;
    }
    
    public int getLeftFace(){
        return getPositionX();
    }
    
    public int getTopFace(){
        return getPositionY();
    }
    
    public int getBottomFace(){
        return getPositionY()+getBounds().height;    
    }
    
    public int getPositionX(){
        return getBounds().x;
    }
    
    public int getPositionY(){
        return getBounds().y;
    }

    public void setRedering(boolean value){
        this.render = value;
    }
    
    public boolean isRedering(){
        return this.render;
    }
    
    public void setDestroy(boolean value){
        this.destoy = value;
    }
    
    public boolean isDestroy(){
        return this.destoy;
    }
  
    public synchronized final void addCollision(Collision collision){
        reactionList.add(collision);
    }
    
    protected final void cleanDestroied(){
        reactionList.removeIf(e -> e.getOtherObject().isDestroy() || e.getMovable().isDestroy());
    }
    
    protected final boolean isAnyReaction(){
        return reactionList.parallelStream().anyMatch(action-> action.isAnyLimitTouched());
    }
    
    protected final void addPositionX(int value){
        this.shape.x += value;
    }
    protected final void addPositionY(int value){
        this.shape.y += value;    
    }

    public void render(Graphics g) {
        if(render){
            renderShape.renderGraphics(g, shape);            
        }
    }

}
