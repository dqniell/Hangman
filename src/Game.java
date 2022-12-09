import java.util.Scanner;

public class Game {
    Scanner scan = new Scanner(System.in);
    public Game(){
    }

    public void startGame(){
        System.out.println("Welcome to hangman. Guess the word before you run out of limbs!");
        boolean repeat = true;
        while (repeat){
            System.out.print("Would you like to pick your topic? y/n: ");
            String ans = scan.nextLine();
            int ansAsNum = 0;
            Hangman game1;
            if (ans.equals("n")) {
                game1 = new Hangman();
                ansAsNum = 1;
            } else {
                System.out.print("Pick from the following topics (school subject, color, holiday, animal, fruit): ");
                String topic = scan.nextLine();
                game1 = new Hangman(topic);
                ansAsNum = 2;
            }
            game1.play(ansAsNum);
            System.out.print("Would you like to play again? (y/n): ");
            String answer = scan.nextLine();
            if (answer.equals("n")){
                repeat = false;
                System.out.println("Thank you for playing hangman!");
            }
        }
    }
}
