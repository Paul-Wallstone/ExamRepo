package by.teachmeskills.figuresfx.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Triangle extends Figure {
    private int shiftX;
    private int shiftY;

    public Triangle(double cx, double cy, double lineWith, Color color) {
        super(FIGURE_TYPE_TRIANGLE, cx, cy, lineWith, color);
    }

    public Triangle(double cx, double cy, double lineWith, Color color, int shiftX, int shiftY) {
        super(FIGURE_TYPE_TRIANGLE, cx, cy, lineWith, color);
        this.shiftX = shiftX < 7 ? 7 : shiftX;
        this.shiftY = shiftY < 7 ? 7 : shiftY;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setLineWidth(lineWith);
        graphicsContext.setStroke(color);
        graphicsContext.strokePolygon(new double[]{cx, cx + shiftX, cx - shiftX}, new double[]{cy - shiftY, cy + shiftY, cy + shiftY}, 3);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "cx=" + cx +
                ", cy=" + cy +
                ", lineWith=" + lineWith +
                ", color=" + color +
                ", shiftX=" + shiftX +
                ", shiftY=" + shiftY +
                "} ";
    }
}
