public class Player {
    private String playerName;
    private int numShipsAlive;
    private int numShipsSunk;
    private char[][] selfGrid;
    private char[][] opponentGrid;
    private Ship[] playerShips;

    public static final int VERTICAL         = 0;   // Indicates orientation of the ship
    public static final int HORIZONTAL       = 1;   // Indicates orientation of the ship
    public static final int TOTAL_NUM_SHIPS  = 5;

    // Global chars to represent the different grid statuses
    public static final char EMPTY   = '-';
    public static final char SHIP    = 'S';
    public static final char SUNK    = 'X';
    public static final char HIT     = '+';
    public static final char MISS    = '#';

    //======================= CONSTRUCTOR =======================//
    public Player(String playerName) {
        this.playerName = playerName;
        selfGrid = new char[BattleshipSystem.GRID_HEIGHT][BattleshipSystem.GRID_WIDTH];
        opponentGrid = new char[BattleshipSystem.GRID_HEIGHT][BattleshipSystem.GRID_WIDTH];
        numShipsAlive = TOTAL_NUM_SHIPS;
        numShipsSunk = 0;

        // Setting both grids to null
        for(int row = 0; row < BattleshipSystem.GRID_HEIGHT; row++) {
            for(int col = 0; col < BattleshipSystem.GRID_WIDTH; col++) {
                selfGrid[row][col] = EMPTY;
                opponentGrid[row][col] = EMPTY;
            }
        }

        // Instantiating ships inside the ship array for each player
        playerShips = new Ship[TOTAL_NUM_SHIPS];
     }

    //====================== PRIVATE METHOD =======================//

    private void placeCarrier(char[][] selfGrid, int index, int shipOrientation, int length) {
        int xCor, yCor;
        boolean isShipPlaced = false;
        do {
            // Randomize starting coordinates
            xCor = (int) (Math.random() * 9) + 1;
            yCor = (int) (Math.random() * 9) + 1;

            // Checking ship orientation and ensuring that the end value is not out of bounds
            if(shipOrientation == VERTICAL && yCor + length < BattleshipSystem.GRID_HEIGHT) {
                playerShips[index] = new Carrier(xCor, yCor, xCor, yCor + length);
                // Updates the char array
                for(int y = yCor; y < yCor + length; y++) {
                    selfGrid[y][xCor] = SHIP;
                }
                isShipPlaced = true;
            }

            else if(shipOrientation == HORIZONTAL && xCor + length< BattleshipSystem.GRID_WIDTH){
                playerShips[index] = new Carrier(xCor, yCor, xCor + length, yCor);
                for(int x = xCor; x < xCor + length; x++) {
                    selfGrid[yCor][x] = SHIP;
                }
                isShipPlaced = true;
            }
        }
        while(!isShipPlaced);
    }

    //====================== PUBLIC METHOD =======================//
    public void InitializeSelfGrid() {
        placeCarrier(selfGrid, 0, ((int) (Math.random() * 1) + 1), Carrier.CARRIER_LENGTH);
    }

    public String GetPlayerName() {
        return this.playerName;
    }

    public int GetNumShipsAlive() {
        return this.numShipsAlive;
    }

    public int GetNumShipsSunk() {
        return this.numShipsSunk;
    }

    public char[][] GetSelfGrid() {
        return this.selfGrid;
    }

    public char[][] GetOpponentGrid() {
        return this.opponentGrid;
    }
}
