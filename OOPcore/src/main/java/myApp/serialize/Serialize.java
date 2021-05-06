package myApp.serialize;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import myApp.figure.FigureList;

import java.io.*;

public class Serialize {
    FileChooser fileChooser = new FileChooser();

    public FigureList openFile(Stage stage)  {
        FigureList figureList = new FigureList();
        fileChooser.setTitle("Выбор файла");
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileChooser.showOpenDialog(stage)));
            try {
                figureList = (FigureList) inputStream.readObject();
                System.out.println(figureList.toString());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            inputStream.close();
            return figureList;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void saveFile(Stage stage, FigureList figureList) {
        fileChooser.setTitle("Сохранить");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Files", "*.*"));
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileChooser.showSaveDialog(stage)));
            outputStream.writeObject(figureList);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

