package Model.Cards;

/**
 * NumberCard class represents a number card in the game.
 * @author Nikolas Lazaridis
 * @version 1.0
 */
public class NumberCard implements Card {
    private int value;

    /**
     * Constructor.
     * <b>Post-condition:</b> Creates a new NumberCard with the specified 'value'.
     * @param value The value of the card.
     */
    public NumberCard(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return this.value;  // Correctly returning the value of the card
    }

    @Override
    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "NumberCard: " + value;
    }

    /**
     * @param name
     */
    @Override
    public void setName(String name) {

    }


    @Override
    public void movePawn() {

    }
}
