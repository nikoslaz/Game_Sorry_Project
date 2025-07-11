package Model.Player;

/**
 * 2 pawns of the same color for each player
 * A pawn is located on a particular square
 * A pawn is active or has reached its final destination
 * A pawn can be moved forward or backward
 * Preconditions: the pawn is not in the Start position
 * Post-conditions: the pawn is in the Start position
 * @author Nikolas Lazaridis
 * @version 1.0
 */
public class Pawn {
    private String color;
    private int position;
    private boolean active;
    private int id;

    /**
     * <b>constructor</b>: Constructs a new instance of Pawn and via the
     * parent class Player sets with the command super,
     * color=red and position=0.
     */
    public Pawn(String color) {
        this.color = color;
        this.position = 0;
        this.active = false;
    }

    /**
     * <b>Accessor:</b> returns the color of the pawn.
     * <b>Postcondition:</b> the color of the pawn has been returned.
     *
     * @return the color of the pawn.
     */
    public String getColor() {
        return color;
    }

    /**
     * <b>Transformer:</b> sets the color of the pawn.
     * <b>Postcondition:</b> the color of the pawn has been set.
     *
     * @param color the color of the pawn.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * <b>Accessor:</b> returns the position of the pawn.
     * <b>Postcondition:</b> the position of the pawn has been returned.
     *
     * @return the position of the pawn.
     */
    public int getPosition() {
        return position;
    }

    /**
     * <b>Transformer:</b> sets the position of the pawn.
     * <b>Postcondition:</b> the position of the pawn has been set.
     *
     * @param position the position of the pawn.
     */
    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * <b>Accessor:</b> returns the status of the pawn.
     * <b>Postcondition:</b> the status of the pawn has been returned.
     *
     * @return the status of the pawn.
     */
    public boolean isActive() {
        return active;
    }

    /**
     * <b>Transformer:</b> sets the status of the pawn.
     * <b>Postcondition:</b> the status of the pawn has been set.
     *
     * @param active the status of the pawn.
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * <b>Transformer:</b> moves the pawn forward.
     * <b>Postcondition:</b> the pawn has been moved forward.
     */
    public void moveForward(int position){
        this.position = this.position + position;
    }

    /**
     * <b>Transformer:</b> moves the pawn backward.
     * <b>Postcondition:</b> the pawn has been moved backward.
     */
    public void moveBackward(int position) {
        this.position = this.position - position;
    }

    /**
     * <b>Accessor:</b> returns the id of the pawn.
     * <b>Postcondition:</b> the id of the pawn has been returned.
     *
     * @return the id of the pawn.
     */
    public int getId() {
        return id;
    }

    /**
     * <b>Transformer:</b> sets the id of the pawn.
     * <b>Postcondition:</b> the id of the pawn has been set.
     *
     * @param id the id of the pawn.
     */
    public void setId(int id) {
        this.id = id;
    }
}
