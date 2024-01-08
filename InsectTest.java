import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InsectTest {

    @Test
    void setMass() {
        Insect insect = new Insect();
        insect.setMass(8.0);
        assertEquals(8.0, insect.getMass());
    }

    @Test
    void setSpeed() {
        Insect insect = new Insect();
        insect.setSpeed(15.0);
        assertEquals(15.0, insect.getSpeed());
    }

    @Test
    void getMass() {
        Insect insect = new Insect(7.0);
        assertEquals(7.0, insect.getMass());
    }

    @Test
    void getSpeed() {
        Insect insect = new Insect(7.0, 12.0);
        assertEquals(12.0, insect.getSpeed());
    }

    @Test
    void eat() {
        // Untestable because they are not implemented in Insect
    }

    @Test
    void grow() {
        // untestable because they are not implemented in Insect
    }
}
