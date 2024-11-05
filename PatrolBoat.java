public class PatrolBoat extends Ship {
    public PatrolBoat(int shipStartXCoord, int shipStartYCoord, int shipEndXCoord, int shipEndYCoord) {

        super(shipStartXCoord, shipStartYCoord, shipEndXCoord, shipEndYCoord);
    }

    public char[][] Attack(int xCor, int yCor) {
        char[][] attack = new char[1][2];
        attack[0][0] = (char) xCor;
        attack[0][1] = (char) yCor;
        return attack;
    }

}
