package Model.Cards;

/**
 * Move a pawn eleven positions forward or, if desired, exchange the position of one of your pawns with an opponent's pawn.
 * The card 11 cannot be used to:
 * Exchange an opponent's pawn located in their safety zone or in the Start and Home positions.
 * Exchange one of your pawns located in the Start or Home positions.
 * If it is not possible to move a pawn eleven positions forward, you are not obligated to exchange one of your pawns
 * with the opponent's. In this case, the turn simply changes (the player may choose to fold), and the other player takes
 * their turn.
 * @author Nikolas Lazaridis
 * @version 1.0
 */
public class NumberElevenCard extends NumberCard {
    /**
     *<b>constructor</b>:Constructs a new instance of card 11 and via the
     *parent class NumberCard sets with the command super,
     *value=11 and name=11.
     */
    public NumberElevenCard() {
        super(11);
    }
}
