import Mathf.Vector2;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    @Test
    void setMass() {
        // Create an instance of Animal
        Animal animal = new Animal();

        // Test setting mass with a positive value
        animal.setMass(50);
        assertEquals(50, animal.getMass());

        // Test setting mass with a negative value (should keep the previous value)
        animal.setMass(-10);
        assertEquals(50, animal.getMass());

        // Test setting mass with a value equal to zero
        animal.setMass(0);
        assertEquals(0, animal.getMass());
    }

    @Test
    void setSpeed() {
        // Create an instance of Animal
        Animal animal = new Animal();

        // Test setting speed
        animal.setSpeed(10.5);
        assertEquals(10.5, animal.getSpeed());
    }

    @Test
    void getMass() {
        // Create an instance of Animal
        Animal animal = new Animal();

        // Test getting mass
        assertEquals(0.0, animal.getMass());
    }

    @Test
    void getSpeed() {
        // Create an instance of Animal
        Animal animal = new Animal();

        // Test getting speed
        assertEquals(0.0, animal.getSpeed());
    }

    @Test
    void getNutriscore() {
        // Create an instance of Animal
        Animal animal = new Animal();

        // Test getting nutriscore (inherited from Biologic)
        assertEquals(0, animal.getNutriscore());
    }

    @Test
    void move() {
        // Create an instance of Animal
        Animal animal = new Animal();

        // Create a pond with rows and waterlilies
        Row[] pond = new Row[]{
                new Row(new Waterlily[]{new Waterlily(), new Waterlily()}),
                new Row(new Waterlily[]{new Waterlily(), new Waterlily()}),
                new Row(new Waterlily[]{new Waterlily(), new Waterlily()})
        };

        // Set the initial pond grid position of the animal
        animal.pondGridPosition = new Vector2(1, 0);
        animal.currentWaterlily = pond[1].waterlilies[0];

        // Perform the move
        animal.move(2, 1, pond);

        // Assert that the animal is now on the target waterlily
        assertEquals(animal.currentWaterlily, pond[2].waterlilies[1]);

        // Assert that the previous waterlily no longer contains the animal
        assertFalse(Arrays.asList(pond[1].waterlilies[0].getAnimals()).contains(animal));
    }

    @Test
    void eat() {
        // untestable because they are not implemented in Animals
    }

    @Test
    void grow() {
        // untestable because they are not implemented in Animals
    }

    @Test
    void observeForward() {
        // Test the observeForward method (requires additional setup and assertions)
        // don't tested because of permissions
    }

    @Test
    void isDead() {
        // Create an instance of Animal
        Animal animal = new Animal();

        // Test isDead with mass greater than 0
        assertFalse(animal.isDead());

        // Set mass to a non-positive value and test isDead
        animal.setMass(0);
        assertTrue(animal.isDead());
    }

    @Test
    void testToString() {
        // Test the toString method (requires additional setup and assertions)
    }
}
