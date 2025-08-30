package game;

import java.util.Random;

public class RandomDice implements Dice {
    private final Random random = new Random();

    @Override
    public int roll() {
        return 1 + random.nextInt(6);
    }
}
