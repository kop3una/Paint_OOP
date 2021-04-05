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
import myApp.figure.particularFigure.*;

import java.util.Arrays;
import java.util.List;

public class MainScene {

    private final List<Figure> figuresSelectList = Arrays.asList(new Line(), new Rectangle(), new Square(), new Circle(), new Ellipse(), new Polyline(), new Polygon());
    private final FigureList figureList = new FigureList();
    private boolean isDrawPoly = false;
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
    @FXML
    private Button btnSquare;
    @FXML
    private Button btnCircle;
    @FXML
    private Button btnEllipse;
    @FXML
    private Button btnPolyline;
    @FXML
    private Button btnPolygon;
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
    public void initialize() {
        figureIndex = 0;
        canvaspreview.setVisible(true);
        canvas.setVisible(true);
    }

    @FXML
    private void selectFigure() {
        isDrawPoly = false;
        btnLine.setOnMouseClicked(event -> figureIndex = 0);
        btnRectangle.setOnMouseClicked(event -> figureIndex = 1);
        btnSquare.setOnMouseClicked(event -> figureIndex = 2);
        btnCircle.setOnMouseClicked(event -> figureIndex = 3);
        btnEllipse.setOnMouseClicked(event -> figureIndex = 4);
        btnPolyline.setOnMouseClicked(event -> figureIndex = 5);
        btnPolygon.setOnMouseClicked(event -> figureIndex = 6);
    }

    @FXML
    private void click(MouseEvent e) {
      //  System.out.println(canvaspreview.visibleProperty());
       // System.out.println(canvas.visibleProperty());
        //canvaspreview.setVisible(true);

        GraphicsContext context = canvas.getGraphicsContext2D();
        figure.setLineConfig(context, colpi, slider);
        figure.setFillConfig(context, colpiFill);
        if (figure.isPolyFigure()){
            figure.addPoints(e.getX(),e.getY());
            figure.drawFigure(context);
          //  figure.changePoints();
        } else {
            figure.setPoints(x,y,e.getX(), e.getY());
            System.out.println("click" + e.getX() + " " + e.getY());
            figureList.add(figure);
            figure.drawFigure(context);
     //   canvaspreview.setVisible(false);
       }
    //    System.out.println(canvaspreview.visibleProperty());
   //     System.out.println(canvas.visibleProperty());
    }

    @FXML
    private void press(MouseEvent e) {
        GraphicsContext context = canvas.getGraphicsContext2D();
        //canvaspreview.setVisible(true);
        if (e.getButton() == MouseButton.SECONDARY){
            if (figureIndex == 5){
                figure = new Polyline();
            }
            if (figureIndex == 6){
                figure = new Polygon();
            }
           // System.out.println(e.getButton());

        }

        if ((!isDrawPoly) && (figureIndex <=4)){
            figure = figuresSelectList.get(figureIndex);
        }

        if ((!isDrawPoly) && (figureIndex == 5)){
            figure = new Polyline();
            }
        if ((!isDrawPoly) && (figureIndex == 6)){
            figure = new Polygon();
        }

        if (figure.isPolyFigure()) {
            isDrawPoly = true;
            figure.addPoints(e.getX(), e.getY());
        } else {
            x = e.getX();
            y = e.getY();
    //        System.out.println(canvaspreview.visibleProperty());
   ////         System.out.println(canvas.visibleProperty());
        }
           System.out.println("press" + e.getX() + " " + e.getY());
      //    figure.addPoints(e.getX(),e.getY());
    }

    @FXML
    private void drag(MouseEvent e) {
       // canvaspreview.setVisible(true);
        System.out.println(canvaspreview.visibleProperty());
        System.out.println(canvas.visibleProperty());
        GraphicsContext context = canvaspreview.getGraphicsContext2D();
        context.clearRect(0, 0, canvaspreview.getWidth(), canvaspreview.getHeight());
        figure.setLineConfig(context, colpi, slider);
        figure.setFillConfig(context, colpiFill);
        if (figure.isPolyFigure()){
            figure.addPoints(e.getX(),e.getY());
            figure.drawFigure(context);
            figure.changePoints();
        } else {
            figure.setPoints(x,y,e.getX(), e.getY());
            figure.drawFigure(context);
        }


    }

}

