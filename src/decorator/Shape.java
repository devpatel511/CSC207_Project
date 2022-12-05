package decorator;


/**
 * A shape wrapper for a grid object. Once called, it will take in the current grid and
 * the desired shape that the user requests, and then represents a new grid to be displayed.
 */
public class Shape extends GridDecorator{
    String shape;

    /**
     * Constructor for the shape wrapper class.
     * @param currGrid The grid that needs to be modified.
     * @param shape The shape that the new grid must be displayed as.
     */
    public Shape(Grid currGrid, String shape) {
        super(currGrid);
        this.shape = shape;
    }

    /**
     * Gets the shape that this grid object is displayed as.
     * @return the current color of this grid on display
     */
    @Override
    public String getShape() {
        return this.shape;
    }
}
