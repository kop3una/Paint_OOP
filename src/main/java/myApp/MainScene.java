package myApp;

import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

public class MainScene {

    @FXML
    private ColorPicker colpi;

    @FXML
    private void changeColorBlack() {
        colpi.setValue(Color.BLACK);
    }

    @FXML
    private void changeColorWhite() {
        colpi.setValue(Color.WHITE);
    }

    @FXML
    private void changeColorRed() {
        colpi.setValue(Color.RED);
    }

    @FXML
    private void changeColorOrange() {
        colpi.setValue(Color.ORANGE);
    }

    @FXML
    private void changeColorYellow() {
        colpi.setValue(Color.YELLOW);
    }

    @FXML
    private void changeColorGreen() {
        colpi.setValue(Color.GREEN);
    }

    @FXML
    private void changeColorBlue() {
        colpi.setValue(Color.BLUE);
    }

    @FXML
    private void changeColorViolet() {
        colpi.setValue(Color.VIOLET);
    }

    @FXML
    private void openFile() {
        App.openFile();
    }

    @FXML
    private void saveFile() {
        App.saveFile();
    }

    @FXML
    private void saveAsFile() {
        App.saveAsFile();
    }

}
