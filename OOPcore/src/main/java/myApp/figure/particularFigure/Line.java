package myApp.figure.particularFigure;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import myApp.figure.Figure;
import javafx.scene.paint.Color;
import myApp.figure.MyColor;
//import java.awt.Color;

public class Line extends Figure {
    private double xStart = 0, yStart = 0, xEnd = 0, yEnd = 0;
    private final MyColor stroke = new MyColor();
    private double lineWidth;

    @Override
    public void drawFigure(GraphicsContext graphicsContext) {
        Color color = Color.color(stroke.setRed(),stroke.setGreen(),stroke.setBlue());
        graphicsContext.setStroke(color);
        graphicsContext.setLineWidth(lineWidth);
        graphicsContext.strokeLine(xStart, yStart, xEnd, yEnd);
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
        xEnd = points[0];
        yEnd = points[1];
    }

    @Override
    public void addPoints(double... points) {
        xStart = points[0];
        yStart = points[1];
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
