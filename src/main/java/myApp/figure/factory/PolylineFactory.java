package myApp.figure.factory;

import myApp.figure.Figure;
import myApp.figure.FigureFactory;
import myApp.figure.particularFigure.Polyline;

public class PolylineFactory implements FigureFactory {
    @Override
    public Figure newFigure() {
        return new Polyline();
    }
}
