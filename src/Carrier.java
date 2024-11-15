public class Carrier extends Ship {
    public static final int CARRIER_LENGTH = 5;

    public Carrier(int xStart, int yStart, int xEnd, int yEnd, int shipOrientation, int size, char shipChar) {
        super(xStart, yStart, xEnd, yEnd, shipOrientation, size, shipChar);
    }

    // Carrier has a 3x3 block attack pattern
    /* @param xCor   - x-coordinate to be attacked (midpoint)
     * @param yCor   - y-coordinate to be attacked (midpoint)
     * @return       - a 2D integer array of all the positions that have been attacked */
    public int[][] Attack(int xCor, int yCor) {
        // Int array to store the coordinates positions attacked
        // The carrier can attack 9 coordinates
        int[][] attack = new int[9][2];
        int i = 0;
        int j = 0;

        // The MIDDLE ROW of the attack pattern is referenced here
        // Stores the midpoint coordinate of the middle row in 1st row of the int array
        attack[i][j] = xCor;
        attack[i][j + 1] = yCor;
        i++;
        // Stores the coordinates of the left block of the row in the 2nd row of the int array
        if (xCor > 0) {
            attack[i][j] = xCor - 1;
            attack[i][j + 1] = yCor;
            i++;
        }
        // Stores the coordinates of the right block of the row in the 3rd row of the int array
        if (xCor < BattleshipSystem.GRID_LENGTH - 1) {
            attack[i][j] = xCor + 1;
            attack[i][j + 1] = yCor;
            i++;
        }

        // The UPPER ROW of the attack pattern is referenced here
        yCor--;
        // Stores the midpoint coordinate of the row in 1st row of the int array
        if (yCor >= 0 ) {
            attack[i][j] = xCor;
            attack[i][j + 1] = yCor;
            i++;
            // Stores the coordinates of the left block of the row in the 2nd row of the int array
            if (xCor > 0) {
                attack[i][j] = xCor - 1;
                attack[i][j + 1] = yCor;
                i++;
            }
            // Stores the coordinates of the right block of the row in the 3rd row of the int array
            if (xCor < BattleshipSystem.GRID_LENGTH - 1) {
                attack[i][j] = xCor + 1;
                attack[i][j + 1] = yCor;
                i++;
            }
        }

        // The LOWER ROW of the attack pattern is referenced here
        yCor += 2;
        // Stores the midpoint coordinate of the row in 1st row of the int array
        if (yCor < BattleshipSystem.GRID_LENGTH) {
            attack[i][j] = xCor;
            attack[i][j + 1] = yCor;
            i++;
            // Stores the coordinates of the left block of the row in the 2nd row of the int array
            if (xCor > 0) {
                attack[i][j] = xCor - 1;
                attack[i][j + 1] = yCor;
                i++;
            }
            // Stores the coordinates of the right block of the row in the 3rd row of the int array
            if (xCor < BattleshipSystem.GRID_LENGTH - 1) {
                attack[i][j] = xCor + 1;
                attack[i][j + 1] = yCor;
                i++;
            }
        }

        // In the case that there are rows in the int array left vacant, assign -1 to them
        for (int k = i; k < attack.length; k++) {
                attack[k][j] = -1;
                attack[k][j + 1] = -1;
            }
        return attack;
    }
}
