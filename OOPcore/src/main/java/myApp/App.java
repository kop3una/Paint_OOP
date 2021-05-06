package myApp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import myApp.figure.FigureList;
import myApp.serialize.Serialize;

import java.io.IOException;

public class App extends Application {

    private static Stage stage;
    private static final Serialize serialize = new Serialize();

    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(loadFXML("mainScene"));
        stage.setScene(scene);
        stage.setTitle("Графический редактор");
        stage.show();
    }

    static FigureList openFile() {
        return serialize.openFile(stage);
    }

    static void saveFile(FigureList figureList) {
        serialize.saveFile(stage,figureList);
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}