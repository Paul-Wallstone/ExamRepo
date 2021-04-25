package by.teachmeskills.figuresfx.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class MyFigure extends Figure {
    private int shiftX;
    private int shiftY;

    public MyFigure(double cx, double cy, double lineWith, Color color) {
        super(FIGURE_TYPE_MYFIGURE, cx, cy, lineWith, color);
    }

    public MyFigure(double cx, double cy, double lineWith, Color color, int shiftX, int shiftY) {
        super(FIGURE_TYPE_MYFIGURE, cx, cy, lineWith, color);
        this.shiftX = shiftX < 40 ? 40 : shiftX;
        this.shiftY = shiftY < 10 ? 10 : shiftY;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setLineWidth(lineWith);
        graphicsContext.setStroke(color);
        graphicsContext.strokeArc(cx - shiftX / 2, cy - shiftY, shiftX, shiftY * 2, 0, 180, ArcType.OPEN);
        graphicsContext.strokeArc(cx - shiftX - 15, cy, 35, shiftY, 90, 180, ArcType.OPEN);
        graphicsContext.strokeArc(cx + shiftX - 20, cy, 35, shiftY, 270, 180, ArcType.OPEN);
        graphicsContext.strokePolygon(new double[]{cx - shiftX, cx - shiftX, cx + shiftX, cx + shiftX},
                new double[]{cy + shiftY, cy, cy, cy + shiftY}, 4);

    }

}
