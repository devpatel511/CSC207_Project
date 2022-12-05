package decorator;

public class Size extends GridDecorator{
    float size;

    public Size(Grid currGrid, float size) {
        super(currGrid);
        this.size = size;
    }

    @Override
    public float getSize() {
        return this.size;
    }
}
