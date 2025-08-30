import game.Game;
import game.MoveResult;
import model.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game;

    @BeforeEach
    void setup() {
        Board board = Board.builder()
                .ladder(3, 22)
                .ladder(7, 33)
                .snake(36, 19)
                .snake(65, 35)
                .build();
        game = new Game(board);
    }

    @Test
    void testNormalMove() {
        MoveResult result = game.move(4);
        assertEquals(4, result.to());
        assertEquals("Move to 4", result.message());
    }

    @Test
    void testLadder() {
        MoveResult result = game.move(3);
        assertEquals(22, result.to());
        assertTrue(result.message().contains("Ladder"));
    }

    @Test
    void testSnake() {
        setPosition(game, 30);
        MoveResult result = game.move(6);
        assertEquals(19, result.to());
        assertTrue(result.message().contains("Snake"));
    }

    @Test
    void testOvershoot() {
        setPosition(game, 98);
        MoveResult result = game.move(5);
        assertEquals(98, result.to());
        assertTrue(result.message().contains("Overshoot"));
    }

    @Test
    void testWinAt100() {
        setPosition(game, 99);
        MoveResult result = game.move(1);
        assertEquals(100, result.to());
        assertTrue(game.isWon());
    }

    @Test
    void testInvalidDiceThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> game.move(0));
        assertThrows(IllegalArgumentException.class, () -> game.move(7));
    }

    private void setPosition(Game game, int pos) {
        try {
            var field = Game.class.getDeclaredField("position");
            field.setAccessible(true);
            field.setInt(game, pos);
        } catch (Exception e) {
            fail("Failed to set position via reflection: " + e.getMessage());
        }
    }
}
