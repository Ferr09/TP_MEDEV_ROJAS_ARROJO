package fr.centrale.tp_medev;

/**
 * This class represents a player in the game.
 *
 * @author Augusto ARROJO et Fernando Rojas
 */
public class Player {

    private final String name;

    /**
     * Constructs a new player.
     *
     * @param name The name of the player.
     * @param symbol The symbol representing the player ('B' or 'W').
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * Gets the player's name.
     *
     * @return The name of the player.
     */
    public String getName() {
        return name;
    }
}
