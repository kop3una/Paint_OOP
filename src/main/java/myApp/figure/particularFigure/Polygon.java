package myApp.figure.particularFigure;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import myApp.figure.Figure;

public class Polygon extends Figure {
    int length;
    double [] x = new double[1000] ;
    double [] y = new double[1000];

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
        System.out.println(length);
    }

    @Override
    public void changePoints(double... points) {
        length--;
        System.out.println(length);
    }

    @Override
    public void closeFigure() {

    }

    @Override
    public boolean isPolyFigure() {
        return true;
    }
}
