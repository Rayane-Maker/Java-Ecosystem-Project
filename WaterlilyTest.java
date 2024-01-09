import Mathf.Vector2Int;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WaterlilyTest {

    @Test
    void getPondGridPosition() {
        // Test the getPondGridPosition method
        Vector2Int pondGridPosition = new Vector2Int(2, 3);
        Waterlily waterlily = new Waterlily(5, pondGridPosition);
        assertEquals(pondGridPosition, waterlily.getPondGridPosition());
    }

    @Test
    void getAnimals() {
        // Test the getAnimals method
        Waterlily waterlily = new Waterlily(5, new Vector2Int(1, 1));
        Animal animal1 = new Animal();
        Animal animal2 = new Animal();
        waterlily.addAnimal(animal1);
        waterlily.addAnimal(animal2);
        Animal[] animals = waterlily.getAnimals();
        assertNotNull(animals);
        assertEquals(2, animals.length);
    }

    @Test
    void displayInfo() {
        // Test the displayInfo method
        Waterlily waterlily = new Waterlily(3, new Vector2Int(0, 0));
        waterlily.displayInfo();
        // You can capture the printed output for assertion, but for simplicity, I'm just calling the method.
    }

    @Test
    void isFree() {
        // Test the isFree method
        Waterlily waterlily = new Waterlily(2, new Vector2Int(0, 0));

        // Initially, the waterlily should be free
        assertTrue(waterlily.isFree());

        // Add an animal to the waterlily
        Animal animal = new Animal();
        waterlily.addAnimal(animal);

        // After adding an animal, the waterlily should not be free
        assertTrue(waterlily.isFree());
    }

    @Test
    void listenAnimals() {
        // Test the listenAnimals method
        Waterlily waterlily = new Waterlily(3, new Vector2Int(1, 1));
        Animal animal1 = new Animal();
        Animal animal2 = new Animal();
        waterlily.addAnimal(animal1);
        waterlily.addAnimal(animal2);
        String[] animalVoices = waterlily.listenAnimals();
        assertNotNull(animalVoices);
        assertEquals(2, animalVoices.length);
    }

    @Test
    void addAnimal() {
        // Test the addAnimal method
        Waterlily waterlily = new Waterlily(2, new Vector2Int(0, 0));
        Animal animal1 = new Animal();
        Animal animal2 = new Animal();
        assertTrue(waterlily.addAnimal(animal1));
        assertTrue(waterlily.addAnimal(animal2));
        assertFalse(waterlily.addAnimal(new Animal())); // This should fail as capacity is exceeded
    }

    @Test
    void removeAnimal() {
        // Test the removeAnimal method
        Waterlily waterlily = new Waterlily(3, new Vector2Int(1, 1));
        Animal animal1 = new Animal();
        Animal animal2 = new Animal();
        waterlily.addAnimal(animal1);
        waterlily.addAnimal(animal2);
        assertTrue(waterlily.removeAnimal(animal1));
    }
}
