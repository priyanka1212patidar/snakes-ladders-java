import game.RandomDice;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomDiceTest {

    @Test
    void testDiceRollsInRange() {
        RandomDice dice = new RandomDice();
        for (int i = 0; i < 100; i++) {
            int roll = dice.roll();
            assertTrue(roll >= 1 && roll <= 6,
                    "Roll out of range: " + roll);
        }
    }
}
