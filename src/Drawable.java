/** FX Graphics Template */
import javafx.scene.canvas.GraphicsContext;

/**
 * Implementation for the Drawable Class that is an interface
 */
public interface Drawable
{
    // mandatory method for classes that implement Drawable
    public abstract void draw(GraphicsContext gc);
}
