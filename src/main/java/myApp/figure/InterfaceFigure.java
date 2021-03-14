package myApp.figure;

import javafx.scene.canvas.GraphicsContext;

public interface InterfaceFigure
{
        void drawFigure(GraphicsContext graphicsContext);
        void setPoints(double ... points);
        void changePoints(double ... points);
        void closeFigure();
        }
