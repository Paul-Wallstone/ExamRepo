package by.teachmeskills.figuresfx.controller;

import by.teachmeskills.figuresfx.FiguresFxApp;
import by.teachmeskills.figuresfx.drawutils.Drawer;
import by.teachmeskills.figuresfx.exceptions.FigureException;
import by.teachmeskills.figuresfx.figures.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import org.apache.log4j.Logger;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class MainScreenViewController implements Initializable {
    private static final Logger logger = Logger.getLogger(MainScreenViewController.class);
    private List<Figure> figures;
    private Random random;
    @FXML
    private Canvas canvas;


    @Override

    public void initialize(URL location, ResourceBundle resources) {
        figures = new ArrayList<>();
        random = new Random(System.currentTimeMillis());

    }

    private void addFigure(Figure figure) {
        figures.add(figure);
    }

    private Figure createFigure(double x, double y) throws FigureException {
        Figure figure;
        switch (random.nextInt(5)) {
            case Figure.FIGURE_TYPE_CIRCLE:
                figure = new Circle(x, y, random.nextInt(3), Color.GREEN, random.nextInt(50));
                break;
            case Figure.FIGURE_TYPE_RECTANGLE:
                figure = new Rectangle(x, y, random.nextInt(3), Color.AQUA, random.nextInt(60), random.nextInt(100));
                break;
            case Figure.FIGURE_TYPE_TRIANGLE:
                figure = new Triangle(x, y, random.nextInt(3), Color.CORAL, random.nextInt(50), random.nextInt(50));
                break;
            case Figure.FIGURE_TYPE_MYFIGURE:
                figure = new MyFigure(x, y, random.nextInt(3), Color.CORNFLOWERBLUE, random.nextInt(70), random.nextInt(30));
                break;
            default:
                throw new FigureException("Unknown figure type!");
        }
        return figure;
    }

    @FXML
    private void onMousedClicked(MouseEvent mouseEvent) {
        try {
            addFigure(createFigure(mouseEvent.getX(), mouseEvent.getY()));
        } catch (FigureException e) {
            logger.error(e.getMessage(), e);
        }
        Drawer<Figure> drawer = new Drawer<>(figures, canvas);
        drawer.repaint();

    }
}
