public class Battleship extends Ship {
    public static final int BATTLESHIP_LENGTH = 4;

    public Battleship(int xStart, int yStart, int xEnd, int yEnd) {
        super(xStart, yStart, xEnd, yEnd);
    }

    public char[][] Attack(int xCor, int yCor, int orientation) {
        char[][] attack = new char[3][2];
            for (int i = 0; i < attack.length; i++) {
                int j = 0;
                attack[i][j] = (char) xCor;
                attack[i][j+1] = (char) yCor;
                if ( orientation == Player.HORIZONTAL && xCor < BattleshipSystem.GRID_LENGTH - 1) {
                    xCor++;
                }
                else if (orientation == Player.VERTICAL && yCor < BattleshipSystem.GRID_LENGTH - 1) {
                    yCor++;
                }
            }
        return attack;
    }
}
