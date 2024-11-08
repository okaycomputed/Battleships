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

    // in BattleshipMain, pass in the OFFENSIVE Ship object and the ONE COORDINATE (x,y)
    // with the parameters filled in
    // finds out if ONE block is HIT/MISS
    public boolean IsShipHit(Ship attackingShip, char[][] attackedCoords) {
        char[][] oppGrid = GetCurrPlayer().GetOpponentGrid();
        int row = attackedCoords[0][1] - 1;
        int col = attackedCoords[0][0] - 1;
        if (oppGrid[row][col] == Player.SHIP) {
            oppGrid[row][col] = Player.HIT;                 // swap x and y and -1 the coords bc index
            return true;
        }
        else {
            oppGrid[row][col] = Player.MISS;
            return false;
        }
    }

}
