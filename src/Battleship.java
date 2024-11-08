public class Battleship extends Ship {
    public static final int BATTLESHIP_LENGTH = 4;

    public Battleship(int shipStartXCoord, int shipStartYCoord, int shipEndXCoord, int shipEndYCoord) {
        super(shipStartXCoord, shipStartYCoord, shipEndXCoord, shipEndYCoord);
    }

    public char[][] Attack(int xCor, int yCor, int orientation) {
        char[][] attack = new char[3][2];
            for (int i = 0; i < attack.length; i++) {
                int j = 0;
                attack[i][j] = (char) xCor;
                attack[i][j+1] = (char) yCor;
                if ( orientation == Player.HORIZONTAL && xCor < BattleshipSystem.GRID_WIDTH) {
                    xCor++;
                }
                else if (orientation == Player.VERTICAL && yCor < BattleshipSystem.GRID_HEIGHT) {
                    yCor++;
                }
            }
        return attack;
    }
}
