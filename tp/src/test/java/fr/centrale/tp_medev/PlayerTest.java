package fr.centrale.tp_medev;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the Player class.
 */
public class PlayerTest {

    /**
     * Tests the constructor of the Player class. This test verifies that the
     * player is correctly initialized with a name and symbol.
     *
     */
    @Test
    public void testPlayerConstructor() {
        // Create a new player
        Player player = new Player("Player 1", 'B');

        // Check if the name is set correctly
        assertEquals("Player 1", player.getName(), "The player's name was not set correctly.");

        // Check if the symbol is set correctly
        assertEquals('B', player.getSymbol(), "The player's symbol was not set correctly.");
    }

    /**
     * Tests the getName method of the Player class. This test verifies that the
     * getName method returns the correct player's name.
     *
     */
    @Test
    public void testGetName() {
        // Create a new player
        Player player = new Player("Player 2", 'W');

        // Check if the player's name is correct
        assertEquals("Player 2", player.getName(), "The player's name does not match the expected value.");
    }

    /**
     * Tests the getSymbol method of the Player class. This test verifies that
     * the getSymbol method returns the correct player's symbol.
     *
     */
    @Test
    public void testGetSymbol() {
        // Create a new player
        Player player = new Player("Player 1", 'B');

        // Check if the player's symbol is correct
        assertEquals('B', player.getSymbol(), "The player's symbol does not match the expected value.");
    }

    /**
     * Tests that an IllegalArgumentException is thrown when an invalid symbol
     * is provided to the Player constructor. This test ensures that the
     * constructor only accepts 'B' or 'W' as valid symbols for a player.
     *
     */
    @Test
    public void testSymbolIsNotInvalid() {
        // Try to create a player with an invalid symbol
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Player("PLayer 1", 'X');
        });

        // Verify that the correct exception is thrown
        assertEquals("The symbol must be 'B' or 'W'.", exception.getMessage());
    }
}
