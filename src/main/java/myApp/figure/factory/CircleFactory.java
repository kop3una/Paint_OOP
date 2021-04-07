package myApp.figure.factory;

import myApp.figure.Figure;
import myApp.figure.FigureFactory;
import myApp.figure.particularFigure.Circle;

public class CircleFactory implements FigureFactory {
    @Override
    public Figure newFigure() {
        return new Circle();
    }
}
