package decorator;

/**
 * GridDecorator class that acts as a template for all grid decorators.
 */
public abstract class GridDecorator implements Grid{

    Grid grid;

    public GridDecorator(Grid currGrid)
    {
        this.grid = currGrid;
    }

    /**
     * Get the color of the grid
     */
    @Override
    public String getColor() {
        return this.grid.getColor();
    }

    /**
     * Get the size of the grid
     */
    @Override
    public float getSize() {
        return this.grid.getSize();
    }

    /**
     * Get the shape of the grid
     */
    @Override
    public String getShape() {
        return this.grid.getShape();
    }
}
