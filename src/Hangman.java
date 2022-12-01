import java.util.Locale;
import java.util.Scanner;
import java.util.Random;

public class Hangman {
    private String[] topicList = {"SCHOOL SUBJECT", "COLOR", "HOLIDAY", "ANIMAL", "FRUIT"};
    private String[] subjWords = {"MATH", "SCIENCE", "ENGLISH", "GYM"};
    private String[] colorWords = {"PURPLE", "PINK", "BLUE", "RED", "YELLOW", "ORANGE"};
    private String[] holidayWords = {"CHRISTMAS", "HALLOWEEN", "THANKSGIVING", "RAMADAN", "EASTER", "DIWALI"};
    private String[] animalWords = {"CHICKEN", "ELEPHANT", "ALLIGATOR", "CROCODILE"};
    private String[] fruitWords = {"APPLE", "BANANA", "TOMATO", "POMEGRANATE", "DRAGONFRUIT"};
    private String topic;
    private String word;
    private String blankWord;
    private String wrongGuesses;
    private int wrongCounter;
    private int guessesLeft;

    public Hangman(){}

    Scanner scan = new Scanner(System.in);

    private void randomWord(){
        topic = topicList[new Random().nextInt(topicList.length)].toUpperCase();
        if(topic.equals("SCHOOL SUBJECT")){
            word = subjWords[new Random().nextInt(subjWords.length)].toUpperCase();
        } else if(topic.equals("COLOR")){
            word = colorWords[new Random().nextInt(colorWords.length)].toUpperCase();
        } else if(topic.equals("HOLIDAY")){
            word = holidayWords[new Random().nextInt(holidayWords.length)].toUpperCase();
        } else if(topic.equals("ANIMAL")){
            word = animalWords[new Random().nextInt(animalWords.length)].toUpperCase();
        } else if(topic.equals("FRUIT")){
            word = fruitWords[new Random().nextInt(fruitWords.length)].toUpperCase();
        }
    }

    public void play() {
        randomWord();
        wrongGuesses = "";
        blankWord = "";
        wrongCounter = 0;
        guessesLeft = 5;
        for (int i = 1; i <= word.length(); i++) {
            blankWord += "-";
        }
        hangman(0);


        while(wrongCounter <= 5 && !(blankWord.equals(word))) {
            System.out.println("Your topic is: " + topic);
            System.out.println("Your word is: " + blankWord);
            System.out.println("Wrong guesses: " + wrongGuesses);
            System.out.println("Limbs left: " + (guessesLeft-wrongCounter));
            System.out.print("Enter a character or a guess: ");
            String guess = scan.nextLine();
            guessCheck(guess);
            hangman(wrongCounter);
            if(blankWord.equals(word)){
                System.out.println("You win!");
            }
            if(wrongCounter == 5){
                System.out.println("You lose!");
            }
        }





    }

    private void guessCheck(String guess) {
        guess = guess.toUpperCase();
        if (guess.length() == 1) {
            if (word.contains(guess)) {
                for (int i = 0; i < word.length(); i++) {
                    if (word.substring(i, i + 1).equals(guess)) {
                        int index = i;
                        blankWord = blankWord.substring(0, index) + guess + blankWord.substring(index + 1);
                    }
                }
            } else {
                wrongGuesses += guess + " ";
                wrongCounter++;
            }

        } else if(guess.length() > 1){
            if(guess.equals(word)){
                blankWord = guess;
            }
        }

    }


    public void hangman(int numWrong) {
        if (numWrong == 0) {
            System.out.println("   ____________");
            System.out.println("   |          |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   | ");
            System.out.println("___|___");
        }

        if(numWrong == 1){
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("___|___");
        }

        if(numWrong == 2){
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |           |");
            System.out.println("   |           |");
            System.out.println("   |");
            System.out.println("___|___");
        }

        if(numWrong == 3){
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |           |");
            System.out.println("   |           |");
            System.out.println("   |          /  ");
            System.out.println("___|___      /   ");
        }

        if(numWrong == 4){
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |           |");
            System.out.println("   |           |");
            System.out.println("   |          / \\ ");
            System.out.println("___|___      /   \\");
        }

        if(numWrong == 5){
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |          _|_");
            System.out.println("   |         / | \\");
            System.out.println("   |          / \\ ");
            System.out.println("___|___      /   \\");
        }

    }
}


