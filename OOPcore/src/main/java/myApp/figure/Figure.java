package myApp.figure;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;

import java.io.Serializable;

public abstract class Figure implements InterfaceFigure, Serializable {
    public abstract void drawFigure(GraphicsContext graphicsContext);

    public abstract void setLineConfig(GraphicsContext graphicsContext, ColorPicker colorPicker, Slider slider);

    public abstract void setFillConfig(GraphicsContext graphicsContext, ColorPicker colorPicker);

    public abstract void setPoints(double... points);

    public abstract void addPoints(double ... points);

    public abstract void changePoints(double... points);

    public abstract void closeFigure();

    public abstract boolean isPolyFigure ();
}
