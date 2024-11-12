public abstract class Ship {
    private int numShips;
    private int xStart;
    private int yStart;
    private int xEnd;
    private int yEnd;
    private int shipOrientation;
    private int size;
    private boolean isShipSunk;
    private int shipStatus;

    public Ship(int xStart, int yStart, int xEnd, int yEnd, int shipOrientation, int size) {
        this.xStart = xStart;
        this.yStart = yStart;
        this.xEnd = xEnd;
        this.yEnd = yEnd;
        this.size = size;
        this.shipOrientation = shipOrientation;
        this.isShipSunk = false;
    }


    public int GetXStart() {
        return this.xStart;
    }

    public int GetYStart() {
        return this.yStart;
    }

    public int GetXEnd() {
        return this.xEnd;
    }

    public int GetYEnd() {
        return this.yEnd;
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

    public int GetShipOrientation() {
        return this.shipOrientation;
    }

    public int GetSize() {
        return this.size;
    }

    public abstract int[][] Attack(int xCor, int yCor);
}
