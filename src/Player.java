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
        shipGrid = new char[BattleshipSystem.GRID_LENGTH][BattleshipSystem.GRID_LENGTH];
        numShipsAlive = TOTAL_NUM_SHIPS;
        numShipsSunk = 0;

        // Making both grids empty
        for(int row = 0; row < BattleshipSystem.GRID_LENGTH; row++) {
            for(int col = 0; col < BattleshipSystem.GRID_LENGTH; col++) {
                selfGrid[row][col] = EMPTY;
                opponentGrid[row][col] = EMPTY;
                shipGrid[row][col] = EMPTY;
            }
        }

        // Instantiating ships inside the ship array for each player
        playerShips = new Ship[TOTAL_NUM_SHIPS];
     }

    //====================== PRIVATE METHOD =======================//
    private void updateShipGrid(char[][] shipGrid, int xStart, int yStart, int xEnd, int yEnd, int shipOrientation) {
        if(shipOrientation == HORIZONTAL) {
            // Ship is placed in the right corner
            if((yStart - 1 < 0 || xStart - 1 < 0)
                    && (yEnd + 2 < BattleshipSystem.GRID_LENGTH || xEnd + 1 < BattleshipSystem.GRID_LENGTH)) {
                for (int y = yStart; y < yEnd + 2; y++) {
                    for (int x = xStart; x < xEnd + 1; x++) {
                        shipGrid[y][x] = OCCUPIED;
                    }
                }
            }
            // Ship is placed in the left corner
            else if ((yStart - 1 > 0 || xStart - 1 > 0)
                    && (yEnd + 2 > BattleshipSystem.GRID_LENGTH || xEnd + 1 > BattleshipSystem.GRID_LENGTH)){
                for (int y = yStart - 1; y < yEnd; y++) {
                    for (int x = xStart - 1; x < xEnd; x++) {
                        shipGrid[y][x] = OCCUPIED;
                    }
                }
            }

            else {
                for (int y = yStart - 1; y < yEnd + 2; y++) {
                    for (int x = xStart - 1; x < xEnd + 1; x++) {
                        shipGrid[y][x] = OCCUPIED;
                    }
                }
            }
        }

        else {
            for (int y = yStart - 1; y < yEnd + 1; y++) {
                for (int x = xStart - 1; x < xEnd + 2; x++) {
                    shipGrid[y][x] = OCCUPIED;
                }
            }
        }
    }

    private boolean checkPositionValid(char[][] shipGrid, int xStart, int yStart, int xEnd, int yEnd, int length) {
        int count = 0;
        for(int y = yStart; y < yEnd; y++) {
            for(int x = xStart; x < xEnd; x++) {
                if(shipGrid[y][x] == EMPTY) {
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
        int xCor, yCor;
        boolean isShipPlaced = false;
        do {
            // Randomize starting coordinates
            xCor = rand.nextInt(10);
            yCor = rand.nextInt(10);

            // Checking ship orientation and ensuring that the end value is not out of bounds
            if (shipOrientation == VERTICAL && yCor + Carrier.CARRIER_LENGTH < BattleshipSystem.GRID_LENGTH) {
                playerShips[0] = new Carrier(xCor, yCor, xCor, yCor + Carrier.CARRIER_LENGTH, Carrier.CARRIER_LENGTH);
                // Updates the char array
                for (int y = yCor; y < yCor + Carrier.CARRIER_LENGTH; y++) {
                    selfGrid[y][xCor] = SHIP;
                }

                updateShipGrid(shipGrid, xCor, yCor, xCor, yCor + Carrier.CARRIER_LENGTH, shipOrientation);
                isShipPlaced = true;
            }

            else if (shipOrientation == HORIZONTAL && xCor + Carrier.CARRIER_LENGTH < BattleshipSystem.GRID_LENGTH) {
                playerShips[0] = new Carrier(xCor, yCor, xCor + Carrier.CARRIER_LENGTH, yCor, Carrier.CARRIER_LENGTH);
                for (int x = xCor; x < xCor + Carrier.CARRIER_LENGTH; x++) {
                    selfGrid[yCor][x] = SHIP;
                }
                updateShipGrid(shipGrid, xCor, yCor, xCor + Carrier.CARRIER_LENGTH, yCor, shipOrientation);
                isShipPlaced = true;
            }
        }
        while (!isShipPlaced);
        // Use of "do-while" loop in order to continuously randomize coordinates until they are valid and in
        // bounds of the grid array
    }

    //====================== PUBLIC METHOD =======================//
    public void InitializeSelfGrid() {
        placeCarrier(selfGrid, shipGrid, 1);
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
}
