import Mathf.Vector2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameObjectTest {

    @Test
    void testDefaultConstructor() {
        GameObject gameObject = new GameObject();

        // Vérifie que la position est initialisée à (0.0, 0.0)
        assertEquals(0.0, gameObject.position.x);
        assertEquals(0.0, gameObject.position.y);

        // Vérifie que la rotation est initialisée à 0.0
        assertEquals(0.0, gameObject.rotation);
    }

    @Test
    void testCustomConstructor() {
        Vector2 customPosition = new Vector2(1.0, 2.0);
        double customRotation = 45.0;

        GameObject gameObject = new GameObject(customPosition, customRotation);

        // Vérifie que la position est correcte
        assertEquals(customPosition, gameObject.position);

        // Vérifie que la rotation est correcte
        assertEquals(customRotation, gameObject.rotation);
    }

    @Test
    void testSetPosition() {
        GameObject gameObject = new GameObject();

        // Définir une nouvelle position
        Vector2 newPosition = new Vector2(3.0, 4.0);
        gameObject.setPosition(newPosition);

        // Vérifie que la position a été mise à jour correctement
        assertEquals(newPosition, gameObject.position);
    }

    @Test
    void testSetRotation() {
        GameObject gameObject = new GameObject();

        // Définir une nouvelle rotation
        double newRotation = 90.0;
        gameObject.setRotation(newRotation);

        // Vérifie que la rotation a été mise à jour correctement
        assertEquals(newRotation, gameObject.rotation);
    }
}
