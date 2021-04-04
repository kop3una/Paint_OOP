package myApp.figure.particularFigure;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import myApp.figure.Figure;

public class Rectangle extends Figure {
    double xstart = 0, ystart = 0, xend = 0, yend = 0;
    double height, weight;

    @Override
    public void drawFigure(GraphicsContext graphicsContext) {
        if (xstart <= xend) {
            if (ystart <= yend) {
                weight = xend - xstart;
                height = yend - ystart;
            } else {
                weight = xend - xstart;
                height = ystart - yend;
                ystart = yend;
            }
        } else {
            if (ystart >= yend) {
                height = ystart - yend;
                weight = xstart - xend;
                xstart = xend;
                ystart = yend;
            } else {
                height = yend - ystart;
                weight = xstart - xend;
                xstart = xend;
            }

        }

        graphicsContext.strokeRect(xstart, ystart, weight, height);
        graphicsContext.fillRect(xstart,ystart,weight,height);
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
        xstart = points[0];
        ystart = points[1];
        xend = points[2];
        yend = points[3];
    }

    @Override
    public void changePoints(double... points) {

    }

    @Override
    public void closeFigure() {
    }

}
