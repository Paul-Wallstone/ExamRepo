package by.teachmeskills.figuresfx.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends Figure {
    private double width;
    private double height;

    private Rectangle(double cx, double cy, double lineWith, Color color) {
        super(FIGURE_TYPE_RECTANGLE, cx, cy, lineWith, color);
    }

    public Rectangle(double cx, double cy, double lineWith, Color color, double width, double height) {
        this(cx, cy, lineWith, color);
        this.width = width < 30 ? 30 : width;
        this.height = height < 30 ? 30 : height;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setLineWidth(lineWith);
        graphicsContext.setStroke(color);
        graphicsContext.strokeRect(cx - width / 2, cy - height / 2, width, height);
    }
}
