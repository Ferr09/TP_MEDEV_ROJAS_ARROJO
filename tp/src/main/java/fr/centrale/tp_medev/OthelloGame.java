package fr.centrale.tp_medev;

import java.util.Scanner;

/**
 * Main class for the Othello game. This class manages the game, player, turns,
 * and the board.
 *
 * @author Augusto ARROJO et Fernando Rojas
 */
public class OthelloGame {

    private static final int SIZE = 8;
    private final Board board;
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;

    /**
     * Initializes the game with a board and the two players.
     */
    public OthelloGame() {
        board = new Board(SIZE);
        player1 = new Player("Player 1", Board.BLACK);
        player2 = new Player("Player 2", Board.WHITE);
        currentPlayer = player1;
    }

    /**
     * Starts and manages the game loop.
     */
    public void playGame() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            board.display();
            if (!board.hasValidMove(currentPlayer.getSymbol())) {
                System.out.println("No valid moves for " + currentPlayer.getName() + ". Skipping turn.");
                switchPlayer();
                if (!board.hasValidMove(currentPlayer.getSymbol())) {
                    System.out.println("No valid moves for both players. Game over.");
                    break;
                }
                continue;
            }

            System.out.println("Current player: " + currentPlayer.getName() + " (" + currentPlayer.getSymbol() + ")");
            System.out.print("Enter your move (column and row): ");

            char colChar = scanner.next().charAt(0);
            int col = convertToIndex(colChar);
            int row = scanner.nextInt() - 1;

            if (board.isValidMove(row, col, currentPlayer.getSymbol())) {
                board.makeMove(row, col, currentPlayer.getSymbol());
                switchPlayer();
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        scanner.close();
        board.display();
        System.out.println("Game over. Final score:");
        board.printScore();
    }
}
