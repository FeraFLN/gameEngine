/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.game.setup;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import com.ferafln.game.setup.action.keymovement.animation.MovementAction;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Fernando Limeira
 * @param <T>
 */
public class MovementKey<T extends MovementAction> extends KeyAdapter{
    
    private final Map<Integer,T> movements = new HashMap<>();
    
    public MovementKey() {
    }

    public void addMovement(Integer keyCode,T movement){
        movements.put(keyCode, movement);
    }
    
    @Override
    public final void keyPressed(KeyEvent e) {
//        movements.values().forEach(em->em.stopMove());
        if(movements.containsKey(e.getKeyCode()))
            movements.get(e.getKeyCode()).startMove();
    }
    @Override
    public final void keyReleased(KeyEvent e) {
        if(movements.containsKey(e.getKeyCode()))
            movements.get(e.getKeyCode()).stopMove();
    }
    
}
