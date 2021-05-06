package myApp.figure.factory;

import myApp.figure.Figure;
import myApp.figure.particularFigure.Circle;

public class CircleFactory extends ShapeFactory {
    @Override
    public Figure newFigure() {
        return new Circle();
    }
}
