package myApp.figure;

import javafx.scene.canvas.GraphicsContext;

public abstract class Figure implements InterfaceFigure {
        public abstract void drawFigure(GraphicsContext graphicsContext);
        protected abstract void setLineConfig ();
        protected abstract void setFillConfig ();
        public abstract void setPoints(double ... points);
        public abstract void changePoints(double ... points);
        public abstract void closeFigure();
}
