/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.game.examplegames.speedrun;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Fernando Limeira
 */
public class ImagesAnimation {
    private final Image stopImage;
    private final List<Image> sequenceImages = new ArrayList<>();
    private int index = 0;
    private int count =0;
    
    public ImagesAnimation(Image stopImage,Image...image) {
        this.stopImage = stopImage;
        this.sequenceImages.addAll(Arrays.asList(image));        
    }

    public Image getStopImage() {
        index=0;
        return stopImage;
    }
    
    public void addImage(Image...image){
        this.sequenceImages.addAll(Arrays.asList(image));
    }
    
    public Image nextImage(){
        index++;
        if(index>sequenceImages.size()-1){
            index=0;
        }
        count++;
        System.out.println("count "+count+ " index "+index);
        return sequenceImages.get(index);
    }
}
