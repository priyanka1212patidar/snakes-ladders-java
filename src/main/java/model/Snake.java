package model;

public record Snake(int head, int tail) {
    public Snake {
        if (head <= tail) {
            throw new IllegalArgumentException("Snake head must be above tail");
        }
        if (head >= 100 || tail <= 0) {
            throw new IllegalArgumentException("Invalid snake positions");
        }
    }
}
