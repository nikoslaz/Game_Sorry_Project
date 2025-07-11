package Model.Cards;

/**
 * Move a pawn seven positions forward or distribute the seven positions forward between two pawns (such as four positions for one pawn and three for the other, five positions for one pawn and two for the other, or six positions for one pawn and one for the other).
 * You cannot move backward with this card, and you also cannot start a pawn from the Start position
 * @author Nikolas Lazaridis
 * @version 1.0
 */
public class NumberSevenCard extends NumberCard {
    /**
     *<b>constructor</b>:Constructs a new instance of card 7 and via the
     *parent class NumberCard sets with the command super,
     *value=7 and name=7.
     */
    public NumberSevenCard() {
        super(7);
    }
}
