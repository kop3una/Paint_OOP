package myApp;

import OOPcore.Buttons;
import OOPcore.PluginLoader;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import myApp.figure.Figure;
import myApp.figure.FigureList;
import myApp.figure.factory.*;

import java.io.FileNotFoundException;
import java.util.List;

public class MainScene {


    private List<ShapeFactory> figuresSelectList; //= Arrays.asList(new LineFactory(), new RectangleFactory(), new SquareFactory(), new CircleFactory(), new EllipseFactory(), new PolylineFactory(), new PolygonFactory());
    private FigureList figureList = new FigureList();
    private boolean isDrawPoly = false;

    @FXML
    private VBox vBox;
    @FXML
    private Canvas canvas;
    @FXML
    private Canvas canvasPreview;
    @FXML
    private ColorPicker colPi;
    @FXML
    private ColorPicker colPiFill;
    @FXML
    private Slider slider;
    private int figureIndex;
    private Figure figure;

    @FXML
    private void changeColorBlack(MouseEvent e) {
        if (e.getButton() == MouseButton.PRIMARY) {
            colPi.setValue(Color.BLACK);
        }
        if (e.getButton() == MouseButton.SECONDARY) {
            colPiFill.setValue(Color.BLACK);
        }
    }

    @FXML
    private void changeColorWhite(MouseEvent e) {
        if (e.getButton() == MouseButton.PRIMARY) {
            colPi.setValue(Color.WHITE);
        }
        if (e.getButton() == MouseButton.SECONDARY) {
            colPiFill.setValue(Color.WHITE);
        }
    }

    @FXML
    private void changeColorRed(MouseEvent e) {
        if (e.getButton() == MouseButton.PRIMARY) {
            colPi.setValue(Color.RED);
        }
        if (e.getButton() == MouseButton.SECONDARY) {
            colPiFill.setValue(Color.RED);
        }
    }

    @FXML
    private void changeColorOrange(MouseEvent e) {
        if (e.getButton() == MouseButton.PRIMARY) {
            colPi.setValue(Color.ORANGE);
        }
        if (e.getButton() == MouseButton.SECONDARY) {
            colPiFill.setValue(Color.ORANGE);
        }
    }

    @FXML
    private void changeColorYellow(MouseEvent e) {
        if (e.getButton() == MouseButton.PRIMARY) {
            colPi.setValue(Color.YELLOW);
        }
        if (e.getButton() == MouseButton.SECONDARY) {
            colPiFill.setValue(Color.YELLOW);
        }
    }

    @FXML
    private void changeColorGreen(MouseEvent e) {
        if (e.getButton() == MouseButton.PRIMARY) {
            colPi.setValue(Color.GREEN);
        }
        if (e.getButton() == MouseButton.SECONDARY) {
            colPiFill.setValue(Color.GREEN);
        }
    }

    @FXML
    private void changeColorBlue(MouseEvent e) {
        if (e.getButton() == MouseButton.PRIMARY) {
            colPi.setValue(Color.BLUE);
        }
        if (e.getButton() == MouseButton.SECONDARY) {
            colPiFill.setValue(Color.BLUE);
        }
    }

    @FXML
    private void changeColorViolet(MouseEvent e) {
        if (e.getButton() == MouseButton.PRIMARY) {
            colPi.setValue(Color.VIOLET);
        }
        if (e.getButton() == MouseButton.SECONDARY) {
            colPiFill.setValue(Color.VIOLET);
        }
    }

    @FXML
    private void openFile() {
        GraphicsContext context = canvas.getGraphicsContext2D();
        figureList = App.openFile();
        context.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        figureList.drawAllFigure(context);
    }

    @FXML
    private void saveFile() {
        App.saveFile(figureList);
    }

    @FXML
    public void initialize() throws FileNotFoundException {
        figureIndex = 0;
        canvasPreview.setVisible(true);
        canvas.setVisible(true);
        PluginLoader pluginLoader = new PluginLoader();
        figuresSelectList = pluginLoader.getEveryFactory();
        sortFactories(figuresSelectList);
        System.out.println(figuresSelectList);
        Buttons buttons = new Buttons(figuresSelectList);
        for (Button button : buttons.getButtonsList()){
            vBox.getChildren().add(button);
            button.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {isDrawPoly = false; figureIndex = buttons.getButtonIndex(button);  System.out.println(figureIndex);});
        }
    }

    @FXML
    private void click(MouseEvent e) {
        GraphicsContext context = canvas.getGraphicsContext2D();
        GraphicsContext contextPreview = canvasPreview.getGraphicsContext2D();
        contextPreview.clearRect(0, 0, canvasPreview.getWidth(), canvasPreview.getHeight());
        figure.setLineConfig(context, colPi, slider);
        figure.setFillConfig(context, colPiFill);
        if (figure.isPolyFigure()) {
            figure.addPoints(e.getX(), e.getY());
            context.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            figureList.drawPoly(context);
        } else {
            figure.setPoints(e.getX(), e.getY());
            figure.drawFigure(context);
        }
    }

    @FXML
    private void press(MouseEvent e) {
        ShapeFactory figureFactory;
        if (e.getButton() == MouseButton.SECONDARY) {
            isDrawPoly = false;
        }

        if (!isDrawPoly) {
            figureFactory = figuresSelectList.get(figureIndex);
            figure = figureFactory.newFigure();
            figureList.addFigure(figure);
        }

        if (figure.isPolyFigure()) {
            isDrawPoly = true;
        }
        figure.addPoints(e.getX(), e.getY());
    }

    @FXML
    private void drag(MouseEvent e) {
        GraphicsContext context = canvasPreview.getGraphicsContext2D();
        context.clearRect(0, 0, canvasPreview.getWidth(), canvasPreview.getHeight());
        figure.setLineConfig(context, colPi, slider);
        figure.setFillConfig(context, colPiFill);
        if (figure.isPolyFigure()) {
            figure.addPoints(e.getX(), e.getY());
            figure.drawFigure(context);
            figure.changePoints();
        } else {
            figure.setPoints(e.getX(), e.getY());
            figure.drawFigure(context);
        }
    }

    @FXML
    private void undo() {
        figureList.undo(canvas);
    }

    @FXML
    private void redo() {
        figureList.redo(canvas);

    }

    private void sortFactories (List<ShapeFactory> factories){
        ShapeFactory factory;
        int x = factories.size() / 7;
        int y = factories.size() % 7;
        for (int i=0; i < ((x-1)*7)+y; i++){
            factory = factories.get(0);
            factories.remove(0);
            factories.add(factory);
        }
    }

}

