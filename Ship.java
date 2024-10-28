public class Ship {
    private int numShips;
    private int shipStartXCoord;
    private int shipStartYCoord;
    private int shipEndXCoord;
    private int shipEndYCoord;
    private boolean isShipSunk;
    private boolean isShipHit;

    public Ship(int shipStartXCoord, int shipStartYCoord, int shipEndXCoord, int shipEndYCoord) {
        this.shipStartXCoord = shipStartXCoord;
        this.shipStartYCoord = shipStartYCoord;
        this.shipEndXCoord = shipEndXCoord;
        this.shipEndYCoord = shipEndYCoord;
        this.isShipSunk = false;
        this.isShipHit = false;
    }

    public int getShipStartXCoord() {
        return shipStartXCoord;
    }

    public int getShipStartYCoord() {
        return shipStartYCoord;
    }

    public int getShipEndXCoord() {
        return shipEndXCoord;
    }

    public int getShipEndYCoord() {
        return shipEndYCoord;
    }

    public boolean isShipSunk() {
        return isShipSunk;
    }

    public boolean isShipHit() {
        return isShipHit;
    }
}
