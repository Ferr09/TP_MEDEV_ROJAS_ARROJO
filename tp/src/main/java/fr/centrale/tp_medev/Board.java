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

    /**
     * Initializes the board with the default starting position of pieces.
     */
    private void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = EMPTY;
            }
        }
        board[3][3] = WHITE;
        board[3][4] = BLACK;
        board[4][3] = BLACK;
        board[4][4] = WHITE;
    }

    /**
     * Displays the board with columns labeled from 'a' to 'h' and rows labeled
     * from 1 to 8
     */
    public void display() {
        System.out.print("  ");
        for (int i = 0; i < size; i++) {
            System.out.print((char) ('a' + i) + " ");
        }
        System.out.println();

        for (int i = 0; i < size; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

}
