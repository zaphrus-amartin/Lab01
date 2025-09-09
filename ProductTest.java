import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    private Product apple;
    private Product banana;
    private Product carrot;

    @BeforeEach
    void setUp() {
        apple = new Product("Apple", "A001", 1.5, 10);
        banana = new Product("Banana", "B001", 0.75, 20);
        carrot = new Product("Carrot", "C001", 0.5, 15);
    }

    @Test
    void testGetTotalValue() {
        assertEquals(15.0, apple.getTotalValue());
        assertEquals(15.0, banana.getTotalValue());
        assertEquals(7.5, carrot.getTotalValue());
    }

    @Test
    void testToCSV() {
        assertEquals("Apple,A001,1.5,10", apple.toCSV());
        assertEquals("Banana,B001,0.75,20", banana.toCSV());
    }

    @Test
    void testToJSON() {
        String expected = "{\"name\":\"Apple\", \"code\":\"A001\", \"price\":1.50, \"quantity\":10}";
        assertEquals(expected, apple.toJSON());
    }

    @Test
    void testToXML() {
        String expected = "<Product><Name>Apple</Name><Code>A001</Code><Price>1.50</Price><Quantity>10</Quantity></Product>";
        assertEquals(expected, apple.toXML());
    }
}
