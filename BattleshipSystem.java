public class BattleshipSystem {
    public static final int GRID_HEIGHT   = 10;
    public static final int GRID_WIDTH    = 10;
    public static final int PLAYER1_POS   = 0;
    public static final int PLAYER2_POS   = 1;

    private Player[] allPlayers;
    private Player currPlayer;

    public BattleshipSystem(String player1Name, String player2Name) {
        allPlayers = new Player[2];
        allPlayers[PLAYER1_POS] = new Player(Player.PLAYER_1, player1Name);
        allPlayers[PLAYER2_POS] = new Player(Player.PLAYER_2, player2Name);

        // Player 1 will always start first
        currPlayer = allPlayers[PLAYER1_POS];
    }

    public Player GetCurrPlayer() {
        return this.currPlayer;
    }
}
