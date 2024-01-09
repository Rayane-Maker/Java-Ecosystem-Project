import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InsectTest {

    @Test
    void testConstructorWithMassAndSpeed() {
        double mass = 8.5;
        double speed = 15.0;
        Insect insect = new Insect(mass, speed);

        // Verify if the mass is initialized correctly
        assertEquals(mass, insect.getMass());

        // Verify if the speed is initialized correctly
        assertEquals(speed, insect.getSpeed());
    }

    @Test
    void testConstructorWithMass() {
        double mass = 3.0;
        Insect insect = new Insect(mass);

        // Verify if the mass is initialized correctly
        assertEquals(mass, insect.getMass());

        // Verify if the default speed is initialized correctly
        assertEquals(10.0, insect.getSpeed());
    }

    @Test
    void testDefaultConstructor() {
        Insect insect = new Insect();

        // Verify if the default mass is initialized correctly
        assertEquals(5.0, insect.getMass());

        // Verify if the default speed is initialized correctly
        assertEquals(10.0, insect.getSpeed());
    }


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