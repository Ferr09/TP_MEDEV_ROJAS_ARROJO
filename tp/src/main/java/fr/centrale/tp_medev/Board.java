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

    /**
     * Checks if a move is valid for the given player.
     *
     * @param row The row of the move.
     * @param col The column of the move.
     * @param player The symbol of the player making the move.
     * @return True if the move is valid, false otherwise.
     */
    public boolean isValidMove(int row, int col, char player) {
        if (row < 0 || row >= size || col < 0 || col >= size || board[row][col] != EMPTY) {
            return false;
        }

        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                if (dr != 0 || dc != 0) {
                    if (canCapture(row, col, dr, dc, player)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Checks if pieces can be captured in a specific direction.
     *
     * @param row The starting row.
     * @param col The starting column.
     * @param dr The row direction (-1, 0, or 1).
     * @param dc The column direction (-1, 0, or 1).
     * @param player The symbol of the player.
     * @return True if pieces can be captured, false otherwise.
     */
    private boolean canCapture(int row, int col, int dr, int dc, char player) {
        int r = row + dr;
        int c = col + dc;
        char opponent = (player == BLACK) ? WHITE : BLACK;
        boolean foundOpponent = false;

        while (r >= 0 && r < size && c >= 0 && c < size) {
            if (board[r][c] == EMPTY) {
                return false;
            }
            if (board[r][c] == player) {
                return foundOpponent;
            }
            if (board[r][c] == opponent) {
                foundOpponent = true;
            }
            r += dr;
            c += dc;
        }
        return false;
    }

}
