public class PatrolBoat extends Ship {
    public static final int PATROLBOAT_LENGTH = 2;

    public PatrolBoat(int xStart, int yStart, int xEnd, int yEnd, int shipOrientation, int size, char shipChar) {
        super(xStart, yStart, xEnd, yEnd, shipOrientation, size, shipChar);
    }

    /* @param xCor   - x-coordinate to be attacked
     * @param yCor   - y-coordinate to be attacked
     * @return       - a 2D integer array of all the positions that have been attacked */
    public int[][] Attack(int xCor, int yCor) {
        int[][] attack = new int[1][2];
        attack[0][0] = xCor;
        attack[0][1] = yCor;
        return attack;
    }

}
