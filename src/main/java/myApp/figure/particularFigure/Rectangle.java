package myApp.figure.particularFigure;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import myApp.figure.Figure;

public class Rectangle extends Figure {
    private double xStart = 0, yStart = 0, xEnd = 0, yEnd = 0,x,y;

    @Override
    public void drawFigure(GraphicsContext graphicsContext) {
        double height, weight;
        if (xStart <= xEnd) {
            if (yStart <= yEnd) {
                weight = xEnd - xStart;
                height = yEnd - yStart;
            } else {
                weight = xEnd - xStart;
                height = yStart - yEnd;
                yStart = yEnd;
            }
        } else {
            if (yStart >= yEnd) {
                height = yStart - yEnd;
                weight = xStart - xEnd;
                xStart = xEnd;
                yStart = yEnd;
            } else {
                height = yEnd - yStart;
                weight = xStart - xEnd;
                xStart = xEnd;
            }

        }

        graphicsContext.strokeRect(xStart, yStart, weight, height);
        graphicsContext.fillRect(xStart, yStart, weight, height);
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
        xStart = x;
        yStart = y;
        xEnd = points[0];
        yEnd = points[1];
    }

    @Override
    public void addPoints(double... points) {
        x = points[0];
        y = points[1];
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
