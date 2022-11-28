package decorator;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class DecoratorTests {

    @Test
    void testColorDecorator()
    {
        Grid g = new BaseGrid();
        GridDecorator newG = new Color(g, "RED");
        assertNotSame(g.getColor(), newG.getColor());
        assertTrue(Objects.equals(g.getColor(), "BLACK") && Objects.equals(newG.getColor(), "RED"));
        assertSame(g.getShape(), newG.getShape());
        assertEquals(g.getSize(), newG.getSize());
    }

    @Test
    void testSizeDecorator()
    {
        Grid g = new BaseGrid();
        GridDecorator newG = new Size(g, 100);
        assertNotSame(g.getSize(), newG.getSize());
        assertTrue(g.getSize() == 1 && newG.getSize() == 100);
        assertSame(g.getShape(), newG.getShape());
        assertEquals(g.getColor(), newG.getColor());
    }

    @Test
    void testShapeDecorator()
    {
        Grid g = new BaseGrid();
        GridDecorator newG = new Shape(g, "SMOOTH");
        assertNotSame(g.getShape(), newG.getShape());
        assertTrue(Objects.equals(g.getShape(), "SHARP") && Objects.equals(newG.getShape(), "SMOOTH"));
        assertSame(g.getColor(), newG.getColor());
        assertEquals(g.getSize(), newG.getSize());
    }
}
