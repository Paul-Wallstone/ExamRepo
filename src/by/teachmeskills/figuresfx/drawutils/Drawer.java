package by.teachmeskills.figuresfx.drawutils;

import by.teachmeskills.figuresfx.figures.Figure;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import org.apache.log4j.Logger;


import java.util.List;

public class Drawer<T extends Figure & Drawable> {
    private List<T> figures;
    private Canvas canvas;
    private Logger logger = Logger.getLogger(Drawer.class);

    public Drawer(List<T> figures) {
        this.figures = figures;
    }

    public Drawer(List<T> figures, Canvas canvas) {
        this.figures = figures;
        this.canvas = canvas;
    }

    public void draw(GraphicsContext gc) {
        for (Figure figure : figures) {
            figure.draw(gc);
        }
    }

    public void repaint() {
        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        Drawer<T> drawer = new Drawer<>(figures);
        drawer.draw(canvas.getGraphicsContext2D());
        logger.info("canvas was repainted");
    }
}
