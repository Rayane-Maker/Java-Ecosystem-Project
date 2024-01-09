import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlyTest {

    @Test
    void testConstructorWithMassAndSpeed() {
        Fly fly = new Fly(5.0, 15.0);

        // Check if the mass is initialized correctly
        assertEquals(5.0, fly.getMass());

        // Check if the speed is initialized correctly
        assertEquals(15.0, fly.getSpeed());

        // Check if nutriscore is initialized correctly
        assertEquals(2, fly.getNutriscore());
    }

    @Test
    void testConstructorWithMass() {
        Fly fly = new Fly(8.0);

        // Check if the mass is initialized correctly
        assertEquals(8.0, fly.getMass());

        // Check if the speed is initialized correctly
        assertEquals(10.0, fly.getSpeed()); // Default speed value

        // Check if nutriscore is initialized correctly
        assertEquals(2, fly.getNutriscore());
    }

    @Test
    void testDefaultConstructor() {
        Fly fly = new Fly();

        // Check if the mass is initialized correctly
        assertEquals(5.0, fly.getMass()); // Default mass value

        // Check if the speed is initialized correctly
        assertEquals(10.0, fly.getSpeed()); // Default speed value

        // Check if nutriscore is initialized correctly
        assertEquals(2, fly.getNutriscore());
    }

    @Test
    void testToStringWhenDead() {
        Fly deadFly = new Fly(0.0);
        String expected = "I'm dead. but I used to be a fly with a speed of 10.00";
        String actual = deadFly.toString().replace(",", ".");
        assertEquals(expected, actual);
    }

    /*@Test
    void testEatWithDeadAnimal() {
        Fly fly = new Fly(5.0, 15.0);
        Animal deadAnimal = new Animal();
        deadAnimal.setMass(0.0);
        deadAnimal.setNutriscore(4);

        fly.eat(deadAnimal);

        // Check if the fly grew based on the dead animal's nutriscore
        assertEquals(17.0, fly.getSpeed());
        assertEquals(9.0, fly.getMass());
    }*/

    @Test
    void testEatWithStaticFood() {
        Fly fly = new Fly(5.0, 15.0);
        StaticFood staticFood = new StaticFood(2);
        staticFood.setNutriscore(3);

        fly.eat(staticFood);

        // Check if the fly grew based on the static food's nutriscore
        assertEquals(17, fly.getSpeed());
        assertEquals(7.0, fly.getMass());
    }

    @Test
    void testGrow() {
        Fly fly = new Fly(5.0, 15.0);

        // Grow the fly with a positive delta mass
        fly.grow(3);

        // Check if the fly grew based on the positive delta mass
        assertEquals(18.0, fly.getSpeed());
        assertEquals(8.0, fly.getMass());

        // Grow the fly with a negative delta mass
        fly.grow(-2);

        // Check if the fly shrank based on the negative delta mass
        assertEquals(16.0, fly.getSpeed());
        assertEquals(6.0, fly.getMass());
    }
}
