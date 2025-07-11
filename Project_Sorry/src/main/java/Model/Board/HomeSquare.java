package Model.Board;

/**
 * The Home position is the final destination where the player is required to bring their 2 pawns
 * and is located at the end of the safety zone. Once a pawn reaches this position, it cannot be moved again.
 * To reach this position, a pawn must advance with the exact number of squares required, and not more.4
 * @author Nikolas Lazaridis
 * @version 1.0
 */
public class HomeSquare implements Square{
    private int position;
    private String color;
    private boolean isOccupied;
    /**
     * Constructor of Square class.
     *
     * @param position   the position of the square on the board.
     * @param color      the color of the square.
     * @param isOccupied whether the square is occupied by a pawn.
     */
    public HomeSquare(int position, String color, boolean isOccupied) {
        this.position = position;
        this.color = color;
        this.isOccupied = isOccupied;
    }

    /**
     * <b>Accessor:</b> Gets the position of the square.
     *
     * <p><b>Pre-condition:</b> None.</p>
     * <p><b>Post-condition:</b> The position of the square has been returned.</p>
     *
     * @return the position of the square.
     */
    @Override
    public int getPosition() {
        return this.position;
    }

    /**
     * <b>Transformer:</b> Sets the position of the square.
     *
     * <p><b>Pre-condition:</b> The specified position is valid for the square.</p>
     * <p><b>Post-condition:</b> The position of the square has been set to the specified position.</p>
     *
     * @param position the position of the square.
     */
    @Override
    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * <b>Accessor:</b> Gets the color of the square.
     *
     * <p><b>Pre-condition:</b> None.</p>
     * <p><b>Post-condition:</b> The color of the square has been returned.</p>
     *
     * @return the color of the square.
     */
    @Override
    public String getColor() {
        return this.color;
    }

    /**
     * <b>Transformer:</b> Sets the color of the square.
     *
     * <p><b>Pre-condition:</b> The specified color is valid for the square.</p>
     * <p><b>Post-condition:</b> The color of the square has been set to the specified color.</p>
     *
     * @param color the color of the square.
     */
    @Override
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * <b>Accessor:</b> Checks whether the square is occupied by a pawn.
     *
     * <p><b>Pre-condition:</b> None.</p>
     * <p><b>Post-condition:</b> Whether the square is occupied by a pawn has been returned.</p>
     *
     * @return true if the square is occupied by a pawn, false otherwise.
     */
    @Override
    public boolean isOccupied() {
        return this.isOccupied;
    }

    /**
     * <b>Transformer:</b> Sets whether the square is occupied by a pawn.
     *
     * <p><b>Pre-condition:</b> None.</p>
     * <p><b>Post-condition:</b> Whether the square is occupied by a pawn has been set to the specified value.</p>
     *
     * @param occupied true if the square is occupied by a pawn, false otherwise.
     */
    @Override
    public void setOccupied(boolean occupied) {
        this.isOccupied = occupied;
    }
}
