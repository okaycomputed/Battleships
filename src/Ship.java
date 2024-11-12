public abstract class Ship {
    private int xStart;
    private int yStart;
    private int xEnd;
    private int yEnd;
    private int size;
    private int shipOrientation;
    private char shipChar;
    private boolean isShipSunk;

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

    public int GetShipOrientation() {
        return this.shipOrientation;
    }

    public int GetSize() {
        return this.size;
    }

    public char GetShipChar() {
        return this.shipChar;
    }

    public abstract int[][] Attack(int xCor, int yCor);

}
