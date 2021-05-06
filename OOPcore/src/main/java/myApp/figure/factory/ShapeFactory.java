package myApp.figure.factory;

import myApp.figure.Figure;

import java.util.List;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

public abstract class ShapeFactory {
    public abstract String getName ();
    public abstract Figure newFigure();
    public static List<ShapeFactory> getServices(ModuleLayer layer) {
        ServiceLoader<ShapeFactory> load = ServiceLoader
                .load(layer, ShapeFactory.class);
        return load
                .stream()
                .map(ServiceLoader.Provider::get)
                .collect(Collectors.toList());
    }
}
