/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.game;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Fernando Limeira
 */
public class Window extends Canvas{

    private  Window(int height, int width,String title, Canvas game) {
        JFrame j = new  JFrame();
        j.setSize(width, height);
        j.setTitle(title);
        j.setMaximumSize(new Dimension(width, height));
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setResizable(false);
        j.setLocationRelativeTo(null);
        j.add(game);
        j.setVisible(true);
        
//        game.start();
    }
    
    public static void create(int height, int width,String title, Canvas game){
        new Window(height, width, title, game);
    }
    
    
}
