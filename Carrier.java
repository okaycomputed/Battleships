public class Carrier extends Ship {
    public static final int CARRIER_LENGTH = 5;

    public Carrier(int shipStartXCoord, int shipStartYCoord, int shipEndXCoord, int shipEndYCoord) {
        super(shipStartXCoord, shipStartYCoord, shipEndXCoord, shipEndYCoord);
    }

    public char[][] Attack(int xCor, int yCor) {
        char[][] attack = new char[9][2];
        return attack;
    }
}
