import model.Board;
import game.Game;
import game.RandomDice;
import ui.ConsoleUI;

public class Main {
    public static void main(String[] args) {
        Board board = Board.builder()
                .ladder(3, 22)
                .ladder(7, 33)
                .ladder(37, 85)
                .ladder(51, 72)
                .snake(36, 19)
                .snake(65, 35)
                .snake(87, 32)
                .snake(97, 78)
                .build();

        Game game = new Game(board);
        ConsoleUI ui = new ConsoleUI(game, new RandomDice());
        ui.run();
    }
}
