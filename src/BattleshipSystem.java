/* The system that keeps track of all the information, such as
 * a player's own grid, the grid they are attacking and which player's turn */
public class BattleshipSystem {
    public static final int GRID_LENGTH   = 10;
    public static final int PLAYER1_POS   = 0;
    public static final int PLAYER2_POS   = 1;

    public static final int SUCCESSFUL         = -1;
    public static final int INVALID_INPUT      = -2;
    public static final int SHIP_ALREADY_SUNK  = -3;
    public static final int NO_SHIPS_HIT       = -4;

    private Player[] allPlayers;
    private Player currPlayer;
    private Player winner;
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
    private Ship getAttackedShip(char shipChar, int x, int y) {
        if(shipChar == Player.CARRIER) {
            return getOpponent().GetPlayerShipsAt(0);
        }
        else if(shipChar == Player.BATTLESHIP) {
            return getOpponent().GetPlayerShipsAt(1);
        }

        else if(shipChar == Player.SUBMARINE) {
            return getOpponent().GetPlayerShipsAt(2);
        }

        else {
            Ship patrolBoat1 = getOpponent().GetPlayerShipsAt(3);
            Ship patrolBoat2 = getOpponent().GetPlayerShipsAt(4);
            if((patrolBoat1.GetXStart() == x || patrolBoat1.GetXEnd() == x)
                    && patrolBoat1.GetYStart() == y || patrolBoat1.GetYEnd() == y) {
                return patrolBoat1;
            }

            else {
                return patrolBoat2;
            }
        }
    }

    private Player getOpponent() {
        // Get the opponent's ships (by getting their selfGrid)
        if (GetCurrPlayer().equals(allPlayers[PLAYER1_POS])) {
            return allPlayers[PLAYER2_POS];
        }
        else {
            return allPlayers[PLAYER1_POS];
        }
    }

    /* @param opponentShips     - The character array that stores the opponent's ships (meaning this is going to be
                                  the opponent's selfGrid that contains all the positions of their ships
     * @param xCor              - X-coordinate of the attack's midpoint
     * @param yCor              - Y-coordinate of the attack's midpoint
     * @return                  - Returns true if any ship has been hit
                                - Returns false if the attack has not hit any ships */
    private boolean updateShipStatus (char[][] opponentShips, int xCor, int yCor) {
        // Calling the specific "attack" method for the ship
        // Uses polymorphism to call the appropriate attacking pattern
        int[][] attackedPosition = GetCurrAttackingShip().Attack(xCor, yCor);
        // Getting opponent's grid
        char[][] opponentDisplay = GetCurrPlayer().GetOpponentGrid();
        int hitCount = 0;

        for (int i = 0; i < attackedPosition.length; i++) {
            int y = attackedPosition[i][1];
            int x = attackedPosition[i][0];
            if (x > -1 && y > -1) {
                if (opponentShips[y][x] == Player.CARRIER || opponentShips[y][x] == Player.BATTLESHIP ||
                        opponentShips[y][x] == Player.SUBMARINE || opponentShips[y][x] == Player.PATROLBOAT) {
                    // Updates opponent grid (player's attack grid)
                    opponentDisplay[y][x] = Player.HIT;

                    // Checking if the ship is sunk
                    Ship attackedShip = getAttackedShip(opponentShips[y][x], x, y);
                    if (IsShipSunk(attackedShip)) {
                        // Decreases the number of ships alive for the opponent
                        getOpponent().DecrementNumShipsAlive();
                    }

                    // Increments the hit count by one
                    hitCount++;
                } else {
                    opponentDisplay[y][x] = Player.MISS;
                }
            }
        }
        return hitCount != 0;
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
        else if(GetCurrPlayer().GetPlayerShipsAt(attackingShip - 1).GetIsShipSunk()) {
            return SHIP_ALREADY_SUNK;
        }

        else {
            // Sets current attacking ship
            // Input from the main program is different from the index inside the array
            this.currAttackingShip = GetCurrPlayer().GetPlayerShipsAt(attackingShip - 1);
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

        else if(ship instanceof  Carrier){
            return "Carrier";
        }
        return null;
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

    /* @param xCor    - x-coordinate to be attacked
     * @param yCor    - y-coordinate to be attacked
     * @return        - -1 if a ship has been hit (or multiple ships have been hit)
     *                - -2 if the input is out of bounds
     *                - -4 if no ship has been hit */
    public int IsShipHit(int xCor, int yCor) {
        // Validates the input of the x and y coordinates
        if((xCor > GRID_LENGTH || xCor < 0) || (yCor > GRID_LENGTH || yCor < 0)) {
            return INVALID_INPUT;
        }

        else {
            char[][] opponentShips = getOpponent().GetSelfGrid();

            // Calling the specific "attack" method for the ship
            if(updateShipStatus(opponentShips, xCor, yCor)) {
                return SUCCESSFUL;
            }

            else {
                return NO_SHIPS_HIT;
            }
        }
    }

    public boolean IsShipSunk(Ship attackedShip) {
        char[][] opponentShips = getOpponent().GetSelfGrid();
        char[][] opponentDisplay = GetCurrPlayer().GetOpponentGrid();
        int hitCount = 0;

        for(int y = attackedShip.GetYStart(); y <= attackedShip.GetYEnd(); y++) {
            for(int x = attackedShip.GetXStart(); x <= attackedShip.GetXEnd(); x++) {
                if(opponentDisplay[y][x] == Player.HIT) {
                    hitCount++;
                }
            }
        }

        if(hitCount == attackedShip.GetSize()) {
            for(int y = attackedShip.GetYStart(); y <= attackedShip.GetYEnd(); y++) {
                for(int x = attackedShip.GetXStart(); x <= attackedShip.GetXEnd(); x++) {
                    // Updates the attack grid for the current player
                    opponentDisplay[y][x] = Player.SUNK;
                    // Updates the opponent's selfGrid to show that one of their ships have been sunk
                    opponentShips[y][x] = Player.SUNK;
                }
            }
            return true;
        }
        return false;
    }

    public boolean IsGameOver() {
        if(GetCurrPlayer().GetNumShipsAlive() == 0) {
            winner = getOpponent();
            return true;
        }

        else if(getOpponent().GetNumShipsAlive() == 0) {
            winner = GetCurrPlayer();
            return true;
        }
        return false;
    }

    public Player GetWinner() {
        return this.winner;
    }
}
