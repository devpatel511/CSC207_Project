package decorator;

/**
 * A representation of the base display for a grid. It can later be
 * customized in the settings of the game by the user.
 */
public class BaseGrid implements Grid{

    String color = "BLACK";
    float size = 1;
    String shape = "SHARP";

    /**
     * Returns the specific base color that this grid should be displayed as
     */
    @Override
    public String getColor() {
        return this.color;
    }

    /**
     * Returns the specific base size that this grid should be displayed as
     */
    @Override
    public float getSize() {
        return this.size;
    }

    /**
     * Returns the specific base shape that this grid should be displayed as
     */
    @Override
    public String getShape() {
        return this.shape;
    }
}
