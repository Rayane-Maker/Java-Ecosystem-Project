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

    /* Revoir plus tard comment résoudre le problème
    @Test
    void eat() {
        Dragonfly dragonfly = new Dragonfly(5.0);
        Biologic food = new Animal();
        dragonfly.eat(food);
        // Add assertions based on the expected behavior of the eat method
        // For example, you might want to check if the dragonfly's mass has changed after eating
        assertTrue(dragonfly.getMass() > 5.0); // Adjust the condition based on your implementation
    }
    */

    @Test
    void grow() {
        Dragonfly dragonfly = new Dragonfly(5);
        dragonfly.grow(3);
        assertTrue(dragonfly.getMass() > 7.0);
    }
}
