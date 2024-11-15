public abstract class Ship {
    private int numShips;
    private int shipStartXCoord;
    private int shipStartYCoord;
    private int shipEndXCoord;
    private int shipEndYCoord;
    private boolean isShipSunk;
    private int shipStatus;
    public final static int SHIP_ATTACKING = 1;

    // There are two outcomes to a hit, 1 = ship is hit, 2 = the projectile has missed
    // and if the hit results in a sunken ship, isShipSunk = true
    public static final int HIT_SHIP    = -1;
    public static final int HIT_MISSED  = -2;

    public Ship(int shipStartXCoord, int shipStartYCoord, int shipEndXCoord, int shipEndYCoord) {
        this.shipStartXCoord = shipStartXCoord;
        this.shipStartYCoord = shipStartYCoord;
        this.shipEndXCoord = shipEndXCoord;
        this.shipEndYCoord = shipEndYCoord;
        this.isShipSunk = false;
    }

    public Ship(int xCor, int yCor) {
        this.shipStartXCoord = xCor;
        this.shipStartYCoord = yCor;
    }

    public int GetShipStartXCoord() {
        return this.shipStartXCoord;
    }

    public int GetShipStartYCoord() {
        return this.shipStartYCoord;
    }

    public int GetShipEndXCoord() {
        return this.shipEndXCoord;
    }

    public int GetShipEndYCoord() {
        return this.shipEndYCoord;
    }

    public boolean GetIsShipSunk() {
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
