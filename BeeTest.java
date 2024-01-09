import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BeeTest {

    @Test
    void testConstructorWithMassAndSpeed() {
        Bee bee = new Bee(10.0, 5.0);
        assertEquals(10.0, bee.getMass());
        assertEquals(5.0, bee.getSpeed());
        assertEquals(-6, bee.getNutriscore());
    }

    @Test
    void testConstructorWithMass() {
        Bee bee = new Bee(15.0);
        assertEquals(15.0, bee.getMass());
        assertEquals(0.0, bee.getSpeed());
        assertEquals(-6, bee.getNutriscore());
    }

    @Test
    void testDefaultConstructor() {
        Bee bee = new Bee();
        assertEquals(0.0, bee.getMass());
        assertEquals(0.0, bee.getSpeed());
        assertEquals(-6, bee.getNutriscore());
    }

    @Test
    void setMass() {
        Bee Bee = new Bee();
        Bee.setMass(15.0);
        assertEquals(15.0, Bee.getMass());
    }

    @Test
    void setSpeed() {
        Bee Bee = new Bee();
        Bee.setSpeed(30.0);
        assertEquals(30.0, Bee.getSpeed());
    }

    @Test
    void getMass() {
        Bee Bee = new Bee();
        Bee.setMass(12.5);
        assertEquals(12.5, Bee.getMass());
    }

    @Test
    void getSpeed() {
        Bee Bee = new Bee();
        Bee.setSpeed(25.0);
        assertEquals(25.0, Bee.getSpeed());
    }

    @Test
    void testToString() {
        Bee Bee = new Bee(10.0, 20.0);
        String expected = "I'm a speedy bee with 20.00 speed and 10.00 mass";
        String actual = Bee.toString().replace(",", ".");
        assertEquals(expected, actual);
    }

    @Test
    void testToStringWhenDead() {
        Bee deadBee = new Bee(0.0, 15.0); // Create a Bee with mass 0 to simulate a dead Bee
        String expected = "I'm dead. but I used to be a bee with a speed of 15.00";
        String actual = deadBee.toString().replace(",", ".");
        assertEquals(expected, actual);
    }

    @Test
    void eat() {
        Bee Bee = new Bee(3);
        Animal deadAnimal = new Animal();
        deadAnimal.setMass(0.0); // Set mass to 0 to simulate a dead animal
        deadAnimal.setNutriscore(8);

        Bee.eat(deadAnimal);

        // Verify if the Bee has grown correctly based on the nutriscore of the dead animal
        assertEquals(11.0, Bee.getMass());
    }

    @Test
    void grow() {
        Bee Bee = new Bee();
        Bee.setMass(15.0);
        Bee.grow(5);

        // Verify if the Bee has grown correctly
        assertEquals(20.0, Bee.getMass());
    }
}