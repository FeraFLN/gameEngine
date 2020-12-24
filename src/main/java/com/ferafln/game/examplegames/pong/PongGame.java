/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.game.examplegames.pong;

import com.ferafln.game.Game;
import com.ferafln.game.gameobjects.render.ShapeRender;
import com.ferafln.game.gameobjects.GameObject;
import com.ferafln.game.gameobjects.MovableGameObject;
import com.ferafln.game.gameobjects.collisions.impl.CollisionsBuilder;
import com.ferafln.game.setup.SetupMovements;
import com.ferafln.game.setup.MovementKey;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Set;

/**
 *
 * @author Fernando Limeira
 */
public class PongGame extends Game {

    private MovableGameObject p1;
    private MovableGameObject p2;
    private MovableGameObject ball;
    private GameObject wallTop;
    private GameObject wallBottom;
    private GameObject wallRight;
    private GameObject wallLeft;
    private MovableGameObject bar;
    private static final int D_WIDTH = 640, D_HEIGHT = D_WIDTH/12*9;
    
    public PongGame() {
        super("Lets play pong", D_WIDTH, D_HEIGHT);
    }


    
    @Override
    protected void setupMovementsKey() {
        SetupMovements.create(p2)
            .buildArrowKeys(this);
        
        SetupMovements.create(p1)
            .buildAWSDKeys(this);
        
        addKey(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_R){
                    System.out.println("R");
                    pause();
                }
            }            
        });
    }

    protected void setObstacles() {
        CollisionsBuilder
            .setCollisionFrom(p1)
            .addStop(p2, wallLeft, wallRight, wallTop, wallBottom,bar)
            .addChangeDirection(ball);
        CollisionsBuilder
            .setCollisionFrom(p2)
            .addStop(p1, wallLeft, wallRight, wallTop, wallBottom,bar)
            .addChangeDirection(ball);;
        CollisionsBuilder
            .setCollisionFrom(ball)
            .addRicochet(wallBottom, wallLeft, wallRight, wallTop, bar);
//            .addChangeDirection(p1,p2);
        CollisionsBuilder
            .setCollisionFrom(bar)
            .addRicochet(p1,p2,wallBottom, wallTop);
        
//        this.p1.addCollision(StopMove.class, p2, wallLeft, wallRight, wallTop, wallBottom,bar);//p2,, wallLeft, wallRight, wallTop, bar);//bar
//        this.p1.addCollision(DestroyAll.class, ball);//p2,, wallLeft, wallRight, wallTop, bar);//bar
//        this.p1.addObstacles(StopMove.class,  p2,wallLeft, wallRight, wallTop, bar,wallBottom,ball);//p2,, wallLeft, wallRight, wallTop, bar);//bar
//        this.p2.addCollision(StopMove.class, p1, wallBottom, wallLeft, wallRight, wallTop,bar);//bar
//        this.p2.addObstacles(StopMove.class, p1, wallBottom, wallLeft, wallRight, wallTop, bar,ball);//bar
//        this.ball.addCollision(RicochetCollision.class, p1, p2, wallBottom, wallLeft, wallRight, wallTop, bar);//bar
//        this.bar.addCollision(RicochetCollision.class, wallBottom, wallTop, p1, p2);
//        this.p1.addObstacle(Destroy.class, bar);
    }

    @Override
    protected Set<GameObject> initGameObjects() {
        this.wallTop = new GameObject(new ShapeRender(Color.yellow), 10, 50, D_WIDTH - 40, 5);// GameObjectFactoryEnum.STATIC_OBJECT.getInstance(Color.yellow, 10, 50, D_WIDTH-40, 5);
        this.wallBottom = new GameObject(new ShapeRender(Color.yellow), 10, 400, D_WIDTH-40, 5);// GameObjectFactoryEnum.STATIC_OBJECT.getInstance(Color.yellow, 10, 400, D_WIDTH-40, 5);;
        this.wallRight=new GameObject(new ShapeRender(Color.yellow), D_WIDTH-30, 51, 5, 350);
        this.wallLeft = new GameObject(new ShapeRender(Color.yellow), 10, 50, 5, 350);
        initDynamicObject();
        setObstacles();
        return null;
    }

    private void initDynamicObject() {
        this.p1 = new MovableGameObject(new ShapeRender(Color.BLUE), 20, 150, 35, 35);
        this.p2 = new MovableGameObject(new ShapeRender(Color.RED), 570,150,35, 35);
        this.ball =new MovableGameObject(new ShapeRender(Color.white), 150,150,15, 15);
        this.ball.moveUp(5);
//        this.ball.moveLeft(5);
        this.bar = new MovableGameObject(new ShapeRender(Color.yellow), 325, 200, 5, 50);
        this.bar.moveUp(2);
        
//        return Set.of();
    }

    @Override
    protected void setAllObjects() {
        addAllObject(p1,p2,ball,bar,wallTop,wallBottom,wallLeft,wallRight);
//        addAllObject(p1,wallTop,p2,bar,ball,wallBottom,wallLeft,wallRight);
    }
    @Override
    protected void setGraphics(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, D_WIDTH, D_HEIGHT);
    }

    @Override
    protected boolean isGameOver() {
        return false;
    }

}
