package decorator;

public class Color extends GridDecorator{
    String color;

    public Color(Grid currGrid, String color) {
        super(currGrid);
        this.color = color;
    }

    @Override
    public String getColor() {
        return this.color;
    }
}
