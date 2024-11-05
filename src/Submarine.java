public class Submarine extends Ship {
    public static final int SUBMARINE_LENGTH = 3;

    public Submarine(int shipStartXCoord, int shipStartYCoord, int shipEndXCoord, int shipEndYCoord) {
        super(shipStartXCoord, shipStartYCoord, shipEndXCoord, shipEndYCoord);
    }

    public char[][] Attack(int xCor, int yCor, int orientation) {
        char[][] attack = new char[5][2];
        return attack;
    }
}
