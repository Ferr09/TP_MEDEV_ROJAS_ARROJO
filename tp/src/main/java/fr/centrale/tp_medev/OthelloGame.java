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
}
