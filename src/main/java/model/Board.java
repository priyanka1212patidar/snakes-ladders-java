package model;

import java.util.*;

public final class Board {
    private final Map<Integer, Integer> snakes = new HashMap<>();
    private final Map<Integer, Integer> ladders = new HashMap<>();

    private Board(List<Snake> snakes, List<Ladder> ladders) {
        for (Snake s : snakes) {
            if (this.snakes.containsKey(s.head())) {
                throw new IllegalArgumentException("Duplicate snake head: " + s.head());
            }
            this.snakes.put(s.head(), s.tail());
        }
        for (Ladder l : ladders) {
            if (this.ladders.containsKey(l.bottom())) {
                throw new IllegalArgumentException("Duplicate ladder bottom: " + l.bottom());
            }
            this.ladders.put(l.bottom(), l.top());
        }

        for (Integer head : this.snakes.keySet()) {
            if (this.ladders.containsKey(head)) {
                throw new IllegalArgumentException("Snake and ladder overlap at " + head);
            }
        }
    }

    public int apply(int pos) {
        if (snakes.containsKey(pos)) return snakes.get(pos);
        if (ladders.containsKey(pos)) return ladders.get(pos);
        return pos;
    }


    public static class Builder {
        private final List<Snake> snakes = new ArrayList<>();
        private final List<Ladder> ladders = new ArrayList<>();

        public Builder snake(int head, int tail) {
            snakes.add(new Snake(head, tail));
            return this;
        }

        public Builder ladder(int bottom, int top) {
            ladders.add(new Ladder(bottom, top));
            return this;
        }

        public Board build() {
            return new Board(snakes, ladders);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
