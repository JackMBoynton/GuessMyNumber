public class Round {
    public boolean RoundOver = false; // Is round over?
    public boolean PlayerOneWon = false; // Did p1 win round?
    public boolean PlayerTwoWon = false; // Did p2 win round?
    public int NumberToGuess = 0;
    public int FirstTurnChoice;
    public String Guesser;
    public int TotalGuesses = 0;
    public int NumberGuessed;

    public void FirstTurnDecider() { // Assigns to FirstTurn
        System.out.println("\n" + "Who would like to go first at giving a number to guess? \n" + "1) " + Game.PlayerOne
                + "\n" + "2) " + Game.PlayerTwo + "\n" + "3) Flip a Coin");
        FirstTurnChoice = GuessMyNumber.console.nextInt();
        switch (FirstTurnChoice) {
        case 1:
            System.out.println(
                    "\n" + Game.PlayerOne + " inputs first, " + Game.PlayerTwo + " turn away from the screen.");
            Guesser = Game.PlayerTwo;
            break;
        case 2:
            System.out.println(
                    "\n" + Game.PlayerTwo + " inputs first, " + Game.PlayerOne + " turn away from the screen.");
            Guesser = Game.PlayerOne;
            break;
        case 3:
            if (Math.random() < 0.5) {
                FirstTurnChoice = 1;
                System.out.println(
                        "\n" + Game.PlayerOne + " inputs first, " + Game.PlayerTwo + " turn away from the screen.");
                Guesser = Game.PlayerTwo;
            } else {
                FirstTurnChoice = 2;
                System.out.println(
                        "\n" + Game.PlayerTwo + " inputs first, " + Game.PlayerOne + " turn away from the screen.");
                Guesser = Game.PlayerOne;
            }
            break;
        default:
            System.out.println("Option not valid, please select another");
            FirstTurnDecider();
        }
    }

    public void NumberInput() { // Assigns to NumberToGuess
        if (FirstTurnChoice == 1) {
            System.out.println(
                    "\n" + Game.PlayerOne + " please input your number for " + Game.PlayerTwo + " to guess now.");
        } else if (FirstTurnChoice == 2) {
            System.out.println(
                    "\n" + Game.PlayerTwo + " please input your number for " + Game.PlayerOne + " to guess now.");
        }
        NumberToGuess = GuessMyNumber.console.nextInt();
        if (NumberToGuess != 0) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        } else {
            NumberInput();
        }
        System.out.println("Console Cleared. Thank you for inputting your Number.");
        System.out.println("\n" + "Remember: " + Guesser + " is guessing now!");
    }

    public void PlayRound() {
        while (TotalGuesses != 5 && NumberGuessed != NumberToGuess) {
            System.out.println("Please make your guess number " + (TotalGuesses + 1) + ":");
            NumberGuessed = GuessMyNumber.console.nextInt();
            if (NumberGuessed != NumberToGuess) {
                System.out.println("Wrong, try again! \n");
            }
            TotalGuesses += 1;
        }
        if (TotalGuesses == 5 && NumberGuessed != NumberToGuess) {
            GuessedWrong();
            RoundOver = true;
            Game.RoundCount += 1;
        } else if (TotalGuesses <= 5 && NumberGuessed == NumberToGuess) {
            GuessedRight();
            RoundOver = true;
            Game.RoundCount += 1;
        }
    }

    public void NewRound() {
        RoundOver = false;
        PlayerOneWon = false;
        PlayerTwoWon = false;
        NumberToGuess = 0;
        // FirstTurnChoice opposite selector.
        if (FirstTurnChoice == 1) {
            FirstTurnChoice = 2;
        } else if (FirstTurnChoice == 2) {
            FirstTurnChoice = 1;
        }
        // Guesser resetter - opposite purson guesses.
        if (Guesser == Game.PlayerOne) {
            Guesser = Game.PlayerTwo;
        } else if (Guesser == Game.PlayerTwo) {
            Guesser = Game.PlayerOne;
        }
        TotalGuesses = 0;
        NumberGuessed = 0;
    }

    public void GuessedWrong() {
        if (NumberGuessed != NumberToGuess && FirstTurnChoice == 1) {
            Game.PlayerOneRounds += 1;
            System.out.println("Congratulations! " + Game.PlayerOne + " you won round " + Game.RoundCount + "!");
        } else if (NumberGuessed != NumberToGuess && FirstTurnChoice == 2) {
            System.out.println("Congratulations! " + Game.PlayerTwo + " you won round " + Game.RoundCount + "!");
            Game.PlayerTwoRounds += 1;
        }
    }

    public void GuessedRight() {
        if (NumberGuessed == NumberToGuess && FirstTurnChoice == 1) {
            Game.PlayerTwoRounds += 1;
            System.out.println("Congratulations! " + Game.PlayerTwo + " you won round " + Game.RoundCount + "!");
        } else if (NumberGuessed == NumberToGuess && FirstTurnChoice == 2) {
            System.out.println("Congratulations! " + Game.PlayerOne + " you won round " + Game.RoundCount + "!");
            Game.PlayerOneRounds += 1;
        }
    }
}