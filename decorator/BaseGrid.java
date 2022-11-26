package decorator;

public class BaseGrid implements Grid{

    String color = "BLACK";
    float size = 1;
    String shape = "SHARP";

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public float getSize() {
        return this.size;
    }

    @Override
    public String getShape() {
        return this.shape;
    }
}
