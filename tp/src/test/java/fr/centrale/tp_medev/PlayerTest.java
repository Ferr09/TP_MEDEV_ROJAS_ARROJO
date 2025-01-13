package fr.centrale.tp_medev;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the Player class.
 */
public class PlayerTest {

    @Test
    public void testPlayerConstructor() {
        // Create a new player
        Player player = new Player("Player 1", 'B');

        // Check if the name is set correctly
        assertEquals("Player 1", player.getName(), "The player's name was not set correctly.");

        // Check if the symbol is set correctly
        assertEquals('B', player.getSymbol(), "The player's symbol was not set correctly.");
    }

    @Test
    public void testGetName() {
        // Create a new player
        Player player = new Player("Player 2", 'W');

        // Check if the player's name is correct
        assertEquals("Player 2", player.getName(), "The player's name does not match the expected value.");
    }
}
