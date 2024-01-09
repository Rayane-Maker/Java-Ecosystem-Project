import Mathf.Vector2Double;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameObjectTest {

    @Test
    public void testDefaultConstructor() {
        GameObject gameObject = new GameObject();

        assertEquals(0.0, gameObject.position.x, 0.0);
        assertEquals(0.0, gameObject.position.y, 0.0);
        assertEquals(0.0, gameObject.rotation, 0.0);
    }

    @Test
    public void testSetPosition() {
        GameObject gameObject = new GameObject();
        gameObject.position = new Vector2Double(5.0, 3.0);

        assertEquals(5.0, gameObject.position.x, 0.0);
        assertEquals(3.0, gameObject.position.y, 0.0);
    }

    @Test
    public void testSetRotation() {
        GameObject gameObject = new GameObject();
        gameObject.rotation = 180.0;

        assertEquals(180.0, gameObject.rotation, 0.0);
    }
}