package decorator;

/**
 * A size wrapper for a grid object. Once called, it will take in the current grid and
 * the requested size of the grid that the user asks for,
 * and then appropriately represents a new grid to be displayed.
 */
public class Size extends GridDecorator{
    float size;

    /**
     * Constructor for the size wrapper class.
     * @param currGrid The grid that needs to be modified.
     * @param size The size that the new wrapped grid must be.
     */
    public Size(Grid currGrid, float size) {
        super(currGrid);
        this.size = size;
    }

    /**
     * Gets the size that this grid object currently is.
     * @return the current size of this grid on display
     */

    @Override
    public float getSize() {
        return this.size;
    }
}
