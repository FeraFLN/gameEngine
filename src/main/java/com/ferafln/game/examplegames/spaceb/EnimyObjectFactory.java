/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.game.examplegames.spaceb;

import com.ferafln.game.gameobjects.render.ImageRender;
import com.ferafln.game.gameobjects.GameObject;
import com.ferafln.game.gameobjects.GameObjectFactoy;
import com.ferafln.game.gameobjects.MovableGameObject;
import com.ferafln.game.gameobjects.collisions.Collision;
import com.ferafln.game.gameobjects.collisions.impl.CollisionsBuilder;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import javax.swing.ImageIcon;

/**
 *
 * @author Fernando Limeira
 */
public class EnimyObjectFactory implements GameObjectFactoy{
    private final Rectangle area;
    private final Random r = new Random();
    private final Map<Class<? extends Collision>,GameObject[]> reactions = new HashMap<>();
    private Set<GameObject> set = new HashSet<>();
    private final MovableGameObject[] ship;
//    private final GameObject bar;
    private final ImageRender enimspaceship;
    
    
    public EnimyObjectFactory(Rectangle area,MovableGameObject... ship) {
        this.area = area;
//        this.reactions.put(clazz, gameObjects);
        Image i = new ImageIcon("C:\\Users\\feraf\\OneDrive\\Documentos\\GitHub\\gameEngine\\MM\\enimy_spaceship.png").getImage();
        this.enimspaceship = new ImageRender(i, 50, 50);
        this.ship = ship;
//        this.bar = bar;
    }
    
    
    
    public void addObject(Class<? extends Collision> clazz, GameObject...gameObjects){
//        reactions.put(clazz, gameObjects);
          set.addAll(Arrays.asList(gameObjects));
    }
    @Override
    public GameObject create() {
        int x = r.nextInt(area.width - area.x) + area.x;
        int y = r.nextInt(area.height - area.y) + area.y;
        int vel = r.nextInt(5 - 1) + 1;
        
        MovableGameObject result = new MovableGameObject(enimspaceship, x, y, 40, 30);
//        result.setMinHeight(100);
        CollisionsBuilder.setCollisionFrom(result).addDestroyAll(ship);
        result.moveDown(vel);
        return result;
    }

    @Override
    public void addObject(GameObject gameObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
