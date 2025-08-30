package ui;

import game.*;


import java.util.Scanner;

public class ConsoleUI {
    private final Game game;
    private final Dice dice;

    public ConsoleUI(Game game, Dice dice) {
        this.game = game;
        this.dice = dice;
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Snakes & Ladders started. Type 'r' to roll dice, 'q' to quit, or enter 1–6 manually.");

        while (!game.isWon()) {
            System.out.print("Your move: ");
            String input = sc.nextLine().trim();

            if (input.equalsIgnoreCase("q")) break;

            int roll;
            if (input.equalsIgnoreCase("r")) {
                roll = dice.roll();
            } else {
                try {
                    roll = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("❌ Invalid input. Please type 'r' or enter a number 1–6.");
                    continue;
                }
            }

            try {
                MoveResult result = game.move(roll);
                System.out.printf("%02d, %d -> %02d (%s)%n",
                        result.from(), result.roll(), result.to(), result.message());
            } catch (IllegalArgumentException e) {
                System.out.println("⚠️ " + e.getMessage());
            }

            if (game.isWon()) {
                System.out.println("🎉 Congratulations! You reached 100!");
                break;
            }
        }
    }
}
