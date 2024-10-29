public class Displayer {
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

    public void GameStatus(Player p) {
        System.out.println("---------- CURRENT STATUS ----------");
        System.out.println("Player Name     : " + p.GetPlayerName());
        System.out.println("Own Ships Alive : " + p.GetNumShipsAlive());
        System.out.println("Own Ships Sunk  : " + p.GetNumShipsSunk());
        System.out.println("-------------------------------------");
    }

    public void ShowOpponentGrid(Ship[][] opponentGrid) {
        System.out.println("Your opponent's grid:");
        System.out.println("\t+---+---+---+---+---+---+---+---+---+---+");
        for (int row = 0; row < BattleshipSystem.GRID_HEIGHT; row++) {
            System.out.print("\t|");

            for (int col = 0; col < BattleshipSystem.GRID_WIDTH; col++) {
                System.out.print(" ");

                if (opponentGrid[row][col] == null) {
                    System.out.print(" ");
                }
                else if (opponentGrid[row][col].GetShipStatus() == Ship.HIT_SHIP) {
                    System.out.print("+");
                }

                else if (opponentGrid[row][col].GetShipStatus() == Ship.HIT_MISSED) {
                    System.out.println("#");
                }

                else if (opponentGrid[row][col].GetIsShipSunk()) {
                    System.out.print("X");
                }

                System.out.print(" ");
                System.out.print("|");
            }

            System.out.println();
            System.out.println("\t+---+---+---+---+---+---+---+---+---+---+");
        }

        System.out.printf("%3s %3d %3d %3d %3d %3d %3d %3d %3d %3d %3d\n", "COL", 0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    public void ShowSelfGrid(Ship[][] selfGrid) {
        System.out.println("Your grid:");
        System.out.println("\t+---+---+---+---+---+---+---+---+---+---+");
        for (int row = 0; row < BattleshipSystem.GRID_HEIGHT; row++) {
            System.out.print("\t|");

            for (int col = 0; col < BattleshipSystem.GRID_WIDTH; col++) {
                System.out.print(" ");

                if(selfGrid[row][col] != null) {
                    System.out.print("S");
                }

                else if(selfGrid[row][col] == null) {
                    System.out.print(" ");
                }

                else if(selfGrid[row][col].GetShipStatus() == Ship.HIT_SHIP) {
                    System.out.print("+");
                }

                else if(selfGrid[row][col].GetShipStatus() == Ship.HIT_MISSED) {
                    System.out.print("#");
                }

                else if(selfGrid[row][col].GetIsShipSunk()) {
                    System.out.print("X");
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
