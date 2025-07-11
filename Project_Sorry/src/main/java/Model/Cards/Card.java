package Model.Cards;

/**
 * The Card interface models a card in the game and
 * defines its attributes as well as useful methods.
 *
 * <p>This interface provides methods for accessing and modifying
 * the attributes of a card, including its value, name, and performing
 * card-related actions such as moving a pawn.</p>
 *
 * <p>The methods in this interface follow the conventions:
 * <ul>
 *   <li><b>Accessor:</b> Methods that retrieve information without modifying the state.</li>
 *   <li><b>Transformer:</b> Methods that modify the state of the object.</li>
 * </ul>
 * </p>
 *
 * <p>For each method, pre-conditions (if any) describe the assumptions
 * that must be true before the method is called, and post-conditions
 * describe the state of the object after the method is executed.</p>
 *
 * @author Nikolas Lazaridis
 * @version 1.0
 */
public interface Card {

    /**
     * <b>Accessor:</b> Returns the card's value.
     *
     * <p><b>Pre-condition:</b> None.</p>
     * <p><b>Post-condition:</b> The value of the card has been returned.</p>
     *
     * @return int value
     */
    int getValue();

    /**
     * <b>Transformer:</b> Sets the card's value.
     *
     * <p><b>Pre-condition:</b> The specified value is a valid value for the card.</p>
     * <p><b>Post-condition:</b> The value of the card has been set to the specified value.</p>
     *
     * @param value the value to set
     */
    void setValue(int value);

    /**
     * <b>Accessor:</b> Returns a string representation of the card.
     *
     * <p><b>Pre-condition:</b> None.</p>
     * <p><b>Post-condition:</b> The string representation of the card has been returned.</p>
     *
     * @return String name
     */
    String toString();

    void setName(String name);

    /**
     * <b>Transformer:</b> Performs a card-related action, such as moving a pawn.
     * This method can be implemented based on the specific card's behavior.
     *
     * <p><b>Pre-condition:</b> The card is in a valid state for the specified action.</p>
     * <p><b>Post-condition:</b> The card-related action has been performed.</p>
     */
    void movePawn();
}
