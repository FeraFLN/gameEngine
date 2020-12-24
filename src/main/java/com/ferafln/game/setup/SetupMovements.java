/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.game.setup;

//import com.ferafln.firstgame.gameobject.ControllableGameObject;

import com.ferafln.game.setup.action.keymovement.MoveDownAction;
import com.ferafln.game.setup.action.keymovement.MoveLeftAction;
import com.ferafln.game.setup.action.keymovement.MoveRightAction;
import com.ferafln.game.setup.action.keymovement.MoveUpAction;
import com.ferafln.game.gameobjects.MovableGameObject;
import com.ferafln.game.gameobjects.ShootableGameObject;
import com.ferafln.game.setup.action.keyothers.ChangeGunAction;
import com.ferafln.game.setup.action.keyothers.ShootAction;
import com.ferafln.game.setup.action.keymovement.animation.MovementAction;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Fernando Limeira
 */
public class SetupMovements<M extends MovableGameObject> {
    private final MovableGameObject movableObject;
    private final  MovementKey keyMap = new MovementKey();;
    
    private SetupMovements(M gameObject) {
        this.movableObject = gameObject;
    }
    
    
    public static <M extends MovableGameObject>SetupMovements create(M gameObject){
        return new SetupMovements(gameObject);
    }
    
    public MovementKey build() {
        return keyMap;
    }
    public void buildAWSDKeys(KeySetup keySetup) {
        setMoveDown(KeyEvent.VK_S)
            .setMoveLeft(KeyEvent.VK_A)
            .setMoveUp(KeyEvent.VK_W)
            .setMoveRight(KeyEvent.VK_D);
         keySetup.addKey(keyMap);
//        return build();
    }
    public void buildArrowKeys(KeySetup keySetup) {
         setMoveDown(KeyEvent.VK_DOWN)
              .setMoveLeft(KeyEvent.VK_LEFT)
              .setMoveUp(KeyEvent.VK_UP)
              .setMoveRight(KeyEvent.VK_RIGHT);
         keySetup.addKey(keyMap);
//         return build();
    }
    
    public SetupMovements setMoveUp(int keyCode){
        this.keyMap.addMovement(keyCode, new MoveUpAction(movableObject));
        return this;
    }
    
    public SetupMovements setMoveRight(int keyCode){
        this.keyMap.addMovement(keyCode,new MoveRightAction(movableObject));
        return this;
    }
    public SetupMovements setMoveDown(int keyCode){
        this.keyMap.addMovement(keyCode,new MoveDownAction(movableObject));
        return this;
    }
    public SetupMovements setMoveLeft(int keyCode){
        this.keyMap.addMovement(keyCode,new MoveLeftAction(movableObject));
        return this;
    }
    public SetupMovements setShoot(int keyCode){
        this.keyMap.addMovement(keyCode,new ShootAction((ShootableGameObject)movableObject));
        return this;
    }
    public SetupMovements setChangeGun(int keyCode){
        this.keyMap.addMovement(keyCode,new ChangeGunAction((ShootableGameObject)movableObject));
        return this;
    }
    
    
}
