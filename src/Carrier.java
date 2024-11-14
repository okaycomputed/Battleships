public class Carrier extends Ship {
    public static final int CARRIER_LENGTH = 5;

    public Carrier(int xStart, int yStart, int xEnd, int yEnd, int shipOrientation, int size, char shipChar) {
        super(xStart, yStart, xEnd, yEnd, shipOrientation, size, shipChar);
    }

    /* @param xCor   - x-coordinate to be attacked
     * @param yCor   - y-coordinate to be attacked
     * @return       - a 2D integer array of all the positions that have been attacked */
    public int[][] Attack(int xCor, int yCor) {
        int[][] attack = new int[9][2];

        int i = 0;
        int j = 0;

        // Coordinates of the middle part of the attack pattern
        // Middle block
        attack[i][j] = xCor;
        attack[i][j + 1] = yCor;
        i++;
        // Left block
        if (xCor > 0) {
            attack[i][j] = xCor - 1;
            attack[i][j + 1] = yCor;
            i++;
        }
        // Right block
        if (xCor < BattleshipSystem.GRID_LENGTH - 1) {
            attack[i][j] = xCor + 1;
            attack[i][j + 1] = yCor;
            i++;
        }

        // Coordinates of the upper part of the attack pattern
        yCor--;
        // Middle block
        if (yCor > 0 ) {
            attack[i][j] = xCor;
            attack[i][j + 1] = yCor;
            i++;
            // Left block
            if (xCor > 0) {
                attack[i][j] = xCor - 1;
                attack[i][j + 1] = yCor;
                i++;
            }
            // Right block
            if (xCor < BattleshipSystem.GRID_LENGTH - 1) {
                attack[i][j] = xCor + 1;
                attack[i][j + 1] = yCor;
                i++;
            }
        }


        // Coordinates of the lower part of the attack pattern
        yCor += 2;
        // Middle block
        if (yCor < BattleshipSystem.GRID_LENGTH) {
            attack[i][j] = xCor;
            attack[i][j + 1] = yCor;
            i++;
            // Left block
            if (xCor > 0) {
                attack[i][j] = xCor - 1;
                attack[i][j + 1] = yCor;
                i++;
            }
            // Right block
            if (xCor < BattleshipSystem.GRID_LENGTH - 1) {
                attack[i][j] = xCor + 1;
                attack[i][j + 1] = yCor;
                i++;
            }
        }
            for (int k = i; k < attack.length; k++) {
                attack[k][j] = -1;
                attack[k][j + 1] = -1;
            }
        return attack;
    }
}
