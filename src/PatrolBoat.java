public class PatrolBoat extends Ship {
    public static final int PATROLBOAT_LENGTH = 2;

    // DEVELOPED BY: CASSIE
    public PatrolBoat(int xStart, int yStart, int xEnd, int yEnd, int shipOrientation, int size, char shipChar) {
        super(xStart, yStart, xEnd, yEnd, shipOrientation, size, shipChar);
    }

    // DEVELOPED BY: CASSIE
    // PatrolBoat has a 1-block attack pattern
    /* @param xCor   - x-coordinate to be attacked
     * @param yCor   - y-coordinate to be attacked
     * @return       - a 2D integer array of all the positions that have been attacked */
    public int[][] Attack(int xCor, int yCor) {
        // Int array to store the coordinates positions attacked
        // PatrolBoats can attack only 1 coordinate
        int[][] attack = new int[1][2];
        // Stores the coordinate of the 1-block attack pattern in 1st row of the int array
        attack[0][0] = xCor;
        attack[0][1] = yCor;
        return attack;
    }

}
