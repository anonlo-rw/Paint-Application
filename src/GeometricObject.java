/** FX Graphics Template */
import javafx.scene.paint.Color;

/**
 * Implementation of the GeometricObject class which is
 * the parent class for Circle and Rectangle and stores it's variables
 */
public class GeometricObject
{
    /** double (float type) X and Y - Axis */
    private double x, y;

    /** Color Object to store different colors */
    private Color fillColor;

    /**
     * GeometricObject Constructor for storing it's variables
     * @param x
     * @param y
     * @param fillColor
     */
    public GeometricObject(double x, double y, Color fillColor) {
        this.x = x;
        this.y = y;
        this.fillColor = fillColor;
    }

    /**
     * @return double 'x' - axis
     */
    public double getX() {
        return x;
    }
    
    /**
     * @return double 'y' - axis
     */
    public double getY() {
        return y;
    }

    /**
     * @return Color Object containing color
     */
    public Color getFillColor() {
        return fillColor;
    }
}
