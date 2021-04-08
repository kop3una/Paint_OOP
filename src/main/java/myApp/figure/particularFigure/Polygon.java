package myApp.figure.particularFigure;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import myApp.figure.Figure;

import java.util.Arrays;

public class Polygon extends Figure {
    int length;
    double [] x = new double[10] ;
    double [] y = new double[10];

    public Polygon () {
        length = 0;
    }

    @Override
    public void drawFigure(GraphicsContext graphicsContext) {
        graphicsContext.strokePolygon(x,y,length);
        graphicsContext.fillPolygon(x,y,length);

    }

    @Override
    public void setLineConfig(GraphicsContext graphicsContext, ColorPicker colorPicker, Slider slider) {
        graphicsContext.setStroke(colorPicker.getValue());
        graphicsContext.setLineWidth(slider.getValue());
    }

    @Override
    public void setFillConfig(GraphicsContext graphicsContext, ColorPicker colorPicker) {
        graphicsContext.setFill(colorPicker.getValue());
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
        length--;
     //   System.out.println(length);
    }

    @Override
    public void closeFigure() {

    }

    @Override
    public boolean isPolyFigure() {
        return true;
    }
}
