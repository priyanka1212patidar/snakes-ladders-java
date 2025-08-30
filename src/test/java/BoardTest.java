import model.Board;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    @Test
    void testSnakeMovement() {
        Board board = Board.builder().snake(14, 7).build();
        assertEquals(7, board.apply(14));
    }

    @Test
    void testLadderMovement() {
        Board board = Board.builder().ladder(5, 20).build();
        assertEquals(20, board.apply(5));
    }

    @Test
    void testNormalSquare() {
        Board board = Board.builder().snake(14, 7).build();
        assertEquals(10, board.apply(10));
    }

    @Test
    void testSnakeAndLadderOverlapThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> Board.builder().snake(10, 5).ladder(10, 25).build());
    }
}
