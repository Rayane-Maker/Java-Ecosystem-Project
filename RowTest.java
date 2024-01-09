import Mathf.Vector2Int;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RowTest {

    @Test
    void constructor() {
        // Test the Row constructor
        Waterlily[] waterlilies = {new Waterlily(2, new Vector2Int(0, 0)), new Waterlily(1, new Vector2Int(0, 1))};
        Row row = new Row(waterlilies);

        // Check if the waterlilies array is correctly initialized
        assertArrayEquals(waterlilies, row.waterlilies);
    }

}
