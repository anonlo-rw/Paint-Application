/** FX Graphics Template */
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Implementation of the Square Class that extends over to
 * the GeometricObject class and draws a Square
 */
public class Square extends GeometricObject
{
    /** double size for creating shaped squared */
    private double size;

    /**
     * Square Constructor for storing it's variables
     * @param x
     * @param y
     * @param fillColor
     * @param radius
     */
    public Square(double x, double y, Color fillColor, double radius) {
        super(x, y, fillColor); // Call GeometricObject Constructor
        this.size = radius;
    }

    /**
     * Fill Color of shape and create shaped Square
     * @param gc
     */
    public void draw(GraphicsContext gc) {
        gc.setFill(getFillColor());
        gc.fillRect(getX() - size, getY() - size, size * 2, size * 2);
    }
}
