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
        int row = yCor;

            for (int col = xCor; col < xCor + 3; col++) {
                if (col < BattleshipSystem.GRID_LENGTH && row >= 0) {
                    int j = 0;
                    attack[i][j] = col;
                    attack[i][j + 1] = row;
                }
            }

            row++;
            for (int col = xCor; col < xCor + 3; col++) {
                if (col < BattleshipSystem.GRID_LENGTH && row >= 0) {
                    int j = 0;
                    attack[i][j] = col;
                    attack[i][j + 1] = row;
                }
            }

            row -= 2;
            for (int col = xCor; col < xCor + 3; col++) {
            if (col < BattleshipSystem.GRID_LENGTH && row >= 0) {
                int j = 0;
                attack[i][j] = col;
                attack[i][j + 1] = row;
            }
        }

        return attack;
    }
}
