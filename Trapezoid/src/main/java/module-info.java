import myApp.figure.factory.ShapeFactory;
import org.figure.Trapezoid;
import org.figure.TrapezoidFactory;

module org.figure {
    requires javafx.controls;
    requires javafx.fxml;
    requires myApp;

    opens org.figure to javafx.fxml;
    exports org.figure;
    provides ShapeFactory with TrapezoidFactory;
}