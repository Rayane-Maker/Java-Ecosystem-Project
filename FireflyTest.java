import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FireflyTest {

    @Test
    void testConstructorWithMassAndSpeed() {
        Firefly firefly = new Firefly(10.0, 20.0);

        // Check if the mass is initialized correctly
        assertEquals(10.0, firefly.getMass());

        // Check if the speed is initialized correctly
        assertEquals(20.0, firefly.getSpeed());

        // Check if nutriscore is initialized correctly
        assertEquals(6, firefly.getNutriscore());
    }

    @Test
    void testConstructorWithMass() {
        Firefly firefly = new Firefly(15.0);

        // Check if the mass is initialized correctly
        assertEquals(15.0, firefly.getMass());

        // Check if the speed is initialized correctly
        assertEquals(10.0, firefly.getSpeed()); // Default speed value

        // Check if nutriscore is initialized correctly
        assertEquals(6, firefly.getNutriscore());
    }

    @Test
    void testDefaultConstructor() {
        Firefly firefly = new Firefly();

        // Check if the mass is initialized correctly
        assertEquals(5.0, firefly.getMass()); // Default mass value

        // Check if the speed is initialized correctly
        assertEquals(10.0, firefly.getSpeed()); // Default speed value

        // Check if nutriscore is initialized correctly
        assertEquals(6, firefly.getNutriscore());
    }

    @Test
    void setMass() {
        Firefly firefly = new Firefly();
        firefly.setMass(15.0);
        assertEquals(15.0, firefly.getMass());
    }

    @Test
    void setSpeed() {
        Firefly firefly = new Firefly();
        firefly.setSpeed(30.0);
        assertEquals(30.0, firefly.getSpeed());
    }

    @Test
    void getMass() {
        Firefly firefly = new Firefly();
        firefly.setMass(12.5);
        assertEquals(12.5, firefly.getMass());
    }

    @Test
    void getSpeed() {
        Firefly firefly = new Firefly();
        firefly.setSpeed(25.0);
        assertEquals(25.0, firefly.getSpeed());
    }

    @Test
    void testToString() {
        Firefly firefly = new Firefly(10.0, 20.0);
        String expected = "I'm a speedy Firefly with 20.00 speed and 10.00 mass";
        String actual = firefly.toString().replace(",", ".");
        assertEquals(expected, actual);
    }

    @Test
    void testToStringWhenDead() {
        Firefly deadFirefly = new Firefly(0.0, 15.0); // Create a Firefly with mass 0 to simulate a dead Firefly
        String expected = "I'm dead. but I used to be a Firefly with a speed of 15.00";
        String actual = deadFirefly.toString().replace(",", ".");
        assertEquals(expected, actual);
    }

    @Test
    void eat() {
        Firefly firefly = new Firefly(3);
        Animal deadAnimal = new Animal();
        deadAnimal.setMass(0.0); // Set mass to 0 to simulate a dead animal
        deadAnimal.setNutriscore(8);

        firefly.eat(deadAnimal);

        // Verify if the Firefly has grown correctly based on the nutriscore of the dead animal
        assertEquals(11.0, firefly.getMass());
    }

    @Test
    void grow() {
        Firefly firefly = new Firefly();
        firefly.setMass(15.0);
        firefly.grow(5);

        // Verify if the Firefly has grown correctly
        assertEquals(20.0, firefly.getMass());
    }
}
