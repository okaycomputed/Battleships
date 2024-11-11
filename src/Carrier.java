public class Carrier extends Ship {
    public static final int CARRIER_LENGTH = 5;

    public Carrier(int xStart, int yStart, int xEnd, int yEnd, int shipOrientation, int size) {
        super(xStart, yStart, xEnd, yEnd, shipOrientation, size);
    }

    /* @param xCor   - x-coordinate to be attacked
     * @param yCor   - y-coordinate to be attacked
     * @return       - a 2D integer array of all the positions that have been attacked */
    public int[][] Attack(int xCor, int yCor) {
        int[][] attack = new int[9][2];

        int i = 0;
        for (int m = yCor; m > yCor - 3; m--) {
                for (int k = xCor; k < xCor + 3; k++) {
                    if (k < BattleshipSystem.GRID_LENGTH && m >= 0) {
                            int j = 0;
                            attack[i][j] = (char) k;
                            attack[i][j + 1] = (char) m;
                            i++;
                    }
                }
            }
        return attack;
    }
}
