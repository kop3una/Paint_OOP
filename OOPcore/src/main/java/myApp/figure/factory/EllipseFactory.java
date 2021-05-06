package myApp.figure.factory;

import myApp.figure.Figure;
import myApp.figure.particularFigure.Ellipse;

public class EllipseFactory extends ShapeFactory {
    @Override
    public String getName() {
        return "ellipse";
    }

    @Override
    public Figure newFigure() {
        return new Ellipse();
    }
}
