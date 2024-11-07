public class Submarine extends Ship {
    public static final int SUBMARINE_LENGTH = 3;

    public Submarine(int shipStartXCoord, int shipStartYCoord, int shipEndXCoord, int shipEndYCoord) {
        super(shipStartXCoord, shipStartYCoord, shipEndXCoord, shipEndYCoord);
    }

    public char[][] Attack(int xCor, int yCor, int orientation) {
        char[][] attack = new char[5][2];
        int j = 0;
        // Midpoint of the attack pattern
        attack[0][j] = (char) xCor;
        attack[0][j + 1] = (char) yCor;

        // Left side of the cross attack pattern
        if (xCor > 0) {
            attack[1][j] = (char) (xCor - 1);
            attack[1][j + 1] = (char) yCor;
        }
        // Right side of the cross attack pattern
        if (xCor < BattleshipSystem.GRID_LENGTH - 1) {
            attack[2][j] = (char) (xCor + 1);
            attack[2][j + 1] = (char) yCor;
        }
        // Upper part of the cross attack pattern
        if (yCor < BattleshipSystem.GRID_LENGTH - 1) {
            attack[3][j] = (char) xCor;
            attack[3][j + 1] = (char) (yCor + 1);
        }
        // Lower part of the cross attack pattern
        if (yCor > 0) {
            attack[4][j] = (char) xCor;
            attack[4][j + 1] = (char) (yCor - 1);
        }
        return attack;
    }
}
