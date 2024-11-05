import java.util.Scanner;

public class BattleshipMain {
    public static void main(String[] args) {
        Displayer d = new Displayer();
        Scanner input = new Scanner(System.in);
        BattleshipSystem bs;

        d.GameHeader();
        input.nextLine();

        // Game starts
        System.out.print("Player 1, please enter your name: ");
        String player1Name = input.nextLine();

        System.out.print("Player 2, please enter your name: ");
        String player2Name = input.nextLine();

        bs = new BattleshipSystem(player1Name, player2Name);

        d.GameStatus(bs.GetCurrPlayer());
        d.ShowSelfGrid(bs.GetCurrPlayer().GetSelfGrid());
        d.ShowOpponentGrid(bs.GetCurrPlayer().GetOpponentGrid());

        System.out.println("Select a ship to carry out the attack: ");
        System.out.println("1. Carrier");
        System.out.println("2. Battleship");
        System.out.println("3. Submarine");
        System.out.println("4. Patrol Boat");
        int shipOption = input.nextInt();

        // Insert method to set attacking ship, if ship has already been sunken or if the option is invalid,
        // return the corresponding error messages

        System.out.print("Please enter the x-coordinate to hit: ");
        int attackXCor = input.nextInt();
        System.out.print("Please enter the y-coordinate to hit: ");
        int attackYCor = input.nextInt();

        // Insert error checking here to ensure that the ship can be hit
        // return the results of the attack
    }
}
