package Model.Board;

/**
 * The EndSlideSquare class represents the end of a slide in the board.
 * @author Nikolas Lazaridis
 * @version 1.0
 */

public class EndSlideSquare extends SlideSquare{
    /**
     * Constructor of Square class.
     *
     * @param position   the position of the square on the board.
     * @param color      the color of the square.
     * @param isOccupied whether the square is occupied by a pawn.
     */
    public EndSlideSquare(int position, String color, boolean isOccupied) {

        super(position, color, isOccupied);
    }
}
