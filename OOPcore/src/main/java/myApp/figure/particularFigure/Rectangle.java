package myApp.figure.particularFigure;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import myApp.figure.Figure;
import myApp.figure.MyColor;

public class Rectangle extends Figure {
    private double xStart = 0, yStart = 0, xEnd = 0, yEnd = 0,x,y;
    private final MyColor stroke = new MyColor();
    private final MyColor fill = new MyColor();
    private double lineWidth;

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

        Color colorStroke = Color.color(stroke.setRed(),stroke.setGreen(),stroke.setBlue());
        graphicsContext.setStroke(colorStroke);
        Color colorFill = Color.color(fill.setRed(),fill.setGreen(),fill.setBlue());
        graphicsContext.setFill(colorFill);
        graphicsContext.setLineWidth(lineWidth);
        graphicsContext.strokeRect(xStart, yStart, weight, height);
        graphicsContext.fillRect(xStart, yStart, weight, height);
    }

    @Override
    public void setLineConfig(GraphicsContext graphicsContext, ColorPicker colorPicker, Slider slider) {
        stroke.getColor(colorPicker.getValue());
        lineWidth = slider.getValue();
    }

    @Override
    public void setFillConfig(GraphicsContext graphicsContext, ColorPicker colorPicker) {
        fill.getColor(colorPicker.getValue());
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
