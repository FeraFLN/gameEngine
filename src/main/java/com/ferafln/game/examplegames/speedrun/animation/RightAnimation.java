/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.game.examplegames.speedrun.animation;

import com.ferafln.game.examplegames.speedrun.ImagesAnimation;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Fernando Limeira
 */
public class RightAnimation extends ImagesAnimation{
    
    private static final Image right = new ImageIcon("C:\\Users\\feraf\\OneDrive\\Documentos\\GitHub\\gameEngine\\MM\\mario\\right.png").getImage();
    private static final Image right1 = new ImageIcon("C:\\Users\\feraf\\OneDrive\\Documentos\\GitHub\\gameEngine\\MM\\mario\\7.png").getImage();
    private static final Image stopImage = new ImageIcon("C:\\Users\\feraf\\OneDrive\\Documentos\\GitHub\\gameEngine\\MM\\mario\\right.png").getImage();

    public RightAnimation() {
        super(stopImage, right,right1);
    }
    
    
}
