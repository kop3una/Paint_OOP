package myApp;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.FileChooser;

import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

//    @FXML
//    private GraphicsContext context = canvas.getGraphicsContext2D();
//
//    private void drawLine (GraphicsContext gc){
//        gc.strokeLine(10,10,40,40); }

    private static FileChooser fileChooser;

    private static Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(loadFXML("mainScene"));
        stage.setScene(scene);
        fileChooser = new FileChooser();
        stage.setTitle("Графический редактор");
        stage.show();
    }

    static void openFile() {
        fileChooser.setTitle("Выбор файла");
        fileChooser.showOpenDialog(stage);
    }

    static void saveFile() {
        fileChooser.setTitle("Сохранить");
        fileChooser.showOpenDialog(stage);
    }

    static void saveAsFile() {
        fileChooser.setTitle("Сохранить как");
        fileChooser.showOpenDialog(stage);
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}