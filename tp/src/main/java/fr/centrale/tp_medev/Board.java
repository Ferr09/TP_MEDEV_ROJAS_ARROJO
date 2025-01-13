package fr.centrale.tp_medev;

/**
 * Represents the Othello game board.
 *
 * @author Augusto ARROJO et Fernando Rojas
 */
public class Board {

    /**
     * Character to represent the null space on the board
     */
    public static final char EMPTY = '.';
    /**
     * Character to represent the color black on the board
     */
    public static final char BLACK = 'B';
    /**
     * Character to represent the color white on the board
     */
    public static final char WHITE = 'W';
    private char[][] board;
    private final int size;

    /**
     * Constructs a new board of the specified size.
     *
     * @param size The size of the board (must be 8 for standard Othello).
     */
    public Board(int size) {
        this.size = size;
        board = new char[size][size];
        initializeBoard();
    }

}
