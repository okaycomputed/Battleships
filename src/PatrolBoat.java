public class PatrolBoat extends Ship {
    public static final int PATROLBOAT_LENGTH = 2;

    public PatrolBoat(int xStart, int yStart, int xEnd, int yEnd, int shipOrientation, int size) {
        super(xStart, yStart, xEnd, yEnd, shipOrientation, size);
    }

    public char[][] Attack(int xCor, int yCor, int orientation) {
        char[][] attack = new char[1][2];
        attack[0][0] = (char) xCor;
        attack[0][1] = (char) yCor;
        return attack;
    }

}
