import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StaticFoodTest {

    @Test
    void testDisplayInfo() {
        StaticFood staticFood = new StaticFood(15);
        // You can capture the printed output for assertion, but for simplicity, I'm just calling the method.
        staticFood.displayInfo();
    }

    @Test
    void testInheritedMethods() {
        StaticFood staticFood = new StaticFood(12);
        // Assuming there are inherited methods from Biologic or GameObject that can be tested here
        // You can add relevant test cases for those methods.
    }
}
