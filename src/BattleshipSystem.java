/* The system that keeps track of all the information, such as
 * a player's own grid, the grid they are attacking and which player's turn */
public class BattleshipSystem {
    public static final int GRID_HEIGHT   = 10;
    public static final int GRID_WIDTH    = 10;
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
        if (this.currPlayer.equals(allPlayers[PLAYER1_POS])) {
            SetCurrPlayer(allPlayers[PLAYER2_POS]);
        }
        else if (this.currPlayer.equals(allPlayers[PLAYER2_POS])) {
            SetCurrPlayer(allPlayers[PLAYER1_POS]);
        }
    }

    public boolean IsShipHit() {
        return false;
    }

}
