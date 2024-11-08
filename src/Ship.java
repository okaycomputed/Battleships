public abstract class Ship {
    private int numShips;
    private int xStart;
    private int yStart;
    private int xEnd;
    private int yEnd;
    private boolean isShipSunk;
    private int shipStatus;
    public final static int SHIP_ATTACKING = 1;

    // There are two outcomes to a hit, 1 = ship is hit, 2 = the projectile has missed
    // and if the hit results in a sunken ship, isShipSunk = true
    public static final int HIT_SHIP    = -1;
    public static final int HIT_MISSED  = -2;

    public Ship(int xStart, int yStart, int xEnd, int yEnd) {
        this.xStart = xStart;
        this.yStart = yStart;
        this.xEnd = xEnd;
        this.yEnd = yEnd;
        this.isShipSunk = false;
    }

    public Ship(int xCor, int yCor) {
        this.xStart = xCor;
        this.yStart = yCor;
    }

    public int GetShipStartXCoord() {
        return this.xStart;
    }

    public int GetShipStartYCoord() {
        return this.yStart;
    }

    public int GetShipEndXCoord() {
        return this.xEnd;
    }

    public int GetShipEndYCoord() {
        return this.yEnd;
    }

    public boolean IsShipSunk() {
        return this.isShipSunk;
    }

    public int GetShipStatus() {
        return this.shipStatus;
    }

    public void SetShipStatus(int shipStatus) {
        this.shipStatus = shipStatus;
    }

    public abstract char[][] Attack(int xCor, int yCor, int orientation);

}
