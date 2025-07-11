package Model.Player;

/**
 * The class Player simulates the player of the game. Each player has a specific color,
 * a name, maintains 2 pawns, and may have variables and methods indicating whether it is their turn to play.
 * The class Pawn simulates a pawn, which has a specific color,
 * is located on a particular square, and is active or has reached its final destination.
 * 2 players (Red Player and Yellow Player) are created at the beginning of the game.
 * @author Nikolas Lazaridis
 * @version 1.0
 */
public class Player {
    private String name;
    private String color;
    private Pawn[] pawns;
    private boolean hasPlayed;
    private int ID;

    /**
     * <b>constructor</b>: Constructs a new instance of Player and via the
     * parent class Player sets with the command super,
     * name=red and color=red.
     * <b>Post-condition:</b> The name and color of the player have been set.
     * @param ID the name of the player.
     * @param name the name of the player.
     * @param color the color of the player.
     */
    public Player(String name, String color, int ID) {
        this.name = name;
        this.color = color;
        this.pawns = new Pawn[2];
        this.pawns[0] = new Pawn(color);
        this.pawns[1] = new Pawn(color);
        this.ID = ID;
        this.hasPlayed = false;
    }

    /**
     * <b>Transformer:</b> initializes the player.
     * <b>Post-condition:</b> The player has been initialized.
     */
    void initializePlayer(){
        this.pawns[0] = new Pawn(color);
        this.pawns[1] = new Pawn(color);
        this.hasPlayed = false;
    }

    /**
     * <b>Accessor:</b> returns the name of the player.
     * <b>Post-condition:</b> The name of the player has been returned.
     * @return the name of the player.
     */
    public int getID() {
        return ID;
    }

    /**
     * <b>Accessor:</b> returns the name of the player.
     * <b>Pre-condition:</b> The name must be a string.
     * <b>Post-condition:</b> The name of the player has been returned.
     * @param ID the name of the player.
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * <b>Accessor:</b> returns the name of the player.
     * <b>Post-condition:</b> The name of the player has been returned.
     * @return the name of the player.
     */
    public String getName() {
        return name;
    }

    /**
     * <b>Transformer:</b> sets the name of the player.
     * <b>Pre-condition:</b> The name must be a string.
     * <b>Post-condition:</b> The name of the player has been set.
     * @param name the name of the player.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <b>Accessor:</b> returns the color of the player.
     * <b>Post-condition:</b> The color of the player has been returned.
     * @return the color of the player.
     */
    public String getColor() {
        return color;
    }

    /**
     * <b>Transformer:</b> sets the color of the player.
     * <b>Pre-condition:</b> The color must be red, yellow, green or blue.
     * <b>Post-condition:</b> The color of the player has been set.
     * @param color the color of the player.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * <b>Accessor:</b> returns the pawns of the player.
     * <b>Post-condition:</b> The pawns of the player have been returned.
     * @return the pawns of the player.
     */
    public Pawn[] getPawns() {
        return pawns;
    }

    /**
     * <b>Transformer:</b> sets the pawns of the player.
     * <b>Pre-condition:</b> The pawns must be 2.
     * <b>Post-condition:</b> The pawns of the player have been set.
     * @param pawns the pawns of the player.
     */
    public void setPawns(Pawn[] pawns) {
        this.pawns = pawns;
    }

    /**
     * <b>Accessor:</b> returns the status of the player.
     * <b>Post-condition:</b> The status of the player has been returned.
     * @return the status of the player.
     */
    public boolean getHasPlayed() {
        return hasPlayed;
    }

    /**
     * <b>Transformer:</b> sets the status of the player.
     * <b>Pre-condition:</b> The status must be true or false.
     * <b>Post-condition:</b> The status of the player has been set.
     * @param hasPlayed the status of the player.
     */
    public void setHasPlayed(boolean hasPlayed) {
        this.hasPlayed = hasPlayed;
    }

    /**
     * <b>Transformer:</b> sets the status of the player.
     * <b>Post-condition:</b> The status of the player has been set.
     */
    public void resetPawns() {
        this.pawns[0].setPosition(0);
        this.pawns[1].setPosition(0);
        this.pawns[0].setActive(false);
        this.pawns[1].setActive(false);
    }

}
