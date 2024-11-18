public class Player {

    private String playerName;
    private int numShipsAlive;
    private char[][] selfGrid;
    private char[][] opponentGrid;
    private char[][] shipGrid;
    private Ship[] playerShips;

    public static final int VERTICAL         = 0;   // Indicates orientation of the ship
    public static final int HORIZONTAL       = 1;   // Indicates orientation of the ship
    public static final int TOTAL_NUM_SHIPS  = 5;

    // Global chars to represent the different grid statuses
    public static final char EMPTY    = '-';
    public static final char SUNK     = 'X';
    public static final char HIT      = '+';
    public static final char MISS     = '#';
    public static final char OCCUPIED = '*';

    // Global chars for each type of ship
    public static final char CARRIER     = 'C';
    public static final char BATTLESHIP  = 'B';
    public static final char SUBMARINE   = 'S';
    public static final char PATROLBOAT  = 'P';

    //======================= CONSTRUCTOR =======================//
    // DEVELOPED BY: CHLOE
    /* @param playerName - Player name from user-input */
    public Player(String playerName) {
        this.playerName = playerName;
        selfGrid = new char[BattleshipSystem.GRID_LENGTH][BattleshipSystem.GRID_LENGTH];
        opponentGrid = new char[BattleshipSystem.GRID_LENGTH][BattleshipSystem.GRID_LENGTH];
        shipGrid = new char[12][12];
        numShipsAlive = TOTAL_NUM_SHIPS;

        // Making both grids empty
        for(int row = 0; row < BattleshipSystem.GRID_LENGTH; row++) {
            for(int col = 0; col < BattleshipSystem.GRID_LENGTH; col++) {
                selfGrid[row][col] = EMPTY;
                opponentGrid[row][col] = EMPTY;
            }
        }

        // Initializing ship grid
        for(int row = 0; row < shipGrid.length; row++) {
            for(int col = 0; col < shipGrid.length; col++) {
                shipGrid[row][col] = EMPTY;
            }
        }

        // Instantiating ships inside the ship array for each player
        playerShips = new Ship[TOTAL_NUM_SHIPS];
     }

    //====================== PRIVATE METHOD =======================//
    // DEVELOPED BY: CHLOE
    /* Private method updates the ship grid by drawing a one block rectangle around a ship so that other ships cannot
       be placed next to a ship
     * @param shipGrid - Passes in the 12x12 ship grid containing all the blocked out positions of the ships on the board */
    private void updateShipGrid(int xStart, int yStart, int xEnd, int yEnd) {
        // Translate the positions on a regular "game grid" to the 12x12 "ship grid"
        // All coordinates should be incremented by ONE
        for (int y = (yStart + 1) - 1; y <= (yEnd + 1) + 1; y++) {
            for (int x = (xStart + 1) - 1; x <= (xEnd + 1) + 1; x++) {
                this.shipGrid[y][x] = OCCUPIED;
            }
        }
    }

    // DEVELOPED BY: CHLOE
    /* Private method that takes in the coordinates of a ship and compares it to the ship array to see if it can be
     * placed. If the ship grid is empty, that means there is free space.
     * @param length          - Length of a ship: how many blocks it occupies
     * @param shipOrientation - Randomizes a number either 0 or 1 which will determine if the ship is placed
     *                        - vertically or horizontally
     * @return                - Returns "true" if there is free space for a ship to be placed */
    private boolean checkPositionValid(int xStart, int yStart, int xEnd,
                                      int yEnd, int length, int shipOrientation) {
        // Uses a count variable to keep track of the amount of free spaces
        int count = 0;
        if(shipOrientation == VERTICAL) {
            // Coordinates are incremented by one to translate the positions on the internal "ship grid"
            // to the external "game grid"
            for(int y = (yStart + 1); y <= (yEnd + 1); y++) {
                if(this.shipGrid[y][xStart + 1] != OCCUPIED) {
                    count++;
                }
            }
        }

        else if(shipOrientation == HORIZONTAL) {
            for(int x = (xStart + 1); x <= (xEnd + 1); x++) {
                if(this.shipGrid[yStart + 1][x] != OCCUPIED) {
                    count++;
                }
            }
        }
        return count == length;
    }

    // DEVELOPED BY: CHLOE
    /* Private method that randomizes the coordinates of a ship according to the length used as a parameter
     * @param length          - Length of a ship: how many blocks it occupies
     * @param shipOrientation - Randomizes a number either 0 or 1 which will determine if the ship is placed
     *                        - vertically or horizontally
     * @return                - Returns an integer array with the randomized coordinates of the ship */
    private int[] randomizeShipInfo(int length, int shipOrientation) {
        int[] shipInfo = new int[5];
        boolean isCoordinateValid = false;

        do {
            // Randomize starting shipInfo
            shipInfo[0] = (int) (Math.random() * 10);   // x-start
            shipInfo[1] = (int) (Math.random() * 10);   // y-start

            // Both x-end and y-end are stored in the array initially
            // as it is easier to replace the coordinates later
            shipInfo[2] = (shipInfo[0] + length) - 1;   // x-end
            shipInfo[3] = (shipInfo[1] + length) - 1;   // y-end

            shipInfo[4] = shipOrientation;

            // Checking ship orientation and ensuring that the end value is not out of bounds
            // Different y-axis, same x-axis
            if (shipOrientation == VERTICAL && shipInfo[3] < BattleshipSystem.GRID_LENGTH) {
                // Checking if the ship can be placed inside the internal "ship grid"
                if (checkPositionValid(shipInfo[0], shipInfo[1], shipInfo[0], shipInfo[3], length, VERTICAL)) {
                    // Replaces x-coordinate inside the array
                    shipInfo[2] = shipInfo[0];
                    isCoordinateValid = true;
                }
            }

            // Different x-axis, same y-axis
            else if (shipOrientation == HORIZONTAL && shipInfo[2] < BattleshipSystem.GRID_LENGTH) {
                if (checkPositionValid(shipInfo[0], shipInfo[1], shipInfo[2], shipInfo[1], length, HORIZONTAL)) {
                    shipInfo[3] = shipInfo[1];
                    isCoordinateValid = true;
                }
            }
        }
        while(!isCoordinateValid);

        return shipInfo;
    }

    // DEVELOPED BY: CHLOE
    /* Private method to display the "Ship" object onto the player's character grid. Blocks out positions in
     * the internal "ship grid" that determines where a new ship can be placed.
     * @param ship  - Ship object to be displayed */
    private void placeShip(Ship ship) {
        if(ship.GetShipOrientation() == VERTICAL) {
            // Updating "self grid" (also referred to as the "game grid") char array
            // to display the ship in the main program
            for (int y = ship.GetYStart(); y <= ship.GetYEnd(); y++) {
                this.selfGrid[y][ship.GetXStart()] = ship.GetShipChar();
            }
            // Updates the internal "ship grid" to block out ship position
            // This makes it so that ships cannot be adjacent to each other
            updateShipGrid(ship.GetXStart(), ship.GetYStart(), ship.GetXEnd(), ship.GetYEnd());
        }

        else if(ship.GetShipOrientation() == HORIZONTAL) {
            for (int x = ship.GetXStart(); x <= ship.GetXEnd(); x++) {
                this.selfGrid[ship.GetYStart()][x] = ship.GetShipChar();
            }
            updateShipGrid(ship.GetXStart(), ship.GetYStart(), ship.GetXEnd(), ship.GetYEnd());
        }
    }

    //====================== PUBLIC METHOD =======================//
    // DEVELOPED BY: CHLOE
    /* Randomizes the positions of each ship inside the playerShip array and places them on the player's self grid */
    public void InitializeSelfGrid() {
        // Getting randomized info from the private method and storing it into a 1D integer array
        int[] carrier = randomizeShipInfo(Carrier.CARRIER_LENGTH, (int) (Math.random() * 2));
        // Creating new carrier object in the "player ships" array that stores all the player's ships
        // The index is incremented manually as all ships are of different subclasses
        playerShips[0] = new Carrier(carrier[0], carrier[1], carrier[2], carrier[3], carrier[4],
                Carrier.CARRIER_LENGTH, CARRIER);
        // Placing the "Ship" object onto the player's own grid
        placeShip(playerShips[0]);

        int[] battleship = randomizeShipInfo(Battleship.BATTLESHIP_LENGTH, (int) (Math.random() * 2));
        playerShips[1] = new Battleship(battleship[0], battleship[1], battleship[2], battleship[3], battleship[4],
                Battleship.BATTLESHIP_LENGTH, BATTLESHIP);
        placeShip(playerShips[1]);

        int[] submarine = randomizeShipInfo(Submarine.SUBMARINE_LENGTH, (int) (Math.random() * 2));
        playerShips[2] = new Submarine(submarine[0], submarine[1], submarine[2], submarine[3],
                submarine[4], Submarine.SUBMARINE_LENGTH, SUBMARINE);
        placeShip(playerShips[2]);

        int[] patrolboat1 = randomizeShipInfo(PatrolBoat.PATROLBOAT_LENGTH, (int) (Math.random() * 2));
        playerShips[3] = new PatrolBoat(patrolboat1[0], patrolboat1[1], patrolboat1[2], patrolboat1[3],
                patrolboat1[4], PatrolBoat.PATROLBOAT_LENGTH, PATROLBOAT);
        placeShip(playerShips[3]);

        int[] patrolBoat2 = randomizeShipInfo(PatrolBoat.PATROLBOAT_LENGTH, (int) (Math.random() * 2));
        playerShips[4] = new PatrolBoat(patrolBoat2[0], patrolBoat2[1], patrolBoat2[2],
                patrolBoat2[3], patrolBoat2[4], PatrolBoat.PATROLBOAT_LENGTH, PATROLBOAT);
        placeShip(playerShips[4]);

    }

    // DEVELOPED BY: CHLOE
    // Getter method for this Player object's name
    public String GetPlayerName() {
        return this.playerName;
    }

    // DEVELOPED BY: CHLOE
    // Getter method for this Player object's number of ships alive
    public int GetNumShipsAlive() {
        return this.numShipsAlive;
    }

    // DEVELOPED BY: CHLOE
    // Decreases the number of ships alive by one
    public void DecrementNumShipsAlive() {
        this.numShipsAlive--;
    }

    // DEVELOPED BY: CHLOE
    // Gets a Ship object from a Player's allShips array using the index as a parameter
    public Ship GetPlayerShipsAt(int index) {
        return this.playerShips[index];
    }

    // DEVELOPED BY: CHLOE
    // Getter method for Player object's "self grid"
    public char[][] GetSelfGrid() {
        return this.selfGrid;
    }

    // DEVELOPED BY: CHLOE
    // Getter method for Player object's "opponent grid"
    public char[][] GetOpponentGrid() {
        return this.opponentGrid;
    }

    // DEVELOPED BY: CHLOE
    // Method for testing, kept it in so the internal grid can still be accessed
    public char[][] GetShipGrid() {
        return this.shipGrid;
    }

}
