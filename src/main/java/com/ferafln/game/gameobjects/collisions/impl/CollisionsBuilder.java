/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.game.gameobjects.collisions.impl;

import com.ferafln.game.gameobjects.GameObject;
import com.ferafln.game.gameobjects.MovableGameObject;

/**
 *
 * @author Fernando Limeira
 */
public class CollisionsBuilder {

    private final MovableGameObject movableGameObject;
    
    private CollisionsBuilder(MovableGameObject movableGameObject){
        this.movableGameObject = movableGameObject;
    }
    
    public static CollisionsBuilder setCollisionFrom(MovableGameObject movableGameObject){
        return new CollisionsBuilder(movableGameObject);
    }
    
    public CollisionsBuilder addStop(GameObject...gameObject){
        for (GameObject go : gameObject) {
            movableGameObject.addCollision(new StopMove(movableGameObject, go));
        }
        return this;
    }
    
    public CollisionsBuilder addRicochet(GameObject...gameObject){
        for (GameObject go : gameObject) {
            movableGameObject.addCollision(new RicochetCollision(movableGameObject, go));
        }
        return this;
    }
    
    public CollisionsBuilder addDestroyAll(GameObject...gameObject){
        for (GameObject go : gameObject) {
            movableGameObject.addCollision(new DestroyAll(movableGameObject, go));
        }
        return this;
    }
    public CollisionsBuilder addAutoDestroy(GameObject...gameObject){
        for (GameObject go : gameObject) {
            movableGameObject.addCollision(new AutoDestroy(movableGameObject, go));
        }
        return this;
    }
    public CollisionsBuilder addDestroyOther(GameObject...gameObject){
        for (GameObject go : gameObject) {
            movableGameObject.addCollision(new DestroyOther(movableGameObject, go));
        }
        return this;
    }
    public CollisionsBuilder addChangeDirection(MovableGameObject...gameObject){
        for (MovableGameObject go : gameObject) {
            movableGameObject.addCollision(new ChangeDirection(movableGameObject, go));
        }
        return this;
    }
}
