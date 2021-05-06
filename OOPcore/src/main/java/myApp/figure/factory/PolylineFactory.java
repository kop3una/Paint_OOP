package myApp.figure.factory;

import myApp.figure.Figure;
import myApp.figure.particularFigure.Polyline;

public class PolylineFactory extends ShapeFactory {
    @Override
    public String getName() {
        return "polyline";
    }

    @Override
    public Figure newFigure() {
        return new Polyline();
    }
}
