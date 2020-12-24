/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.game.gameobjects.collisions;

import com.ferafln.game.gameobjects.GameObject;
import java.util.HashSet;
import java.util.Set;
import com.ferafln.game.gameobjects.MovableGameObject;

/**
 *
 * @author Fernando Limeira
 */
public abstract class Collision<M extends MovableGameObject ,O extends GameObject>  {
    private final M movable;
    private final O gameObject;
    
    public Collision(M movable, O concrete) {
        this.movable = movable;
        this.gameObject = concrete;
    }
    
    public final M getMovable(){
        return movable;
    }
    public final O getOtherObject(){
        return gameObject;
    }
    
    protected abstract void reactTouchTop();
    protected abstract void reactTouchBottom();
    protected abstract void reactTouchRight();
    protected abstract void reactTouchLeft();
   
    public boolean isAnyLimitTouched(){
        return touchTop() ||
        touchBottom() || 
        touchLeft() ||
        touchRight();
    }
   
    
    public boolean isRightContact(){
        int distance = Math.abs(movable.getRightFace()-gameObject.getLeftFace()) ;
        int velX = Math.abs(movable.getVelocityX())+Math.abs(getObjectVelX());
        int oVelX = Math.abs(getObjectVelX());
        if(isInVerticalRange() && velX > distance  && movable.getVelocityX()>= 0){
            if(oVelX>0 && oVelX==velX)
                gameObject.getBounds().x -= Math.abs(distance);
            else    
                movable.getBounds().x += Math.abs(distance);
            return true;
        }
        return false;        
    }
    public boolean isLeftContact(){
        int distance = Math.abs(movable.getLeftFace() -gameObject.getRightFace());
        int velX = Math.abs(movable.getVelocityX())+Math.abs(getObjectVelX());
        int oVelX = Math.abs(getObjectVelX());
        if(isInVerticalRange() && velX > distance && movable.getVelocityX() <=  0){
            if(oVelX>0 && oVelX == velX)
                gameObject.getBounds().x += Math.abs(distance);
            else
                movable.getBounds().x = gameObject.getRightFace();
            return true;
        }
        return false;        
    }
    
    public boolean isTopContact(){
        int distance = Math.abs(movable.getTopFace()-gameObject.getBottomFace());
        int velY =Math.abs( movable.getVelocityY())+Math.abs(getObjectVelY());
        int oVelY = Math.abs(getObjectVelY());
        if(isInHorizontalRange() && velY > distance &&  movable.getVelocityY()<= 0){
            if(oVelY>0 && oVelY==velY)
                gameObject.getBounds().y -= Math.abs(distance);
            else
                movable.getBounds().y = gameObject.getBottomFace();
            return true;
        } 
        return false;
    }
    public boolean isBottomContact(){
        int distance = Math.abs(movable.getBottomFace() - gameObject.getTopFace());
        int velY = Math.abs(movable.getVelocityY())+Math.abs(getObjectVelY());
        int oVelY = Math.abs(getObjectVelY());
        if(isInHorizontalRange() && velY > distance &&  movable.getVelocityY() >= 0){
            if(oVelY>0 && oVelY == velY)
                gameObject.getBounds().y -= Math.abs(distance);
            else
                movable.getBounds().y += Math.abs(distance);
            return true;
        }        
        return false;
    }
    private boolean isInHorizontalRange(){
        int x = movable.getPositionX();
        return x + movable.getBounds().width >= gameObject.getPositionX() && x <= gameObject.getPositionX() + gameObject.getBounds().width ;
    }
    private boolean isInVerticalRange(){
        int y = movable.getPositionY();
        return  y + movable.getBounds().height >= gameObject.getPositionY() && y <= gameObject.getPositionY() + gameObject.getBounds().height ;
    }
    
    private boolean touchLeft(){
        if(isLeftContact()){
            this.reactTouchLeft();
            return true;
        }
        return false;
    }
    
    private boolean touchRight(){
        if(isRightContact()){
            this.reactTouchRight();
            return true;
        }
        return false;
    }
    
    private boolean touchBottom(){
        if(isBottomContact()){
            this.reactTouchBottom();
            return true;
        }
        return false;
    }
    
    private boolean touchTop(){
        if(isTopContact()){
            this.reactTouchTop();
            return true;
        }
        return false;
    }
    
    private int getObjectVelX(){
        if(gameObject instanceof MovableGameObject){
            return ((MovableGameObject)gameObject).getVelocityX();
        }
        return 0;
    }
    private int getObjectVelY(){
        if(gameObject instanceof MovableGameObject){
            return ((MovableGameObject)gameObject).getVelocityY();
        }
        return 0;
    }
    
}
