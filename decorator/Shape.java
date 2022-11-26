package decorator;

public class Shape extends GridDecorator{
    String shape;

    public Shape(Grid currGrid, String shape) {
        super(currGrid);
        this.shape = shape;
    }

    @Override
    public String getShape() {
        return this.shape;
    }
}
