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

        System.out.println("Please enter the x-coordinate to hit: ");
        System.out.println("Please enter the y-coordinate to hit: ");

    }
}
