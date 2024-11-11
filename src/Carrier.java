public class Carrier extends Ship {
    public static final int CARRIER_LENGTH = 5;

    public Carrier(int xStart, int yStart, int xEnd, int yEnd) {
        super(xStart, yStart, xEnd, yEnd);
    }

    public char[][] Attack(int xCor, int yCor, int orientation) {
        char[][] attack = new char[9][2];

        int i = 0;
        for (int m = yCor; m > yCor - 3; m--) {
                for (int k = xCor; k < xCor + 3; k++) {
                    if (k < BattleshipSystem.GRID_LENGTH && m > 0) {
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
