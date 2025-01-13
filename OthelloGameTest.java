/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.centrale.tp_medev;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 *
 * @author fe_a8
 */
public class OthelloGameTest {
    /**
     * Tests the initialization of the board to ensure it starts with the correct configuration.
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
     * Tests whether the validation of moves is working correctly for both valid and invalid cases.
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
     * Tests the initialization of the Othello game to ensure all components are correctly created.
     */
    @Test
    public void testGameInitialization() {
        OthelloGame game = new OthelloGame();
        assertNotNull(game);
        assertNotNull(game.getBoard());
        assertNotNull(game.getPlayer1());
        assertNotNull(game.getPlayer2());
    }
}
