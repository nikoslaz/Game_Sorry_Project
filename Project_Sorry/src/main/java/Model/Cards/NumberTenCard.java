package Model.Cards;

/**
 * Move a pawn ten positions forward or one position backward.
 * If none of a player's pawns can move forward ten positions,
 * then one pawn must move backward one position if such a move is possible.
 * Precondition: the player has at least one pawn outside the Start position.
 * Post-condition: the player has at least one pawn outside the Start position.
 * @author Nikolas Lazaridis
 * @version 1.0
 */
public class NumberTenCard extends NumberCard {
    /**
     *<b>constructor</b>:Constructs a new instance of card 10 and via the
     *parent class NumberCard sets with the command super,
     *value=10 and name=10.
     */
    public NumberTenCard() {
        super(10);
    }
}
