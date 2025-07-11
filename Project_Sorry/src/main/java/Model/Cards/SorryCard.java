package Model.Cards;

/**
 * Take one of your pawns located at the Start position (and only the Start position) and
 * move it directly to a position occupied by an opponent's pawn,
 * sending the opponent's pawn back to their Start position.
 * The card cannot be used for an opponent's pawn in a safety zone.
 * If there are no pawns at the Start position of the player playing the card
 * or if the opponent's pawns cannot be moved (e.g., if they are in their safety zone),
 * then the card is simply discarded, and the turn changes.
 * @author Nikolas Lazaridis
 * @version 1.0
 */
public class SorryCard implements Card {
    private String name;
    private int value;

    public SorryCard() {
        this.name = "SorryCard";
        this.value = 0;
    }

    @Override
    public int getValue() {
        return 0;
    }

    @Override
    public void setValue(int value) {

    }

    @Override
    public String toString() {
        return "SorryCard";
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public void movePawn() {

    }

}
