Overview

This is a console-based Snakes and Ladders game implemented in Java.

The project follows object-oriented principles and is structured with separate packages for models, game logic, and UI.

Key Highlights:

1. Board setup with snakes and ladders using a Builder pattern.

2. Dice interface supporting both random rolls and manual input.

3. Game engine handles player moves, snakes, ladders, overshoot prevention, and win conditions.

4. Console-based UI for interactive gameplay (r to roll, q to quit, or input 1–6 manually).

5. Unit tests validate core game mechanics.

6. Win condition achieved upon reaching square 100.

How to Run

Clone the repository:

git clone https://github.com/priyanka1212patidar/snakes-ladders-java.git

cd snakes-ladders-java

Build & Run:

mvn clean install

mvn exec:java -Dexec.mainClass="Main"

Game Instructions

1. Type r → Roll a dice

2. Type 1–6 → Enter your own dice roll

3. Type q → Quit the game

 Example Gameplay:

1. Snakes & Ladders started. Type 'r' to roll, 'q' to quit.

2. Your move: r

3. 00, 4 -> 04 (Move to 4)

4. Your move: r

5. 04, 3 -> 07 (Ladder! climb to 33)

Running Tests

mvn test

Tech Stack

Java 17

Maven

JUnit 5

OOP Principles (Builder, Encapsulation, Records)

Author

Priyanka Patidar
