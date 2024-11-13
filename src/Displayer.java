public class Displayer {
    //======================= CONSTRUCTOR =======================//
    public Displayer() {
    }

    //====================== PUBLIC METHOD =======================//
    /* Displays the game title screen */
    public void GameHeader() {
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
        System.out.println("Ships Alive     : " + p.GetNumShipsAlive());
        System.out.println("-------------------------------------");
    }

    /* Displays the grid that the player can attack */
    public void ShowOpponentGrid(char[][] opponentGrid) {
        System.out.println("Your opponent's grid:");

        System.out.printf("\t%3d %3d %3d %3d %3d %3d %3d %3d %3d %3d\n", 0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println("\t+---+---+---+---+---+---+---+---+---+---+");
        for (int row = 0; row < BattleshipSystem.GRID_LENGTH; row++) {
            System.out.print(" " + row + "  |");

            for (int col = 0; col < BattleshipSystem.GRID_LENGTH; col++) {
                System.out.print(" ");

                if (opponentGrid[row][col] == Player.EMPTY) {
                    System.out.print(" ");
                }

                else {
                    System.out.print(opponentGrid[row][col]);
                }

                System.out.print(" ");
                System.out.print("|");
            }

            System.out.println();
            System.out.println("\t+---+---+---+---+---+---+---+---+---+---+");
        }
    }

    /* Displays the player's own ships */
    public void ShowSelfGrid(char[][] selfGrid) {
        System.out.println("Your grid:");
        System.out.printf("\t%3d %3d %3d %3d %3d %3d %3d %3d %3d %3d\n", 0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println("\t+---+---+---+---+---+---+---+---+---+---+");
        for (int row = 0; row < BattleshipSystem.GRID_LENGTH; row++) {
            System.out.print(" " + row + "  |");

            for (int col = 0; col < BattleshipSystem.GRID_LENGTH; col++) {
                System.out.print(" ");

                if(selfGrid[row][col] == Player.EMPTY) {
                    System.out.print(" ");
                }

                else {
                    System.out.print(selfGrid[row][col]);
                }

                System.out.print(" ");
                System.out.print("|");
            }

            System.out.println();
            System.out.println("\t+---+---+---+---+---+---+---+---+---+---+");
        }
    }

    // FOR TESTING PURPOSES ONLY
    public void DisplayShipGrid(char[][] shipGrid) {
        for(int i = 0; i < shipGrid.length; i++) {
            for(int j = 0; j < shipGrid.length; j++) {
                System.out.print(shipGrid[i][j] + " ");
            }

            System.out.println();
        }
    }
}
