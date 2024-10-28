public class Main {
    public static void main(String[] args) {
        char[][] grid = new char[10][10];
        System.out.println("  | A | B | C | D | E | F | G | H | I | J |");

        // Iterating number of rows
        for (int row = 0; row < grid.length; row++) {
            System.out.println("--|---+---+---+---+---+---+---+---+---+---+");
            System.out.println(row + " |   |   |   |   |   |   |   |   |   |   |");
        }
        System.out.println("--|---+---+---+---+---+---+---+---+---+---+");
    }
}
