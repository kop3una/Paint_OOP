package myApp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;

import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private static Scene scene;
    private static FileChooser fileChooser;

    private static Stage stage;

    @Override
    public void start(Stage stage) throws IOException {

        scene = new Scene(loadFXML("mainScene"));
        stage.setScene(scene);
        fileChooser = new FileChooser();
        fileChooser.setTitle("Выбор файла");
       // fileChooser.showOpenDialog(stage);
        stage.setTitle("Графический редактор");
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    static void openFile() {
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