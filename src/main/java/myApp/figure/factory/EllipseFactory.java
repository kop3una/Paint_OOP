package myApp.figure.factory;

import myApp.figure.Figure;
import myApp.figure.FigureFactory;
import myApp.figure.particularFigure.Ellipse;

public class EllipseFactory implements FigureFactory {
    @Override
    public Figure newFigure() {
        return new Ellipse();
    }
}
