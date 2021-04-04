package myApp.figure;

import java.util.ArrayList;

public class FigureList extends ArrayList<Figure> {
    private ArrayList<Figure> List;

    public FigureList () {
        this.List = new ArrayList<>(5);
    }

    public void undo() {
        //отменить
    }

    public void redo() {
        //вперед
    }


}
