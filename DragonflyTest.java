import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DragonflyTest {
    @Test
    void testDefaultConstructor() {
        Dragonfly dragonfly = new Dragonfly();
        assertEquals(5.0, dragonfly.getMass());
        assertEquals(10.0, dragonfly.getSpeed());
    }

    @Test
    void testConstructorWithMass() {
        Dragonfly dragonfly = new Dragonfly(8.0);
        assertEquals(8.0, dragonfly.getMass());
        assertEquals(10.0, dragonfly.getSpeed());
    }

    @Test
    void testConstructorWithMassAndSpeed() {
        Dragonfly dragonfly = new Dragonfly(8.0, 15.0);
        assertEquals(8.0, dragonfly.getMass());
        assertEquals(15.0, dragonfly.getSpeed());
    }

    @Test
    void setMass() {
        Dragonfly dragonfly = new Dragonfly();
        dragonfly.setMass(8.0);
        assertEquals(8.0, dragonfly.getMass());
    }

    @Test
    void setSpeed() {
        Dragonfly dragonfly = new Dragonfly();
        dragonfly.setSpeed(15.0);
        assertEquals(15.0, dragonfly.getSpeed());
    }

    @Test
    void getMass() {
        Dragonfly dragonfly = new Dragonfly(7.0);
        assertEquals(7.0, dragonfly.getMass());
    }

    @Test
    void getSpeed() {
        Dragonfly dragonfly = new Dragonfly(7.0, 12.0);
        assertEquals(12.0, dragonfly.getSpeed());
    }

    @Test
    void testToStringWhenAlive() {
        Dragonfly dragonfly = new Dragonfly(10.0, 20.0);
        String expected = "I'm a speedy Dragonfly with 20.00 speed and 10.00 mass";
        String actual = dragonfly.toString().replace(",", ".");
        assertEquals(expected, actual);
    }
    // modification du message avec un '.' à la place de "," car sinon erreur de merde avec replace
    @Test
    void testToStringWhenDead() {
        Dragonfly deadDragonfly = new Dragonfly(0.0);
        String expected = "I'm dead. but I used to be a Dragonfly with a speed of 10.00";
        String actual = deadDragonfly.toString().replace(",", ".");
        assertEquals(expected, actual);
    }

    @Test
    void testEat() {
        // Create a Dragonfly
        Dragonfly dragonfly = new Dragonfly(10.0, 25.0);

        // Create a dead animal with nutriscore 8
        Animal deadAnimal = new Animal();
        deadAnimal.setMass(0.0); // Set mass to 0 to simulate a dead animal
        deadAnimal.setNutriscore(8);

        // Call the eat method on Dragonfly
        dragonfly.eat(deadAnimal);

        // Verify if the Dragonfly has grown correctly based on the nutriscore of the dead animal
        assertEquals(18.0, dragonfly.getMass()); // Dragonfly's mass should increase by the nutriscore
    }

    @Test
    void grow() {
        Dragonfly dragonfly = new Dragonfly(5);
        dragonfly.grow(3);
        assertTrue(dragonfly.getMass() > 7.0);
    }
}
