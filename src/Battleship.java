public class Battleship extends Ship {
    public static final int BATTLESHIP_LENGTH = 4;

    public Battleship(int xStart, int yStart, int xEnd, int yEnd, int shipOrientation, int size) {
        super(xStart, yStart, xEnd, yEnd, shipOrientation, size);
    }

    public char[][] Attack(int xCor, int yCor, int orientation) {
        char[][] attack = new char[3][2];
            for (int i = 0; i < attack.length; i++) {
                int j = 0;
                attack[i][j] = (char) xCor;
                attack[i][j+1] = (char) yCor;
                if ( orientation == Player.HORIZONTAL && xCor < BattleshipSystem.GRID_LENGTH) {
                    xCor++;
                }
                else if (orientation == Player.VERTICAL && yCor < BattleshipSystem.GRID_LENGTH) {
                    yCor++;
                }
            }
        return attack;
    }

}
