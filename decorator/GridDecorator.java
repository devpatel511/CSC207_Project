package decorator;

public class GridDecorator implements Grid{

    Grid grid;

    public GridDecorator(Grid currGrid)
    {
        this.grid = currGrid;
    }

    @Override
    public String getColor() {
        return this.grid.getColor();
    }

    @Override
    public float getSize() {
        return this.grid.getSize();
    }

    @Override
    public String getShape() {
        return this.grid.getShape();
    }
}
