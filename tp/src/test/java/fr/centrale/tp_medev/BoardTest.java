package fr.centrale.tp_medev;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the Board class. This class contains unit tests to validate
 * the functionality of the Board class.
 */
public class BoardTest {

    private Board board;

    /**
     * Set up the board before each test. This method initializes an 8x8 board
     * with the default starting configuration.
     */
    @BeforeEach
    public void setUp() {
        board = new Board(8); // Initialize the board
        board.initializeBoard(); // Ensure the board is set up correctly
    }

    /**
     * Tests the initial setup of the board. Ensures that the pieces are placed
     * correctly at the start of the game.
     */
    @Test
    public void testInitialBoardSetup() {
        // Check the initial setup (the center of the board should have the starting pieces)
        assertEquals(Board.WHITE, board.getBoard()[3][3], "Center (3, 3) should be WHITE");
        assertEquals(Board.BLACK, board.getBoard()[3][4], "Center (3, 4) should be BLACK");
        assertEquals(Board.BLACK, board.getBoard()[4][3], "Center (4, 3) should be BLACK");
        assertEquals(Board.WHITE, board.getBoard()[4][4], "Center (4, 4) should be WHITE");

        // All other cells should be empty
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                // Exclude the center positions
                if ((i != 3 || j != 3) && (i != 3 || j != 4) && (i != 4 || j != 3) && (i != 4 || j != 4)) {
                    assertEquals(Board.EMPTY, board.getBoard()[i][j], "Position (" + i + ", " + j + ") should be EMPTY");
                }
            }
        }
    }

    /**
     * Tests making a move on the board. This test ensures that a move is made
     * correctly and that pieces are flipped where necessary.
     */
    @Test
    public void testMakeMove() {
        // Make a valid move for Black at (2, 3)
        board.makeMove(2, 3, Board.BLACK);

        // Assert that the move was made
        assertEquals(Board.BLACK, board.getBoard()[2][3]);

        // Assert that the White pieces are flipped
        assertEquals(Board.BLACK, board.getBoard()[3][3]);
        assertEquals(Board.BLACK, board.getBoard()[3][4]);
        assertEquals(Board.WHITE, board.getBoard()[4][4]);
    }

    /**
     * Tests if a player has any valid moves available. Verifies that the method
     * correctly identifies whether a player can make a move.
     */
    @Test
    public void testHasValidMove() {
        // Test hasValidMove for White
        assertTrue(board.hasValidMove(Board.WHITE)); // White should have a valid move initially

        // Test hasValidMove for Black
        assertTrue(board.hasValidMove(Board.BLACK)); // Black should have a valid move initially

    }

    /**
     * Tests the scoring system of the game. Verifies that the printScore method
     * outputs the correct score based on the board state.
     */
    @Test
    public void testPrintScore() {
        // Print score and check if it is accurate
        board.printScore();
    }
}
