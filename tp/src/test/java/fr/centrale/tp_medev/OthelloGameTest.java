package fr.centrale.tp_medev;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 * Test class for the OthelloGames class. This class contains unit tests to
 * validate the functionality of the OthelloGames class.
 */
public class OthelloGameTest {

    private OthelloGame game;

    /**
     * Setup before each test. Initializes a new OthelloGame instance.
     */
    @BeforeEach
    public void setUp() {
        game = new OthelloGame();
    }

    /**
     * Tests the initialization of the board to ensure it starts with the
     * correct configuration.
     */
    @Test
    public void testBoardInitialization() {
        Board board = new Board(8);
        char[][] expected = {
            {'.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', 'W', 'B', '.', '.', '.'},
            {'.', '.', '.', 'B', 'W', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.'}
        };

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                assertEquals(expected[i][j], board.getBoard()[i][j]);
            }
        }
    }

    /**
     * Tests whether the validation of moves is working correctly for both valid
     * and invalid cases.
     */
    @Test
    public void testValidMove() {
        Board board = new Board(8);
        assertTrue(board.isValidMove(2, 3, Board.BLACK));
        assertFalse(board.isValidMove(0, 0, Board.BLACK));
    }
}
