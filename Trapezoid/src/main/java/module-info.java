module org.figure {
    requires javafx.controls;
    requires javafx.fxml;
    requires myApp;

    opens org.figure to javafx.fxml;
    exports org.figure;
}