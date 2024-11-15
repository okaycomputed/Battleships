public class Submarine extends Ship {
    public static final int SUBMARINE_LENGTH = 3;

    public Submarine(int xStart, int yStart, int xEnd, int yEnd, int shipOrientation, int size, char shipChar) {
        super(xStart, yStart, xEnd, yEnd, shipOrientation, size, shipChar);
    }

    // Submarine has an upright cross attack pattern (3 blocks horizontal and 3 blocks vertical)
    /* @param xCor   - x-coordinate to be attacked (midpoint)
     * @param yCor   - y-coordinate to be attacked (midpoint)
     * @return       - a 2D integer array of all the positions that have been attacked */
    public int[][] Attack(int xCor, int yCor) {
        // Int array to store the coordinates positions attacked
        // The Submarine can attack 5 coordinates
        int[][] attack = new int[5][2];
        int xPos = 0;
        int yPos = 0;
        // Stores the midpoint coordinates of the attack pattern in 1st row of the int array
        attack[xPos][yPos] = xCor;
        attack[xPos][yPos + 1] = yCor;
        xPos++;

        // Stores the coordinates of the left block of the cross attack pattern in the 2nd row of the int array
        if (xCor > 0) {
            attack[xPos][yPos] = (xCor - 1);
            attack[xPos][yPos + 1] = yCor;
            xPos++;
        }
        // Stores the coordinates of the right block of the cross attack pattern in the 3rd row of the int array
        if (xCor < BattleshipSystem.GRID_LENGTH - 1) {
            attack[xPos][yPos] = (xCor + 1);
            attack[xPos][yPos + 1] = yCor;
            xPos++;
        }
        // Stores the coordinates of the lower block of the cross attack pattern in the 4th row of the int array
        if (yCor < BattleshipSystem.GRID_LENGTH - 1) {
            attack[xPos][yPos] = xCor;
            attack[xPos][yPos + 1] = (yCor + 1);
            xPos++;
        }
        // Stores the coordinates of the upper block of the cross attack pattern in the 5th row of the int array
        if (yCor > 0) {
            attack[xPos][yPos] = xCor;
            attack[xPos][yPos + 1] = (yCor - 1);
            xPos++;
        }
        // In the case that there are rows in the int array left vacant, assign -1 to them
        for (int k = xPos; k < attack.length; k++) {
            attack[k][yPos] = Ship.OUT_OF_BOUNDS;
            attack[k][yPos + 1] = Ship.OUT_OF_BOUNDS;
        }
        return attack;
    }
}
