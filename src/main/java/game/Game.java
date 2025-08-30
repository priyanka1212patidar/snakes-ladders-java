package game;

import model.Board;

public class Game {
    private final Board board;
    private int position = 0;

    public Game(Board board) {
        this.board = board;
    }

    public int getPosition() {
        return position;
    }

    public MoveResult move(int roll) {
        if (roll < 1 || roll > 6) {
            throw new IllegalArgumentException("Dice must be between 1 and 6");
        }

        int from = position;
        int next = from + roll;

        if (next > 100) {
            return new MoveResult(from, roll, from, "Overshoot: stay at " + from);
        }

        int landed = board.apply(next);
        position = landed;

        String msg;
        if (landed > next) {
            msg = "Ladder! climb to " + landed;
        } else if (landed < next) {
            msg = "Snake! slide to " + landed;
        } else if (landed == 100) {
            msg = "Yay!! You won!!";
        } else {
            msg = "Move to " + landed;
        }

        return new MoveResult(from, roll, landed, msg);
    }

    public boolean isWon() {
        return position == 100;
    }
}
