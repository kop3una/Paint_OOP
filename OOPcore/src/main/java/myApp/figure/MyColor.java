package myApp.figure;

import javafx.scene.paint.Color;

import java.io.Serializable;

public class MyColor implements Serializable {
    private final static int RED = 0;
    private final static int GREEN = 1;
    private final static int BLUE = 2;
    double [] color = new double [3];

    public double setRed (){
        return color[RED];
    }
    public double setGreen (){
        return color[GREEN];
    }
    public double setBlue (){
        return color[BLUE];
    }

    public void getColor(Color colorFig){
        color[RED] = colorFig.getRed();//[0];
        color[GREEN] = colorFig.getGreen();//[1];
        color[BLUE] = colorFig.getBlue();// [2];
    }
}
