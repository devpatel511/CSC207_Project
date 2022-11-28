package decorator;

/**
 * A color wrapper for a grid object. Once called, it will take in the current grid and
 * the desired color, and then represents a new grid to be displayed.
 */
public class Color extends GridDecorator{
    String color;

    /**
     * Constructor for the color wrapper class.
     * @param currGrid The grid that needs to be modified.
     * @param color The color that the new grid must be displayed as.
     */
    public Color(Grid currGrid, String color) {
        super(currGrid);
        this.color = color;
    }

    /**
     * Gets the color that this grid object currently is.
     * @return the current color of this grid on display
     */
    @Override
    public String getColor() {
        return this.color;
    }
}
