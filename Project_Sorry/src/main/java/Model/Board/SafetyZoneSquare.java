package Model.Board;

/**
 * The safety zone leads to the 'Home' of a player and can only be
 * used by the player to whom the home belongs. Additionally,
 * the safety zone protects the player's pawn from attacks by the opponent
 * through certain cards, as we will see below.
 * @author Nikolas Lazaridis
 * @version 1.0
 */
public class SafetyZoneSquare implements Square{
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
    public SafetyZoneSquare(int position, String color, boolean isOccupied) {
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
