package myApp.figure.factory;

import myApp.figure.Figure;
import myApp.figure.FigureFactory;
import myApp.figure.particularFigure.Square;

public class SquareFactory implements FigureFactory {
    @Override
    public Figure newFigure() {
        return new Square();
    }
}
