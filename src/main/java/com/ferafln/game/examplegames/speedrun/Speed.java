/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.game.examplegames.speedrun;

import com.ferafln.game.Game;
import com.ferafln.game.gameobjects.GameObject;
import com.ferafln.game.gameobjects.ShootableGameObject;
import com.ferafln.game.gameobjects.collisions.impl.CollisionsBuilder;
import com.ferafln.game.gameobjects.render.ImageRenderMovements;
import com.ferafln.game.gameobjects.render.ShapeRender;
import com.ferafln.game.setup.MovementKey;
import com.ferafln.game.examplegames.speedrun.moveaction.AMoveDownAction;
import com.ferafln.game.examplegames.speedrun.moveaction.AMoveJumpAction;
import com.ferafln.game.examplegames.speedrun.moveaction.AMoveLeftAction;
import com.ferafln.game.examplegames.speedrun.moveaction.AMoveRightAction;
import com.ferafln.game.examplegames.speedrun.moveaction.AMoveUpAction;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.Set;
import javax.swing.ImageIcon;

/**
 *
 * @author Fernando Limeira
 */
public class Speed extends Game {

    private static final int width = 750, height = 600;
    private ShootableGameObject p1;
    private GameObject floor;
    private final Image backImage = new ImageIcon("C:\\Users\\feraf\\OneDrive\\Documentos\\GitHub\\gameEngine\\MM\\BGMario.png").getImage();
    private static final Image right = new ImageIcon("C:\\Users\\feraf\\OneDrive\\Documentos\\GitHub\\gameEngine\\MM\\mario\\right.png").getImage();
    
    private final ImageRenderMovements charRender;

    public Speed() {
        super("Opa", width, height);
        this.charRender = new ImageRenderMovements(right, 50, 50);


    }

    @Override
    protected boolean isGameOver() {
        return false;
    }

    @Override
    protected void setupMovementsKey() {
        MovementKey mk = new MovementKey();
        mk.addMovement(KeyEvent.VK_DOWN, new AMoveDownAction(p1,  charRender));
        mk.addMovement(KeyEvent.VK_LEFT, new AMoveLeftAction(p1,  charRender));
        mk.addMovement(KeyEvent.VK_RIGHT, new AMoveRightAction(p1, charRender));
        mk.addMovement(KeyEvent.VK_UP, new AMoveUpAction(p1, charRender));
        mk.addMovement(KeyEvent.VK_SPACE, new AMoveJumpAction(p1, charRender));
        addKey(mk);
//        SetupMovements.create(p1).buildAWSDKeys(this);

    }

    @Override
    protected void setGraphics(Graphics g) {
        g.drawImage(backImage, 0, 0, width, height - 40, null);
//        g.fillRect(0, 0, D_WIDTH, D_HEIGHT);
    }

    @Override
    protected void setAllObjects() {
        addAllObject(floor, p1);
    }

    @Override
    protected Set<GameObject> initGameObjects() {
        this.floor = new GameObject(new ShapeRender(Color.yellow), 0, height - 75, width, 5);

//        MovableAnimation ma = new MovableAnimation(iaUp, iaLeft, iaRight, iadown, right,50,50);
        this.p1 = new ShootableGameObject(charRender, 10, height - 200, 50, 50);
        CollisionsBuilder.setCollisionFrom(p1).addStop(floor);
        p1.moveDown(5);

        return null;
    }

    public static void main(String[] args) {
        new Speed().start();
    }

}
