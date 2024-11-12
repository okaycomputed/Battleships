public class Battleship extends Ship {
    public static final int BATTLESHIP_LENGTH = 4;

    public Battleship(int xStart, int yStart, int xEnd, int yEnd, int shipOrientation, int size, char shipChar) {
        super(xStart, yStart, xEnd, yEnd, shipOrientation, size, shipChar);
    }

    /* @param xCor           - x-coordinate to be attacked
     * @param yCor           - y-coordinate to be attacked
     * @return               - a 2D integer array of all the positions that have been attacked */
    public int[][] Attack(int xCor, int yCor) {
        int[][] attack = new int[3][2];
            for (int i = 0; i < attack.length; i++) {
                int j = 0;
                attack[i][j] = xCor;
                attack[i][j+1] = yCor;
                if (yCor < BattleshipSystem.GRID_LENGTH) {
                    yCor++;
                }
            }
        return attack;
    }
}
