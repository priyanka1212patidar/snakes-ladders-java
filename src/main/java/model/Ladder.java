package model;

public record Ladder(int bottom, int top) {
    public Ladder {
        if (bottom >= top) {
            throw new IllegalArgumentException("Ladder bottom must be below top");
        }
        if (bottom <= 0 || top >= 100) {
            throw new IllegalArgumentException("Invalid ladder positions");
        }
    }
}
