package myApp.figure;

import javafx.scene.canvas.GraphicsContext;
import myApp.serialize.Serialize;

import java.io.Serializable;

public interface InterfaceFigure {
    void drawFigure(GraphicsContext graphicsContext);

    void setPoints(double... points);

    void changePoints(double... points);

    void closeFigure();

    boolean isPolyFigure();
}
