public class Player {
    private String playerName;
    private int numShipsAlive;
    private int numShipsSunk;
    private Ship[][] selfGrid;
    private Ship[][] opponentGrid;
    private Ship[] playerShips;

    // Final variables to determine the orientation of the ship
    public static final int VERTICAL         = 0;
    public static final int HORIZONTAL       = 1;

    public static final int TOTAL_NUM_SHIPS  = 5;

    //======================= CONSTRUCTOR =======================//
    public Player(String playerName) {
        this.playerName = playerName;
        selfGrid = new Ship[BattleshipSystem.GRID_HEIGHT][BattleshipSystem.GRID_WIDTH];
        opponentGrid = new Ship[BattleshipSystem.GRID_HEIGHT][BattleshipSystem.GRID_WIDTH];
        numShipsAlive = TOTAL_NUM_SHIPS;
        numShipsSunk = 0;

        // Setting both grids to null
        for(int row = 0; row < BattleshipSystem.GRID_HEIGHT; row++) {
            for(int col = 0; col < BattleshipSystem.GRID_WIDTH; col++) {
                selfGrid[row][col] = null;
                opponentGrid[row][col] = null;
            }
        }

        // Instantiating ships inside the ship array for each player
        playerShips = new Ship[TOTAL_NUM_SHIPS];
     }

    //====================== PRIVATE METHOD =======================//

    private void randShipPositions(Ship[][] selfGrid) {
        for(int row = 0; row < BattleshipSystem.GRID_HEIGHT; row++) {
            for(int col = 0; col < BattleshipSystem.GRID_WIDTH; col++) {
                int xCor = (int) (Math.random() * BattleshipSystem.GRID_HEIGHT + 1);
                int yCor = (int) (Math.random() * BattleshipSystem.GRID_HEIGHT + 1);

            }
        }
    }

    //====================== PUBLIC METHOD =======================//
    public void InitializeSelfGrid() {

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

    public Ship[][] GetSelfGrid() {
        return this.selfGrid;
    }

    public Ship[][] GetOpponentGrid() {
        return this.opponentGrid;
    }
}
