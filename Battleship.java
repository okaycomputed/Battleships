public class Battleship extends Ship {
    public static final int BATTLESHIP_LENGTH = 4;

    public Battleship(int shipStartXCoord, int shipStartYCoord, int shipEndXCoord, int shipEndYCoord) {
        super(shipStartXCoord, shipStartYCoord, shipEndXCoord, shipEndYCoord);
    }

    public char[][] Attack(int xCor, int yCor) {
        char[][] attack = new char[3][2];
        return attack;
    }
}
