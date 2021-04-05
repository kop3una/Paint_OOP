package myApp.figure.particularFigure;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import myApp.figure.Figure;

public class Line extends Figure {
    double xstart = 0, ystart = 0, xend = 0, yend = 0;

    @Override
    public void drawFigure(GraphicsContext graphicsContext) {
        graphicsContext.strokeLine(xstart, ystart, xend, yend);
    }

    @Override
    public void setLineConfig(GraphicsContext graphicsContext, ColorPicker colorPicker, Slider slider) {
        graphicsContext.setStroke(colorPicker.getValue());
        graphicsContext.setLineWidth(slider.getValue());
    }

    @Override
    public void setFillConfig(GraphicsContext graphicsContext, ColorPicker colorPicker) {
    }

    @Override
    public void setPoints(double... points) {
        xstart = points[0];
        ystart = points[1];
        xend = points[2];
        yend = points[3];
    }

    @Override
    public void addPoints(double... points) {
    }

    @Override
    public void changePoints(double... points) {

    }

    @Override
    public void closeFigure() {

    }

    @Override
    public boolean isPolyFigure() {
        return false;
    }

}
