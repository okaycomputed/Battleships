import java.util.Scanner;

public class BattleshipMain {
    public static void main(String[] args) {
        Displayer d = new Displayer();
        Scanner input = new Scanner(System.in);
        BattleshipSystem bs;

        d.GameHeader();
        input.nextLine();

        // Game starts
        // Allow users to enter their own name
        System.out.print("Player 1, please enter your name: ");
        String player1Name = input.nextLine();

        System.out.print("Player 2, please enter your name: ");
        String player2Name = input.nextLine();

        // Creates the game system using the names as a parameter
        bs = new BattleshipSystem(player1Name, player2Name);

        // Creating allPlayer array
        Player[] allPlayers =  bs.GetAllPlayers();

        // Initializing player grids
        allPlayers[BattleshipSystem.PLAYER1_POS].InitializeSelfGrid();
        allPlayers[BattleshipSystem.PLAYER2_POS].InitializeSelfGrid();

        boolean gameOver = false;

        // ======== DISPLAYING PLAYER GRIDS =========
        do {
            d.GameStatus(bs.GetCurrPlayer());
            d.ShowSelfGrid(bs.GetCurrPlayer().GetSelfGrid());
            System.out.println();
            d.ShowOpponentGrid(bs.GetCurrPlayer().GetOpponentGrid());
            boolean turnOver = false;

            do {
                boolean isOptionValid = false;

                // Turn starts
                do {
                    System.out.println(bs.GetCurrPlayer().GetPlayerName() + ", please take your turn.");
                    System.out.println("Select a ship to carry out the attack: ");
                    System.out.println("1. Carrier");
                    System.out.println("2. Battleship");
                    System.out.println("3. Submarine");
                    System.out.println("4. Patrol Boat 1");
                    System.out.println("5. Patrol Boat 2");
                    System.out.print("Option: ");
                    int shipOption = input.nextInt();

                    // Insert method to set attacking ship, if ship has already been sunken or if the option is invalid,
                    // return the corresponding error messages
                    int errorCode = bs.SetCurrAttackingShip(shipOption);
                    if (errorCode == BattleshipSystem.INVALID_INPUT) {
                        System.out.println("Ship option does not exist, please try again.");
                    }

                    else if (errorCode == BattleshipSystem.SHIP_ALREADY_SUNK) {
                        System.out.println("The ship chosen has already been sunk, please try again.");
                    }

                    else {
                        System.out.println("Attacking ship has been set to " + "'" + bs.GetAttackingShipName(bs.GetCurrAttackingShip()) + "'");
                        isOptionValid = true;
                    }
                }
                while(!isOptionValid);

                System.out.print("Please enter the x-coordinate to hit: ");
                int attackXCor = input.nextInt();
                System.out.print("Please enter the y-coordinate to hit: ");
                int attackYCor = input.nextInt();

                // Insert error checking here to ensure that the ship can be hit
                // return the results of the attack
                int attackResult = bs.IsShipHit(attackXCor, attackYCor);

                // Ensures that another turn is not taken when the game should already be over
                if (attackResult == BattleshipSystem.SUCCESSFUL && !bs.IsGameOver()) {
                    d.GameStatus(bs.GetCurrPlayer());
                    d.ShowOpponentGrid(bs.GetCurrPlayer().GetOpponentGrid());
                    System.out.println("You have hit a ship! You can now take another turn.");
                }

                else if (attackResult == BattleshipSystem.NO_SHIPS_HIT) {
                    d.GameStatus(bs.GetCurrPlayer());
                    d.ShowOpponentGrid(bs.GetCurrPlayer().GetOpponentGrid());
                    System.out.println("No ships have been hit, your turn is over.");
                    bs.SwitchPlayer();
                    turnOver = true;
                }

                else if(attackResult == BattleshipSystem.INVALID_INPUT) {
                    System.out.println("Invalid coordinates, your turn is over.");
                    bs.SwitchPlayer();
                    turnOver = true;
                }

                else if(attackResult == BattleshipSystem.ALREADY_HIT) {
                    System.out.println("The coordinate you have entered has already been attacked, your turn is over.");
                    bs.SwitchPlayer();
                    turnOver = true;
                }

                // Indicates game is over, moves on to ending screen
                else {
                    turnOver = true;
                }

            }
            while(!turnOver);

            if(bs.IsGameOver()) {
                // Displays winning grid
                d.ShowOpponentGrid(bs.GetWinner().GetOpponentGrid());
                // Displays the ending screen
                d.WinDisplay(bs.GetWinner());
                gameOver = true;
            }
        }
        while(!gameOver);
    }
}
