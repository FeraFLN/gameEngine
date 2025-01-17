/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.game.examplegames.spaceb;

import com.ferafln.game.Game;
import com.ferafln.game.examplegames.pong.PongGame;
import com.ferafln.game.examplegames.speedrun.Speed;
import com.ferafln.game.gameobjects.render.ImageRender;
import com.ferafln.game.gameobjects.render.Render;
import com.ferafln.game.gameobjects.GameObject;
import com.ferafln.game.gameobjects.ShootableGameObject;
import com.ferafln.game.gameobjects.collisions.impl.CollisionsBuilder;
import com.ferafln.game.gameobjects.collisions.impl.DestroyAll;
import com.ferafln.game.setup.SetupMovements;
import com.ferafln.game.threads.AutoCreateObjectsThread;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.swing.ImageIcon;

/**
 *
 * @author Fernando Limeira
 */
public class SpaceB extends Game{
//    private GameObject wallBottom;
    private ShootableGameObject p1;
    private ShootableGameObject p2;
    private static final int D_WIDTH = 640, D_HEIGHT = D_WIDTH/12*9;
    private final Image imageShip = new ImageIcon("C:\\Users\\feraf\\OneDrive\\Documentos\\GitHub\\gameEngine\\MM\\lucasShip.png").getImage();
    private final Image imageShip2 = new ImageIcon("C:\\Users\\feraf\\OneDrive\\Documentos\\GitHub\\gameEngine\\MM\\spaceship2.png").getImage();
    private final Image backImage = new ImageIcon("C:\\Users\\feraf\\OneDrive\\Documentos\\GitHub\\gameEngine\\MM\\Space.jpg").getImage();
    private final Render imageRender;
    private final Render imageRender2;
//    private final Render shapeRender;
    
    public static void main(String[] args) {
        List<Integer> l = new ArrayList();
        l.stream().sorted();
        new PongGame().start();
    }
    
    public SpaceB() {
        
        super("Lets play SpaceB", D_WIDTH, D_HEIGHT);
        this.imageRender = new ImageRender(imageShip, 70, 70);
        this.imageRender2 = new ImageRender(imageShip2, 50, 50);
//        this.shapeRender = new ShapeRender(Color.yellow);
    }
    
    @Override
    protected void setupMovementsKey() {
        SetupMovements.create(p1)
            .setShoot(KeyEvent.VK_SHIFT)
            .setChangeGun(KeyEvent.VK_CONTROL)  
            .buildArrowKeys(this);
        SetupMovements.create(p2)
            .setShoot(KeyEvent.VK_SPACE)
            .setChangeGun(KeyEvent.VK_V)  
            .buildAWSDKeys(this);
        
        addKey(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_P){
                    pause();
                }
            }            
        });
        addKey(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_R){
                    restart();
                }
            }            
        });
    }

    @Override
    protected void setAllObjects() {
        addAllObject(p1,p2);
    }

    @Override
    protected Set<GameObject> initGameObjects() {
        this.p1 = new ShootableGameObject(imageRender, 300, 300, 30, 30);
        p1.addGun(new GunDoubleShot(this));
        p1.addGun(new GunSigleShot(this));
        this.p2 = new ShootableGameObject(imageRender2, 100, 300, 30, 30);
        p2.addGun(new GunDoubleShot(this));
        p2.addGun(new GunSigleShot(this));
        CollisionsBuilder.setCollisionFrom(p1).addDestroyAll(p2);
        Rectangle r = new Rectangle(0, 0, 450, 2);
        EnimyObjectFactory e = new EnimyObjectFactory(r,p1,p2);
        e.addObject(DestroyAll.class, p1,p2);
        addGameThread(new AutoCreateObjectsThread(this,e));
        return null;
    }

    protected void initDynamicObject() {
//        return null;
    }

    @Override
    protected void setGraphics(Graphics g) {
        g.drawImage(backImage, 0,0,D_WIDTH, D_WIDTH, null);
//        g.fillRect(0, 0, D_WIDTH, D_HEIGHT);
    }

    @Override
    protected boolean isGameOver() {
        return p1.isDestroy();
    }
    
}
