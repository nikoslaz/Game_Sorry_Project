package Model.Board;

/**
 * Board, which models the board of the game, has a two-dimensional array of Square objects as an attribute.
 * It also has some methods for initializing the board, checking the validity of moves, moving pawns, and determining the winner.
 */
public class Board {

    private Square[][] squares;

    /**
     * Constructor of Board class.
     * Post-condition: The board has been initialized with 16 by 16 squares.
     */
    public Board() {
        squares = new Square[16][16];
        initializeBoard();
    }

    /**
     * Initializes the board with 16 by 16 squares.
     * Post-condition: The board has been initialized with 16 by 16 squares.
     */
    public void initializeBoard() {
        // Initialize default squares
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                squares[i][j] = new SimpleSquare(getSquareId(i, j), "White", false);
            }
        }

        // Initialize special squares
        initializeSlides();
        initializeStartSquares();
        initializeSafetyZones();
        initializeHomeSquares();
    }

    private int getSquareId(int row, int col) {
        return row * 16 + col;
    }

    private void initializeSlides() {
        // 1st Red Slide
        squares[0][1] = new StartSlideSquare(getSquareId(0, 1), "Red", false);
        squares[0][2] = new SlideSquare(getSquareId(0, 2), "Red", false);
        squares[0][3] = new SlideSquare(getSquareId(0, 3), "Red", false);
        squares[0][4] = new EndSlideSquare(getSquareId(0, 4), "Red", false);

        // 2nd Red Slide
        squares[0][9] = new StartSlideSquare(getSquareId(0, 9), "Red", false);
        squares[0][10] = new SlideSquare(getSquareId(0, 10), "Red", false);
        squares[0][11] = new SlideSquare(getSquareId(0, 11), "Red", false);
        squares[0][12] = new SlideSquare(getSquareId(0, 12), "Red", false);
        squares[0][13] = new EndSlideSquare(getSquareId(0, 13), "Red", false);

        // 1st Yellow Slide
        squares[15][2] = new EndSlideSquare(getSquareId(15, 2), "Yellow", false);
        squares[15][3] = new SlideSquare(getSquareId(15, 3), "Yellow", false);
        squares[15][4] = new SlideSquare(getSquareId(15, 4), "Yellow", false);
        squares[15][5] = new SlideSquare(getSquareId(15, 5), "Yellow", false);
        squares[15][6] = new StartSlideSquare(getSquareId(15, 6), "Yellow", false);

        // 2nd Yellow Slide
        squares[15][11] = new EndSlideSquare(getSquareId(15, 11), "Yellow", false);
        squares[15][12] = new SlideSquare(getSquareId(15, 12), "Yellow", false);
        squares[15][13] = new SlideSquare(getSquareId(15, 13), "Yellow", false);
        squares[15][14] = new StartSlideSquare(getSquareId(15, 14), "Yellow", false);

        // 1st Green Slide
        squares[3][0] = new EndSlideSquare(getSquareId(3, 0), "Green", false);
        squares[4][0] = new SlideSquare(getSquareId(4, 0), "Green", false);
        squares[5][0] = new SlideSquare(getSquareId(5, 0), "Green", false);
        squares[6][0] = new SlideSquare(getSquareId(6, 0), "Green", false);
        squares[7][0] = new StartSlideSquare(getSquareId(7, 0), "Green", false);

        // 2nd Green Slide
        squares[11][0] = new EndSlideSquare(getSquareId(11, 0), "Green", false);
        squares[12][0] = new SlideSquare(getSquareId(12, 0), "Green", false);
        squares[13][0] = new SlideSquare(getSquareId(13, 0), "Green", false);
        squares[14][0] = new StartSlideSquare(getSquareId(14, 0), "Green", false);

        // 1st Blue Slide
        squares[1][15] = new StartSlideSquare(getSquareId(1, 15), "Blue", false);
        squares[2][15] = new SlideSquare(getSquareId(2, 15), "Blue", false);
        squares[3][15] = new SlideSquare(getSquareId(3, 15), "Blue", false);
        squares[4][15] = new EndSlideSquare(getSquareId(4, 15), "Blue", false);

        // 2nd Blue Slide
        squares[9][15]  = new StartSlideSquare(getSquareId(9, 15), "Blue", false);
        squares[10][15] = new SlideSquare(getSquareId(10, 15), "Blue", false);
        squares[11][15] = new SlideSquare(getSquareId(11, 15), "Blue", false);
        squares[12][15] = new SlideSquare(getSquareId(12, 15), "Blue", false);
        squares[13][15] = new EndSlideSquare(getSquareId(13, 15), "Blue", false);
    }

    private void initializeStartSquares() {
        // Red Start
        squares[1][4] = new StartSquare(getSquareId(1, 4), "Red", false);
        squares[1][5] = new StartSquare(getSquareId(1, 4), "Red", false);

        // Yellow Start
        squares[14][10] = new StartSquare(getSquareId(14, 11), "Yellow", false);
        squares[14][11] = new StartSquare(getSquareId(14, 12), "Yellow", false);
    }

    private void initializeSafetyZones() {
        // Red Safety Zone
        squares[1][2] = new SafetyZoneSquare(getSquareId(1, 2), "Red", false);
        squares[2][2] = new SafetyZoneSquare(getSquareId(1, 3), "Red", false);
        squares[3][2] = new SafetyZoneSquare(getSquareId(2, 2), "Red", false);
        squares[4][2] = new SafetyZoneSquare(getSquareId(2, 3), "Red", false);
        squares[5][2] = new SafetyZoneSquare(getSquareId(3, 2), "Red", false);

        // Yellow Safety Zone
        squares[14][13] = new SafetyZoneSquare(getSquareId(14, 13), "Yellow", false);
        squares[13][13] = new SafetyZoneSquare(getSquareId(13, 13), "Yellow", false);
        squares[12][13] = new SafetyZoneSquare(getSquareId(12, 13), "Yellow", false);
        squares[11][13] = new SafetyZoneSquare(getSquareId(11, 13), "Yellow", false);
        squares[10][13] = new SafetyZoneSquare(getSquareId(10, 13), "Yellow", false);
    }

    private void initializeHomeSquares() {
        // Red Home
        squares[6][2] = new HomeSquare(getSquareId(6, 2), "Red", false);
        // Yellow Home
        squares[9][13] = new HomeSquare(getSquareId(9, 13), "Yellow", false);
    }


    public Square getSquare(int position) {
        int row = position / 16;
        int col = position % 16;
        return squares[row][col];
    }
}
