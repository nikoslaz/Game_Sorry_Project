package Model.Board;

/**
 * The InternalSlideSquare class represents the internal part of a slide in the board.
 * @author Nikolas Lazaridis
 * @version 1.0
 *
 */
public class InternalSlideSquare extends SlideSquare{
    /**
     * Constructor of Square class.
     *
     * @param position   the position of the square on the board.
     * @param color      the color of the square.
     * @param isOccupied whether the square is occupied by a pawn.
     */
    public InternalSlideSquare(int position, String color, boolean isOccupied) {
        super(position, color, isOccupied);
    }
}
