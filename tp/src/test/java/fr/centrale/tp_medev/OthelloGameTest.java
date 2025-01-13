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

    /**
     * Tests the creation of a player and ensures attributes are correctly set.
     */
    @Test
    public void testPlayerCreation() {
        Player player = new Player("Player 1", Board.BLACK);
        assertEquals("Player 1", player.getName());
        assertEquals(Board.BLACK, player.getSymbol());
    }

    /**
     * Tests the logic for capturing opponent pieces in a specific direction.
     */
    @Test
    public void testCaptureLogic() {
        Board board = new Board(8);
        assertTrue(board.canCapture(2, 3, 1, 0, Board.BLACK));
        assertFalse(board.canCapture(0, 0, 1, 0, Board.BLACK));
    }

    /**
     * Tests the convertToIndex method for valid column input. This test checks
     * the correct conversion of columns 'a' to 'h' to indices 0-7.
     */
    @Test
    public void testConvertToIndexValid() {
        assertEquals(0, game.convertToIndex('a'), "Column 'a' should map to index 0");
        assertEquals(7, game.convertToIndex('h'), "Column 'h' should map to index 7");
        assertEquals(0, game.convertToIndex('A'), "Column 'A' should map to index 0 (case insensitive)");
        assertEquals(7, game.convertToIndex('H'), "Column 'H' should map to index 7 (case insensitive)");
    }
}
