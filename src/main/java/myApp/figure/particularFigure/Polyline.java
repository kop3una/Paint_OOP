package myApp.figure.particularFigure;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import myApp.figure.Figure;
import myApp.figure.MyColor;

import java.util.Arrays;

public class Polyline extends Figure {
  //  ArrayList<Double> x = new ArrayList<>();
    int length;
    double [] x = new double[10] ;
    double [] y = new double[10];
    private final MyColor stroke = new MyColor();
    private double lineWidth;

    public Polyline () {
        length = 0;
    }

    @Override
    public void drawFigure(GraphicsContext graphicsContext) {
        Color color = Color.color(stroke.setRed(),stroke.setGreen(),stroke.setBlue());
        graphicsContext.setStroke(color);
        graphicsContext.setLineWidth(lineWidth);
        graphicsContext.strokePolyline(x,y,length);
    }

    @Override
    public void setLineConfig(GraphicsContext graphicsContext, ColorPicker colorPicker, Slider slider) {
        stroke.getColor(colorPicker.getValue());
        lineWidth = slider.getValue();
    }

    @Override
    public void setFillConfig(GraphicsContext graphicsContext, ColorPicker colorPicker) {

    }

    @Override
    public void setPoints(double... points) {

    }

    @Override
    public void addPoints(double... points) {
        x[length] = points[0];
        y[length] = points[1];
        length++;
        if (x.length == length){
            x = Arrays.copyOf(x,x.length*2);
            y = Arrays.copyOf(y,y.length*2);
        }
    }

    @Override
    public void changePoints(double... points) {
        x[length] = 0;
        y[length] = 0;
        length--;
    }

    @Override
    public void closeFigure() {

    }

    @Override
    public boolean isPolyFigure() {
        return true;
    }
}
