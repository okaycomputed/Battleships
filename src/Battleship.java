public class Battleship extends Ship {
    public static final int BATTLESHIP_LENGTH = 4;

    public Battleship(int xStart, int yStart, int xEnd, int yEnd, int shipOrientation, int size, char shipChar) {
        super(xStart, yStart, xEnd, yEnd, shipOrientation, size, shipChar);
    }

    // Battleship has a vertical 3-block attack pattern
    /* @param xCor           - x-coordinate to be attacked (midpoint)
     * @param yCor           - y-coordinate to be attacked (midpoint)
     * @return               - a 2D integer array of all the positions that have been attacked */
    public int[][] Attack(int xCor, int yCor) {
        // Int array to store the coordinates positions attacked
        // The Battleship can attack 3 coordinates
        // There are 2 columns to store the x and y value
        int[][] attack = new int[3][2];
        int xPos = 0;
        int yPos = 0;

        // Stores the midpoint coordinates of the 3-block vertical attack pattern in 1st row of the int array
        attack[xPos][yPos] = xCor;
        attack[xPos][yPos + 1] = yCor;
        xPos++;

        // Stores the coordinates of the upper block of the 3-block vertical attack pattern in the 2nd row of the int array
        if (yCor > 0) {
            attack[xPos][yPos] = xCor;
            attack[xPos][yPos + 1] = yCor - 1;
            xPos++;
        }

        // Stores the coordinates of the lower block of the 3-block vertical pattern in the 3rd row of the int array
        if (yCor < BattleshipSystem.GRID_LENGTH) {
            attack[xPos][yPos] = xCor;
            attack[xPos][yPos + 1] = yCor + 1;
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
