package myApp.figure.factory;

import myApp.figure.Figure;
import myApp.figure.FigureFactory;
import myApp.figure.particularFigure.Line;

public class LineFactory extends ShapeFactory {
    @Override
    public Figure newFigure() {
        return new Line();
    }
}
