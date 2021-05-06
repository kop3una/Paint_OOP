import myApp.figure.factory.ShapeFactory;
import myApp.figure.factory.*;

module myApp {
    uses myApp.figure.factory.ShapeFactory;
    requires javafx.controls;
    requires javafx.fxml;

    opens myApp to javafx.fxml;
    exports myApp;
    exports myApp.figure;
    exports myApp.figure.factory;
    provides ShapeFactory with LineFactory,RectangleFactory,SquareFactory,CircleFactory,EllipseFactory,PolylineFactory,PolygonFactory;
}