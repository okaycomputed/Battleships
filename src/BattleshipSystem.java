/* The system that keeps track of all the information, such as
 * a player's own grid, the grid they are attacking and which player's turn */
public class BattleshipSystem {
    public static final int GRID_LENGTH   = 10;
    public static final int PLAYER1_POS   = 0;
    public static final int PLAYER2_POS   = 1;

    private Player[] allPlayers;
    private Player currPlayer;

    //======================= CONSTRUCTOR =======================//
    /* Initialize the game's instance variables.
     * @param player1Name   - Player's name is used as a parameter for the player object to be created
     * @param player2Name   - Name for player 2 */
    public BattleshipSystem(String player1Name, String player2Name) {
        allPlayers = new Player[2];
        allPlayers[PLAYER1_POS] = new Player(player1Name);
        allPlayers[PLAYER2_POS] = new Player(player2Name);

        // Player 1 will always start first
        currPlayer = allPlayers[PLAYER1_POS];
    }

    //====================== PRIVATE METHOD =======================//

    private void SetShipStatus (Ship attackingShip, int xCor, int yCor, int orientation) {
        char[][] attackedCoordsArr = attackingShip.Attack(xCor, yCor, orientation);
        char[][] oppGrid = GetCurrPlayer().GetOpponentGrid();

        for (int i = 0; i < attackedCoordsArr.length; i++) {
            int row = attackedCoordsArr[i][1] - 1;
            int col = attackedCoordsArr[i][0] - 1;
            if (oppGrid[row][col] == Player.SHIP) {
                oppGrid[row][col] = Player.HIT;                 // swap x and y and -1 the coords bc index
            }
            else {
                oppGrid[row][col] = Player.MISS;
            }
        }
    }

    //====================== PUBLIC METHOD =======================//
    public Player GetCurrPlayer() {
        return this.currPlayer;
    }

    public void SetCurrPlayer(Player player) {
        this.currPlayer = player;
    }

    public void SwitchPlayer() {
        if (GetCurrPlayer().equals(allPlayers[PLAYER1_POS])) {
            SetCurrPlayer(allPlayers[PLAYER2_POS]);
        }
        else if (GetCurrPlayer().equals(allPlayers[PLAYER2_POS])) {
            SetCurrPlayer(allPlayers[PLAYER1_POS]);
        }
    }

    // in BattleshipMain, pass in the OFFENSIVE Ship object and the ONE COORDINATE that is being attacked (x,y)
    // with the parameters filled in
    // finds out if ONE block is HIT/MISS
    public boolean IsShipHit(int xCor, int yCor) {
        char[][] oppGrid = GetCurrPlayer().GetOpponentGrid();
        Ship oneBlock = new PatrolBoat(xCor, yCor, xCor, yCor); // Using Patrolboat object here to indicate only ONE BLOCK is attacked
        SetShipStatus(oneBlock, xCor, yCor, Player.VERTICAL);  // Passing the variables into helper method SetShipStatus to change the char array

        if (oppGrid[yCor - 1][xCor - 1] == Player.HIT) {
            return true;
        }
        return false;
    }

    public boolean IsShipSunk(Ship attackedShip, int xCor, int yCor) {
        if (attackedShip instanceof PatrolBoat) {
        }
        return false;
    }

}
