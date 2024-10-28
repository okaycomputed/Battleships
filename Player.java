public class Player {
    public static final int PLAYER_1         = 0;
    public static final int PLAYER_2         = 1;
    public static final int TOTAL_NUM_SHIPS  = 5;

    private String playerName;
    private int numShipsAlive;
    private int numShipsSunk;
    private int playerNum;
    private Ship[][] selfGrid;
    private Ship[][] opponentGrid;
    private Ship[] playerShips;

    public Player(int playerNum, String playerName) {
        this.playerName = playerName;
        this.playerNum = playerNum;
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

    public String GetPlayerName() {
        return this.playerName;
    }

    public int GetNumShipsAlive() {
        return this.numShipsAlive;
    }

    public int GetNumShipsSunk() {
        return this.numShipsSunk;
    }

    public int GetPlayerNum() {
        return this.playerNum;
    }

    public Ship[][] GetSelfGrid() {
        return this.selfGrid;
    }

    public Ship[][] GetOpponentGrid() {
        return this.opponentGrid;
    }
}
