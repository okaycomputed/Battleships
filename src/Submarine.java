public class Submarine extends Ship {
    public static final int SUBMARINE_LENGTH = 3;

    public Submarine(int xStart, int yStart, int xEnd, int yEnd, int shipOrientation, int size) {
        super(xStart, yStart, xEnd, yEnd, shipOrientation, size);
    }

    /* @param xCor   - x-coordinate to be attacked
     * @param yCor   - y-coordinate to be attacked
     * @return       - a 2D integer array of all the positions that have been attacked */
    public int[][] Attack(int xCor, int yCor) {
        int[][] attack = new int[5][2];
        int j = 0;
        // Midpoint coordinates of the attack pattern
        attack[0][j] = xCor;
        attack[0][j + 1] = yCor;

        // Coordinates of the left side of the cross attack pattern
        if (xCor > 0) {
            attack[1][j] = (xCor - 1);
            attack[1][j + 1] = yCor;
        }
        // Coordinates of the right side of the cross attack pattern
        if (xCor < BattleshipSystem.GRID_LENGTH - 1) {
            attack[2][j] = (xCor + 1);
            attack[2][j + 1] = yCor;
        }
        // Coordinates of the upper part of the cross attack pattern
        if (yCor < BattleshipSystem.GRID_LENGTH - 1) {
            attack[3][j] = xCor;
            attack[3][j + 1] = (yCor + 1);
        }
        // Coordinates of the lower part of the cross attack pattern
        if (yCor > 0) {
            attack[4][j] = xCor;
            attack[4][j + 1] = (yCor - 1);
        }
        return attack;
    }
}
