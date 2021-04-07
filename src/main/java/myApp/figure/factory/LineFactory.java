package myApp.figure.factory;

import myApp.figure.Figure;
import myApp.figure.FigureFactory;
import myApp.figure.particularFigure.Line;

public class LineFactory implements FigureFactory {
    @Override
    public Figure newFigure() {
        return new Line();
    }
}
