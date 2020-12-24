/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.game.gameobjects;

import com.ferafln.game.gameobjects.GameObject;

/**
 *
 * @author Fernando Limeira
 */
public interface GameObjectFactoy {

    public void addObject(GameObject gameObject);
    
    public GameObject create();

}
