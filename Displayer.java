public class Displayer {
    //======================= CONSTRUCTOR =======================//
    public Displayer() {
    }

    //====================== PUBLIC METHOD =======================//
    /* Displays the game title screen */
    public void GameHeader() {
        System.out.println("====================================");
        System.out.println("|      WELCOME TO BATTLESHIPS!     |");
        System.out.println("====================================");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("| Rules:                                                                           |");
        System.out.println("| 1. Take turns bombing your opponent's grid                                       |");
        System.out.println("| 2. You may use different types of missiles based off your ships                  |");
        System.out.println("| 3. If you hit your opponent's ship, you can have another turn until you miss     |");
        System.out.println("| 4. You win when you eliminate all of your opponent's ships                       |");
        System.out.println("| 5. Your starting ships will be randomized                                        |");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Press 'enter' to start");
    }

    /* Displays the player's game status */
    public void GameStatus(Player p) {
        System.out.println("---------- CURRENT STATUS ----------");
        System.out.println("Player Name     : " + p.GetPlayerName());
        System.out.println("Own Ships Alive : " + p.GetNumShipsAlive());
        System.out.println("Own Ships Sunk  : " + p.GetNumShipsSunk());
        System.out.println("-------------------------------------");
    }

    /* Displays the grid that the player can attack */
    public void ShowOpponentGrid(char[][] opponentGrid) {
        System.out.println("Your opponent's grid:");
        System.out.println("\t+---+---+---+---+---+---+---+---+---+---+");
        for (int row = 0; row < BattleshipSystem.GRID_HEIGHT; row++) {
            System.out.print("\t|");

            for (int col = 0; col < BattleshipSystem.GRID_WIDTH; col++) {
                System.out.print(" ");

                if (opponentGrid[row][col] == Player.EMPTY) {
                    System.out.print(" ");
                }
                else if (opponentGrid[row][col] == Player.HIT) {
                    System.out.print(Player.HIT);
                }

                else if (opponentGrid[row][col] == Player.MISS) {
                    System.out.print(Player.MISS);
                }

                else if (opponentGrid[row][col] == Player.SUNK) {
                    System.out.print(Player.SUNK);
                }

                System.out.print(" ");
                System.out.print("|");
            }

            System.out.println();
            System.out.println("\t+---+---+---+---+---+---+---+---+---+---+");
        }

        System.out.printf("%3s %3d %3d %3d %3d %3d %3d %3d %3d %3d %3d\n", "COL", 0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    /* Displays the player's own ships */
    public void ShowSelfGrid(char[][] selfGrid) {
        System.out.println("Your grid:");
        System.out.println("\t+---+---+---+---+---+---+---+---+---+---+");
        for (int row = 0; row < BattleshipSystem.GRID_HEIGHT; row++) {
            System.out.print("\t|");

            for (int col = 0; col < BattleshipSystem.GRID_WIDTH; col++) {
                System.out.print(" ");

                if(selfGrid[row][col] == Player.SHIP) {
                    System.out.print(Player.SHIP);
                }

                else if(selfGrid[row][col] == Player.EMPTY) {
                    System.out.print(" ");
                }

                else if(selfGrid[row][col] == Player.HIT) {
                    System.out.print(Player.HIT);
                }

                else if(selfGrid[row][col] == Player.MISS) {
                    System.out.print(Player.MISS);
                }

                else if(selfGrid[row][col] == Player.SUNK) {
                    System.out.print(Player.SUNK);
                }

                System.out.print(" ");
                System.out.print("|");
            }

            System.out.println();
            System.out.println("\t+---+---+---+---+---+---+---+---+---+---+");
        }

        System.out.printf("%3s %3d %3d %3d %3d %3d %3d %3d %3d %3d %3d\n", "COL", 0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    }
}
