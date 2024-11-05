public class PatrolBoat extends Ship {
    public static final int PATROLBOAT_LENGTH = 2;

    public PatrolBoat(int shipStartXCoord, int shipStartYCoord, int shipEndXCoord, int shipEndYCoord) {

        super(shipStartXCoord, shipStartYCoord, shipEndXCoord, shipEndYCoord);
    }

    public char[][] Attack(int xCor, int yCor, int orientation) {
        char[][] attack = new char[1][2];
        attack[0][0] = (char) xCor;
        attack[0][1] = (char) yCor;
        return attack;
    }

}
