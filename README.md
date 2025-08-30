1. Overview

This is a console-based Snakes and Ladders game implemented in Java.

The project follows object-oriented principles and is structured with separate packages for models, game logic, and UI.

2. Key Highlights:

Board setup with snakes and ladders using a Builder pattern.

Dice interface supporting both random rolls and manual input.

Game engine handles player moves, snakes, ladders, overshoot prevention, and win conditions.

Console-based UI for interactive gameplay (r to roll, q to quit, or input 1–6 manually).

Unit tests validate core game mechanics.

Win condition achieved upon reaching square 100.

3. How to Run

Clone the repository:

git clone https://github.com/priyanka1212patidar/snakes-ladders-java.git

cd snakes-ladders-java


4. Build & Run:

mvn clean install

mvn exec:java -Dexec.mainClass="Main"

5. Game Instructions

Type r → Roll a dice

Type 1–6 → Enter your own dice roll

Type q → Quit the game

Example Gameplay:

Snakes & Ladders started. Type 'r' to roll, 'q' to quit.

Your move: r

00, 4 -> 04 (Move to 4)

Your move: r

04, 3 -> 07 (Ladder! climb to 33)

6. Running Tests

mvn test

7. Tech Stack

Java 17

Maven

JUnit 5

OOP Principles (Builder, Encapsulation, Records)

8. Author

Priyanka Patidar
