package myApp.figure.factory;

import myApp.figure.FigureFactory;

import java.util.List;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

public abstract class ShapeFactory implements FigureFactory {
    public static List<ShapeFactory> getServices(ModuleLayer layer) {
        ServiceLoader<ShapeFactory> load = ServiceLoader
                .load(layer, ShapeFactory.class);
        return load
                .stream()
                .map(ServiceLoader.Provider::get)
                .collect(Collectors.toList());
    }
}
