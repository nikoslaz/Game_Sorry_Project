package Model.Board;

/**
 * The StartSlideSquare class represents the start of a slide in the board.
 * @author Nikolas Lazaridis
 * @version 2.0
 */
public class StartSlideSquare extends SlideSquare{
    /**
     * Constructor of Square class.
     *
     * @param position   the position of the square on the board.
     * @param color      the color of the square.
     * @param isOccupied whether the square is occupied by a pawn.
     */
    public StartSlideSquare(int position, String color, boolean isOccupied) {
        super(position, color, isOccupied);
    }
}
