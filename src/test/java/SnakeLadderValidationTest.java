import model.Snake;
import model.Ladder;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SnakeLadderValidationTest {

    @Test
    void testValidSnake() {
        Snake s = new Snake(15, 5);
        assertEquals(15, s.head());
        assertEquals(5, s.tail());
    }

    @Test
    void testInvalidSnakeThrows() {
        assertThrows(IllegalArgumentException.class, () -> new Snake(5, 10));
    }

    @Test
    void testValidLadder() {
        Ladder l = new Ladder(5, 20);
        assertEquals(5, l.bottom());
        assertEquals(20, l.top());
    }

    @Test
    void testInvalidLadderThrows() {
        assertThrows(IllegalArgumentException.class, () -> new Ladder(20, 5));
    }
}
