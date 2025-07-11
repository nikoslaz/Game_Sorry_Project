package Model.Board;

import Model.Player.Pawn;

/**
 * Square models each square of the game with a specific position on the board,
 * a specific color, and information about whether it is occupied by a pawn.
 * The board is composed of 4 home squares, 4 safety zone squares, 4 internal slide squares, and 4 simple squares.
 *
 * <p>This interface provides methods for accessing and modifying
 * the attributes of a square, including its position, color, and occupancy status.</p>
 *
 * <p>The methods in this interface follow the conventions:
 * <ul>
 *   <li><b>Accessor:</b> Methods that retrieve information without modifying the state.</li>
 *   <li><b>Transformer:</b> Methods that modify the state of the object.</li>
 * </ul>
 * </p>
 *
 * <p>For each method, pre-conditions (if any) describe the assumptions
 * that must be true before the method is called, and post-conditions
 * describe the state of the object after the method is executed.</p>
 *
 * @author Nikolas Lazaridis
 * @version 1.0
 */
public interface Square {

    /**
     * <b>Accessor:</b> Gets the position of the square.
     *
     * <p><b>Pre-condition:</b> None.</p>
     * <p><b>Post-condition:</b> The position of the square has been returned.</p>
     *
     * @return the position of the square.
     */
    int getPosition();

    /**
     * <b>Transformer:</b> Sets the position of the square.
     *
     * <p><b>Pre-condition:</b> The specified position is valid for the square.</p>
     * <p><b>Post-condition:</b> The position of the square has been set to the specified position.</p>
     *
     * @param position the position of the square.
     */
    void setPosition(int position);

    /**
     * <b>Accessor:</b> Gets the color of the square.
     *
     * <p><b>Pre-condition:</b> None.</p>
     * <p><b>Post-condition:</b> The color of the square has been returned.</p>
     *
     * @return the color of the square.
     */
    String getColor();

    /**
     * <b>Transformer:</b> Sets the color of the square.
     *
     * <p><b>Pre-condition:</b> The specified color is valid for the square.</p>
     * <p><b>Post-condition:</b> The color of the square has been set to the specified color.</p>
     *
     * @param color the color of the square.
     */
    void setColor(String color);

    /**
     * <b>Accessor:</b> Checks whether the square is occupied by a pawn.
     *
     * <p><b>Pre-condition:</b> None.</p>
     * <p><b>Post-condition:</b> Whether the square is occupied by a pawn has been returned.</p>
     *
     * @return true if the square is occupied by a pawn, false otherwise.
     */
    boolean isOccupied();

    /**
     * <b>Transformer:</b> Sets whether the square is occupied by a pawn.
     *
     * <p><b>Pre-condition:</b> None.</p>
     * <p><b>Post-condition:</b> Whether the square is occupied by a pawn has been set to the specified value.</p>
     *
     * @param occupied true if the square is occupied by a pawn, false otherwise.
     */
    void setOccupied(boolean occupied);

}
