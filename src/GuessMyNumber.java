import java.util.Scanner;

public class GuessMyNumber {

    public static final Scanner console = new Scanner(System.in);

    public static void main(String[] args) {
        // Creating instances of the game, round(s) and scanner to take inputs.
        Round round = new Round();
        Game game = new Game();
        // Take the players names only once, at the start of the game.
        game.TakePlayerNames();
        // Who wants to go first at giving a number to guess? (First round only, because
        // we use this info to decide r2 and 3.)
        round.FirstTurnDecider();
        do {
            // Take the round number to guess
            round.NumberInput();
            while (round.RoundOver == false) {
                round.PlayRound();
            }
            game.ScoreChecker();
            round.NewRound();
        } while (Game.RoundCount <= 3);

        // Close the scanner so no resource leak takes place.
        console.close();
    }

}