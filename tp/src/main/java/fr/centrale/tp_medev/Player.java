package fr.centrale.tp_medev;

/**
 * This class represents a player in the game.
 *
 * @author Augusto ARROJO et Fernando Rojas
 */
public class Player {

    private final String name;
    private final char symbol;

    /**
     * Constructs a new player.
     *
     * @param name The name of the player.
     * @param symbol The symbol representing the player ('B' or 'W').
     */
    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    /**
     * Gets the player's name.
     *
     * @return The name of the player.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the player's symbol.
     *
     * @return The symbol representing the player.
     */
    public char getSymbol() {
        return symbol;
    }
}
