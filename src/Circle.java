/** FX Graphics Template */
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Implementation of the Circle Class that extends over to
 * the GeometricObject class and draws a Circle
 */
public class Circle extends GeometricObject
{
    /** double radius for creating shaped circle */
    private double radius;

    /**
     * Circle Constructor for storing it's variables
     * @param x
     * @param y
     * @param fillColor
     * @param radius
     */
    public Circle(double x, double y, Color fillColor, double radius) {
        super(x, y, fillColor); // Call GeometricObject Constructor
        this.radius = radius;
    }

    /**
     * Fill Color of shape and create shaped Square
     * @param gc
     */
    public void draw(GraphicsContext gc) {
        gc.setFill(getFillColor());
        gc.fillOval(getX() - radius, getY() - radius, radius * 2, radius * 2);
    }
}
