public class Battleship extends Ship {
    public Battleship(int shipStartXCoord, int shipStartYCoord, int shipEndXCoord, int shipEndYCoord) {
        super(shipStartXCoord, shipStartYCoord, shipEndXCoord, shipEndYCoord);
    }

    public char[][] Attack(int xCor, int yCor, int orientation) {
        char[][] attack = new char[3][2];
        if (orientation == Player.HORIZONTAL) {
            for (int i = 0; i < attack.length; i++) {
                int j = 0;
                attack[i][j] = (char) xCor;
                attack[i][j+1] = (char) yCor;
                xCor++;
            }
        }
        else if (orientation == Player.VERTICAL) {
        }
        return attack;
    }
}
