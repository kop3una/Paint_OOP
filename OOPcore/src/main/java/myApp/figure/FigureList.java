package myApp.figure;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class FigureList extends ArrayList<Figure> {
    private final ArrayList<Figure> List;
    private int undoSize;

    public FigureList () {
        this.List = new ArrayList<>();
        this.undoSize = 0;
    }

    public void addFigure (Figure figure){
        undoSize++;
        this.List.add(figure);
        if (undoSize < List.size()){
            List.subList(undoSize-1, List.size()-1).clear();
        }
    }

    public void undo(Canvas canvas) {
        if (undoSize > 0){
            undoSize--;
            GraphicsContext context = canvas.getGraphicsContext2D();
            context.clearRect(0,0,canvas.getWidth(), canvas.getHeight());
            for (int i = 0; i < undoSize; i++) {
                List.get(i).drawFigure(context);
            }
        }
    }

    public void redo(Canvas canvas) {
        if (undoSize < List.size()){
            undoSize += 1;
            GraphicsContext context = canvas.getGraphicsContext2D();
            context.clearRect(0,0, canvas.getWidth(), canvas.getHeight());
            for (int i = 0; i < undoSize; i++) {
                List.get(i).drawFigure(context);
            }
        }
    }

    public void drawPoly(GraphicsContext context){
        for (Figure figure : List) {
            figure.drawFigure(context);
        }
    }

    public void drawAllFigure(GraphicsContext context){
        for (Figure figure : List){
            figure.drawFigure(context);
        }
    }


}
