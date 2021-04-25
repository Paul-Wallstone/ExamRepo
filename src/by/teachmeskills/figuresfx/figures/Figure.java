package by.teachmeskills.figuresfx.figures;


import by.teachmeskills.figuresfx.drawutils.Drawable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Figure implements Drawable {
    public static final int FIGURE_TYPE_CIRCLE = 0;
    public static final int FIGURE_TYPE_RECTANGLE = 1;
    public static final int FIGURE_TYPE_TRIANGLE = 2;
    public static final int FIGURE_TYPE_MYFIGURE = 3;

    private int type;

    protected double cx;
    protected double cy;
    protected double lineWith;
    protected Color color;

    public Figure(int type, double cx, double cy, double lineWith, Color color) {
        this.type = type;
        this.cx = cx;
        this.cy = cy;
        this.lineWith = lineWith;
        this.color = color;
    }

    public double getCx() {
        return cx;
    }

    public void setCx(double cx) {
        this.cx = cx;
    }

    public double getCy() {
        return cy;
    }

    public void setCy(double cy) {
        this.cy = cy;
    }

    public double getLineWith() {
        return lineWith;
    }

    public void setLineWith(double lineWith) {
        this.lineWith = lineWith;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getType() {
        return type;
    }

    public abstract void draw(GraphicsContext graphicsContext);
}
