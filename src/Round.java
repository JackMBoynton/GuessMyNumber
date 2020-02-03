import java.util.Scanner;

public class Round {
    public boolean RoundOver; // Is round over?
    public boolean PlayerOneWon; // Did p1 win round?
    public boolean PlayerTwoWon; // Did p2 win round?
    public int FirstTurn;
    public int PreviousFT; // Prev Round First Turn

    public void FirstTurnDecider() { // Assigns to FirstTurn
        Scanner console = new Scanner(System.in);
        System.out.println("Who would like to go first at giving a number to guess? \n 1) " + Game.PlayerOne + "\n 2) " + Game.PlayerTwo + "\n 3) Flip a Coin");
        FirstTurn = console.nextInt();
        switch(FirstTurn) {
            case 1:
                System.out.println(Game.PlayerOne + " inputs first, " + Game.PlayerTwo + " turn away from the screen.");
                break;
            case 2:
                System.out.println(Game.PlayerTwo + " inputs first, " + Game.PlayerOne + " turn away from the screen.");
                break;
            case 3:
                if (Math.random() < 0.5){
                    FirstTurn = 1;
                    System.out.println(Game.PlayerOne + " inputs first, " + Game.PlayerTwo + " turn away from the screen.");
                } else {
                    FirstTurn = 2;
                    System.out.println(Game.PlayerTwo + " inputs first, " + Game.PlayerOne + " turn away from the screen.");
                }
                break;
        default:
            System.out.println("Option not valid, please select another");
            FirstTurnDecider();
        }
        console.close();
    }

    

}