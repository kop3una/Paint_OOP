package OOPcore;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import myApp.figure.factory.ShapeFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Buttons {
    List<ShapeFactory> shapeFactors;
    ArrayList<Button> buttonsList = new ArrayList<>();

    public Buttons(List<ShapeFactory> selectedFigureList) throws FileNotFoundException {
        this.shapeFactors = selectedFigureList;
        createButton();
    }

    private void createButton () throws FileNotFoundException {
        for (ShapeFactory factory : shapeFactors){
            FileInputStream input = new FileInputStream("..\\OOP_new\\OOPcore\\src\\main\\resources\\img\\"+factory.getName()+".png");
            Image image = new Image(input);
            ImageView imageView = new ImageView(image);
            Button button = new Button("",imageView);
            button.setFocusTraversable(false);
            button.setPrefHeight(38);
            button.setPrefWidth(38);
            buttonsList.add(button);
        }
    }

    public List<Button> getButtonsList(){
        return buttonsList;
    }

    public int getButtonIndex(Button button) {
        return buttonsList.indexOf(button);
    }
}
