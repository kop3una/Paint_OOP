package org.figure;

import myApp.figure.Figure;
import myApp.figure.factory.ShapeFactory;

public class TrapezoidFactory extends ShapeFactory {
    @Override
    public String getName() {
        return "trapezoid";
    }

    @Override
    public Figure newFigure() {
        return new Trapezoid();
    }
}
