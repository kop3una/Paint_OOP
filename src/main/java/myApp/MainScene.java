package myApp;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import myApp.figure.Figure;
import myApp.figure.FigureList;
import myApp.figure.particularFigure.Line;
import myApp.figure.particularFigure.Rectangle;

import java.util.Arrays;
import java.util.List;

public class MainScene {

    private final List<Figure> figuresSelectList = Arrays.asList(new Line(), new Rectangle());
    double x, y;
    @FXML
    private Canvas canvas;
    @FXML
    private Canvas canvaspreview;
    @FXML
    private ColorPicker colpi;
    @FXML
    private ColorPicker colpiFill;
    @FXML
    private Slider slider;
    @FXML
    private Button btnLine;
    @FXML
    private Button btnRectangle;
    private final FigureList figureList = new FigureList();
    private int figureIndex;
    private Figure figure;

    @FXML
    private void changeColorBlack(MouseEvent e) {
        if (e.getButton() == MouseButton.PRIMARY) {
            colpi.setValue(Color.BLACK);
        }
        if (e.getButton() == MouseButton.SECONDARY) {
            colpiFill.setValue(Color.BLACK);
        }
    }

    @FXML
    private void changeColorWhite(MouseEvent e) {
        if (e.getButton() == MouseButton.PRIMARY) {
            colpi.setValue(Color.WHITE);
        }
        if (e.getButton() == MouseButton.SECONDARY) {
            colpiFill.setValue(Color.WHITE);
        }
    }

    @FXML
    private void changeColorRed(MouseEvent e) {
        if (e.getButton() == MouseButton.PRIMARY) {
            colpi.setValue(Color.RED);
        }
        if (e.getButton() == MouseButton.SECONDARY) {
            colpiFill.setValue(Color.RED);
        }
    }

    @FXML
    private void changeColorOrange(MouseEvent e) {
        if (e.getButton() == MouseButton.PRIMARY) {
            colpi.setValue(Color.ORANGE);
        }
        if (e.getButton() == MouseButton.SECONDARY) {
            colpiFill.setValue(Color.ORANGE);
        }
    }

    @FXML
    private void changeColorYellow(MouseEvent e) {
        if (e.getButton() == MouseButton.PRIMARY) {
            colpi.setValue(Color.YELLOW);
        }
        if (e.getButton() == MouseButton.SECONDARY) {
            colpiFill.setValue(Color.YELLOW);
        }
    }

    @FXML
    private void changeColorGreen(MouseEvent e) {
        if (e.getButton() == MouseButton.PRIMARY) {
            colpi.setValue(Color.GREEN);
        }
        if (e.getButton() == MouseButton.SECONDARY) {
            colpiFill.setValue(Color.GREEN);
        }
    }

    @FXML
    private void changeColorBlue(MouseEvent e) {
        if (e.getButton() == MouseButton.PRIMARY) {
            colpi.setValue(Color.BLUE);
        }
        if (e.getButton() == MouseButton.SECONDARY) {
            colpiFill.setValue(Color.BLUE);
        }
    }

    @FXML
    private void changeColorViolet(MouseEvent e) {
        if (e.getButton() == MouseButton.PRIMARY) {
            colpi.setValue(Color.VIOLET);
        }
        if (e.getButton() == MouseButton.SECONDARY) {
            colpiFill.setValue(Color.VIOLET);
        }
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

    @FXML
    private void selectFigure() {
        btnLine.setOnMousePressed(event -> figureIndex = 0);
        btnRectangle.setOnMousePressed(event -> figureIndex = 1);
    }

    @FXML
    private void click(MouseEvent e) {
     //  canvaspreview.setVisible(false);
        GraphicsContext context = canvas.getGraphicsContext2D();
        Rectangle rectangle = new Rectangle();
        figure.setPoints(x, y, e.getX(), e.getY());
        figure.setLineConfig(context, colpi, slider );
        figure.setFillConfig(context,colpiFill);
      //  System.out.println("click" + e.getX() + " " + e.getY());
        figureList.add(figure);
        figure.drawFigure(context);
    }

    @FXML
    private void press(MouseEvent e) {
       // canvaspreview.setVisible(false);
        figure = figuresSelectList.get(figureIndex);
     //   System.out.println("press" + e.getX() + " " + e.getY());
        x = e.getX();
        y = e.getY();
    }

    @FXML
    private void drag(MouseEvent e) {
      //  canvaspreview.setVisible(true);
        GraphicsContext context = canvaspreview.getGraphicsContext2D();
        context.clearRect(0, 0, canvaspreview.getWidth(), canvaspreview.getHeight());
        figure.setPoints(x, y, e.getX(), e.getY());
        figure.setLineConfig(context, colpi, slider );
        figure.setFillConfig(context,colpiFill);
        figure.drawFigure(context);
    }

}

