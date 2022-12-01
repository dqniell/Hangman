import java.util.Scanner;

public class Game {
    Scanner scan = new Scanner(System.in);
    public Game(){
    }

    public void startGame(){
        System.out.println("Welcome to hangman. Guess the word before you run out of limbs!");
        Hangman game1 = new Hangman();
        boolean repeat = true;
        while (repeat){
            game1.play();
            System.out.print("Would you like to play again? (y/n): ");
            String answer = scan.nextLine();
            if (answer.equals("n")){
                repeat = false;
                System.out.println("Thank you for playing hangman!");
            }
        }
    }
}
