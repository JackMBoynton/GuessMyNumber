public class Game {

    public static int RoundsToWin = 2;
    public static int PlayerOneRounds = 0;
    public static int PlayerTwoRounds = 0;
    public static int RoundCount = 1;
    public static String PlayerOne;
    public static String PlayerTwo;

    public void TakePlayerNames() { // Assigns to PlayerOne and PlayerTwo
        // Player One enters name
        System.out.println("Player 1 Enter Name:");
        Game.PlayerOne = GuessMyNumber.console.nextLine();
        System.out.println("Player One name: '" + PlayerOne + "' set");
        // Player Two enters name
        System.out.println("\n" + "Player 2 Now Enter Name:");
        Game.PlayerTwo = GuessMyNumber.console.nextLine();
        System.out.println("Player Two name: '" + PlayerTwo + "' set");
    }

    public void ScoreChecker() {
        System.out.println(
                "Score is (" + PlayerOne + ": " + PlayerOneRounds + " - " + PlayerTwoRounds + " " + PlayerTwo + ")");
    }

}