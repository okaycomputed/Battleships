public abstract class Ship {
    // Instance variables
    private int xStart;
    private int yStart;
    private int xEnd;
    private int yEnd;
    private int size;
    private int shipOrientation;
    private char shipChar;
    private boolean isShipSunk;

    // Global constant variable to indicate an attack that is not shown on the board
    public final static int OUT_OF_BOUNDS = -1;

    //======================= CONSTRUCTOR =======================//
    // DEVELOPED BY: CHLOE
    /* @param xStart            - Starting x-coordinate
     * @param yStart            - Starting y-coordinate
     * @param xEnd              - Ending x-coordinate
     * @param yEnd              - Ending y-coordinate
     * @param shipOrientation   - Orientation of the ship, vertical or horizontal
     * @param size              - Size of the ship, how many blocks it occupies (also referred to as length)
     * @param shipChar          - The character that represents the ship on the character grid */
    public Ship(int xStart, int yStart, int xEnd, int yEnd, int shipOrientation, int size, char shipChar) {
        this.xStart = xStart;
        this.yStart = yStart;
        this.xEnd = xEnd;
        this.yEnd = yEnd;
        this.size = size;
        this.shipChar = shipChar;
        this.shipOrientation = shipOrientation;
        this.isShipSunk = false;
    }

    //====================== PUBLIC METHOD =======================//
    // DEVELOPED BY: CASSIE
    public int GetXStart() {
        return this.xStart;
    }

    // DEVELOPED BY: CASSIE
    public int GetYStart() {
        return this.yStart;
    }

    // DEVELOPED BY: CASSIE
    public int GetXEnd() {
        return this.xEnd;
    }

    // DEVELOPED BY: CASSIE
    public int GetYEnd() {
        return this.yEnd;
    }

    // DEVELOPED BY: CASSIE
    public boolean GetIsShipSunk() {
        return this.isShipSunk;
    }

    // DEVELOPED BY: CASSIE
    public void SetIsShipSunk(boolean isShipSunk) {
        this.isShipSunk = isShipSunk;
    }

    // DEVELOPED BY: CASSIE
    public int GetShipOrientation() {
        return this.shipOrientation;
    }

    // DEVELOPED BY: CASSIE
    public int GetSize() {
        return this.size;
    }

    // DEVELOPED BY: CASSIE
    public char GetShipChar() {
        return this.shipChar;
    }

    // DEVELOPED BY: CASSIE
    public abstract int[][] Attack(int xCor, int yCor);

}
