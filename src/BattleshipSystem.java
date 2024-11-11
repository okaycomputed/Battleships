/* The system that keeps track of all the information, such as
 * a player's own grid, the grid they are attacking and which player's turn */
public class BattleshipSystem {
    public static final int GRID_LENGTH   = 10;
    public static final int PLAYER1_POS   = 0;
    public static final int PLAYER2_POS   = 1;

    public static final int SUCCESSFUL         = -1;
    public static final int INVALID_INPUT      = -2;
    public static final int SHIP_ALREADY_SUNK  = -3;

    private Player[] allPlayers;
    private Player currPlayer;
    private Ship currAttackingShip;

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
    private void SetShipStatus (char[][] opponentShips, Ship attackingShip, int xCor, int yCor) {
        int[][] attackedPosition = attackingShip.Attack(xCor, yCor);
        char[][] opponentDisplay = GetCurrPlayer().GetOpponentGrid();

        for (int i = 0; i < attackedPosition.length; i++) {
            int y = attackedPosition[i][1];
            int x = attackedPosition[i][0];
            if (opponentShips[y][x] == Player.SHIP) {
                opponentDisplay[y][x] = Player.HIT;                 // swap x and y and -1 the cords bc index
            }
            else {
                opponentDisplay[y][x] = Player.MISS;
            }
        }
    }

    //====================== PUBLIC METHOD =======================//
    /* @param attackingShip   - input from the main program to determine the attackingShip object
     * @return                - returns -1 if attacking ship has been set successfully
     *                        - returns -2 if the input is out of bounds
     *                        - returns -3 if the ship object selected has already been sunken */
    public int SetCurrAttackingShip(int attackingShip) {
        if(attackingShip < 1 || attackingShip > 5) {
            return INVALID_INPUT;
        }

        // Input from the main program is different from the index inside the array
        else if(GetCurrPlayer().GetPlayerShips(attackingShip - 1).GetIsShipSunk()) {
            return SHIP_ALREADY_SUNK;
        }

        else {
            // Sets current attacking ship
            // Input from the main program is different from the index inside the array
            this.currAttackingShip = GetCurrPlayer().GetPlayerShips(attackingShip - 1);
            return SUCCESSFUL;
        }
    }

    public Ship GetCurrAttackingShip() {
        return this.currAttackingShip;
    }

    public String GetAttackingShipName(Ship ship) {
        if(ship instanceof PatrolBoat) {
            return "Patrol Boat";
        }

        else if(ship instanceof Submarine) {
            return "Submarine";
        }

        else if(ship instanceof Battleship) {
            return "Battleship";
        }

        else {
            return "Carrier";
        }
    }

    public Player[] GetAllPlayers() {
        return this.allPlayers;
    }

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

    public int IsShipHit(int xCor, int yCor) {
        // Validates the input of the x and y coordinates
        if((xCor > GRID_LENGTH || xCor < 0) || (yCor > GRID_LENGTH || yCor < 0)) {
            return INVALID_INPUT;
        }

        else {
            char[][] opponentShips;
            // Get the opponent's ships (by getting their selfGrid)
            if (GetCurrPlayer().equals(allPlayers[PLAYER1_POS])) {
                opponentShips = allPlayers[PLAYER2_POS].GetSelfGrid();
            }
            else {
                opponentShips = allPlayers[PLAYER1_POS].GetSelfGrid();
            }

            // Calling the specific "attack" method for the ship
            SetShipStatus(opponentShips, GetCurrAttackingShip(), xCor, yCor);
            return SUCCESSFUL;
        }
    }

    public boolean IsShipSunk(Ship attackedShip, int xCor, int yCor) {
        return false;
    }

}
