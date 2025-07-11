package Model.Cards;

/**
 * With this card, a pawn can either start from the Start position or
 * move a pawn two positions forward (according to the clockwise direction).
 * When using this card, the player must play again.
 * @author Nikolas Lazaridis
 * @version 1.0
 */
public class NumberTwoCard extends NumberCard {
    /**
     *<b>constructor</b>:Constructs a new instance of card 2 and via the
     *parent class NumberCard sets with the command super,
     *value=2 and name=2.
     */
    public NumberTwoCard() {
        super(2);
    }
}
