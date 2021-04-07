package myApp.figure.factory;

import myApp.figure.Figure;
import myApp.figure.FigureFactory;
import myApp.figure.particularFigure.Polygon;

public class PolygonFactory implements FigureFactory {
    @Override
    public Figure newFigure() {
        return new Polygon();
    }
}
