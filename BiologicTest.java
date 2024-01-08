import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BiologicTest {

    @Test
    void setNutriscore() {
        // Create an instance of Biologic
        Biologic biologic = new Biologic();

        // Test with a positive value
        biologic.setNutriscore(50);
        assertEquals(50, biologic.nutriscore);

        // Test with a negative value (should keep the previous value)
        biologic.setNutriscore(-10);
        assertEquals(50, biologic.nutriscore);

        // Test with a value equal to zero
        biologic.setNutriscore(0);
        assertEquals(0, biologic.nutriscore);
    }
}
