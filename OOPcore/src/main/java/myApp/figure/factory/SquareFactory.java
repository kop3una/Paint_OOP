package myApp.figure.factory;

import myApp.figure.Figure;
import myApp.figure.particularFigure.Square;

public class SquareFactory extends ShapeFactory {
    @Override
    public Figure newFigure() {
        return new Square();
    }
}
