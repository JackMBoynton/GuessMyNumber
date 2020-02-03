import java.util.Scanner;

public class GuessMyNumber {

    public static void main(String[] args) {
        // Creating instances of the game, round(s) and scanner to take inputs.
        Round round = new Round();
        // Game game = new Game();
        Scanner console = new Scanner(System.in);
        
        // Player One enters name
        System.out.println("Player 1 Enter Name:");
        Game.PlayerOne = console.nextLine();
        System.out.println("Player One name: '" + Game.PlayerOne + "' set");
        // Player Two enters name
        System.out.println("Player 2 Now Enter Name:");
        Game.PlayerTwo = console.nextLine();
        System.out.println("Player Two name: '" + Game.PlayerTwo + "' set");
        // Who wants to go first at giving a number to guess?
        round.FirstTurnDecider();

        console.close();
    }
    
}