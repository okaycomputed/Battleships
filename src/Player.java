import java.util.Random;

public class Player {
    Random rand = new Random();

    private String playerName;
    private int numShipsAlive;
    private int numShipsSunk;
    private char[][] selfGrid;
    private char[][] opponentGrid;
    private char[][] shipGrid;
    private Ship[] playerShips;

    public static final int VERTICAL         = 0;   // Indicates orientation of the ship
    public static final int HORIZONTAL       = 1;   // Indicates orientation of the ship
    public static final int TOTAL_NUM_SHIPS  = 5;

    // Global chars to represent the different grid statuses
    public static final char EMPTY    = '-';
    public static final char SHIP     = 'S';
    public static final char SUNK     = 'X';
    public static final char HIT      = '+';
    public static final char MISS     = '#';
    public static final char OCCUPIED = '*';

    //======================= CONSTRUCTOR =======================//
    public Player(String playerName) {
        this.playerName = playerName;
        selfGrid = new char[BattleshipSystem.GRID_LENGTH][BattleshipSystem.GRID_LENGTH];
        opponentGrid = new char[BattleshipSystem.GRID_LENGTH][BattleshipSystem.GRID_LENGTH];
        shipGrid = new char[12][12];
        numShipsAlive = TOTAL_NUM_SHIPS;
        numShipsSunk = 0;

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
    /* Private method updates the ship grid by drawing a one block rectangle around a ship so that other ships cannot
       be placed next to a ship
     * @param shipGrid - Passes in the 12x12 ship grid containing all the blocked out positions of the ships on the board */
    private void updateShipGrid(char[][] shipGrid, int xStart, int yStart, int xEnd, int yEnd) {
        // Translate the positions on a regular "game grid" to the 12x12 "ship grid"
        // All coordinates should be incremented by ONE
        for (int y = (yStart + 1) - 1; y <= (yEnd + 1) + 1; y++) {
            for (int x = (xStart + 1) - 1; x <= (xEnd + 1) + 1; x++) {
                shipGrid[y][x] = OCCUPIED;
            }
        }
    }

    /* Private method that takes in the coordinates of a ship and compares it to the ship array to see if it can be
     * placed. If the ship grid is empty, that means there is free space.
     * @param length          - Length of a ship; how many blocks it occupies
     * @param shipOrientation - Randomizes a number either 0 or 1 which will determine if the ship is placed
     *                        - vertically or horizontally
     * @return                - Returns "true" if there is free space for a ship to be placed */
    public boolean checkPositionValid(char[][] shipGrid, int xStart, int yStart, int xEnd, int yEnd,
                                      int length, int shipOrientation) {
        int count = 0;
        if(shipOrientation == VERTICAL) {
            for(int y = yStart; y <= yEnd; y++) {
                if(shipGrid[y][xStart] == EMPTY) {
                    count++;
                }
            }
        }

        else {
            for(int x = xStart; x <= xEnd; x++) {
                if(shipGrid[yStart][x] == EMPTY) {
                    count++;
                }
            }
        }
        return count == length;
    }

    /* Private method places a ship object of "carrier" subclass onto the grid on random coordinates
     * @param selfGrid           - Passes in the current player's grid
     * @param shipOrientation    - Randomizes a number either 0 or 1 which will determine if the ship is placed
     *                           - vertically or horizontally */
    private void placeCarrier(char[][] selfGrid, char[][] shipGrid, int shipOrientation) {
        int xStart, yStart, xEnd, yEnd;
        boolean isShipPlaced = false;
        do {
            // Randomize starting coordinates
            xStart = rand.nextInt(10);
            yStart = rand.nextInt(10);

            xEnd = (xStart + Carrier.CARRIER_LENGTH) - 1;
            yEnd = (yStart + Carrier.CARRIER_LENGTH) - 1;

            // Checking ship orientation and ensuring that the end value is not out of bounds
            if (shipOrientation == VERTICAL && yEnd < BattleshipSystem.GRID_LENGTH) {
                if(checkPositionValid(shipGrid, xStart, yStart, xStart, yEnd, Carrier.CARRIER_LENGTH, VERTICAL)) {
                    // Creates the ship object inside the playerShips Ship object array
                    playerShips[0] = new Carrier(xStart, yStart, xStart, yEnd);
                    // Updates the char array
                    for (int y = yStart; y <= yEnd; y++) {
                        selfGrid[y][xStart] = SHIP;
                    }
                    updateShipGrid(shipGrid, xStart, yStart, xStart, yEnd);
                    isShipPlaced = true;
                }
            }

            else if (shipOrientation == HORIZONTAL && xEnd < BattleshipSystem.GRID_LENGTH) {
                if(checkPositionValid(shipGrid, xStart, yStart, xEnd, yStart, Carrier.CARRIER_LENGTH, HORIZONTAL)) {
                    playerShips[0] = new Carrier(xStart, yStart, xEnd, yStart);
                    for (int x = xStart; x <= xEnd; x++) {
                        selfGrid[yStart][x] = SHIP;
                    }
                    updateShipGrid(shipGrid, xStart, yStart, xEnd, yStart);
                    isShipPlaced = true;
                }
            }
        }
        while (!isShipPlaced);
    }

    /* Just drafting out my thoughts here, but I was thinking making a method to RETURN the coordinates? Like maybe as
       an array right because there are multiple numbers to return. Then, I can make another method to PLACE the ships
       I think that if I make multiple methods similar to the 'placeCarrier' method its just going to be repeating a lot
       of unneeded code.
       One method to: Randomize coordinates, check if they are valid, then return
       Another method to: Do blocking inside the ship grid, and update the char selfGrid */

    //====================== PUBLIC METHOD =======================//
    public void InitializeSelfGrid() {
        placeCarrier(selfGrid, shipGrid, rand.nextInt(2));
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

    public char[][] GetShipGrid() {
        return this.shipGrid;
    }

    // returns array containing all Ship objects
    /*public Ship[] GetPlayerShips() {
        return this.playerShips();
    }

    // Changes the array when a ship is sunk
    // sunken ships will be null
    public void SetPlayerShips(int index) {
        this.playerShips[] = null;
    } */

}
