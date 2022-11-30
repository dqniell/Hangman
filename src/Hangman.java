import java.util.Locale;
import java.util.Scanner;
import java.util.Random;

public class Hangman {
    private String[] topicList = {"SCHOOL SUBJECT", "COLOR", "HOLIDAY", "ANIMAL", "FRUIT"};
    private String[] subjWords = {"MATH", "SCIENCE", "ENGLISH", "PHYSICAL EDUCATION"};
    private String[] colorWords = {"PURPLE", "PINK", "BLUE", "RED", "YELLOW", "ORANGE"};
    private String[] holidayWords = {"CHRISTMAS", "HALLOWEEN", "THANKSGIVING", "NEW YEARS", "LUNAR NEW YEAR"};
    private String[] animalWords = {"CHICKEN", "ELEPHANT", "ALLIGATOR", "CROCODILE"};
    private String[] fruitWords = {"APPLE", "BANANA", "TOMATO", "POMEGRANATE", "DRAGONFRUIT"};
    private String topic;
    private String word;
    private String blankWord;
    private String wrongGuesses;
    private int wrongCounter;

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

    public void play(){
        randomWord();
        wrongGuesses = "";
        blankWord =  "";
        wrongCounter = 0;
        for (int i = 1; i <= word.length(); i++){
            blankWord += "-";
        }
        while(wrongCounter <= 5) {
            hangman(0);
            System.out.println("Your hint is: " + topic);
            System.out.println("The word is: " + blankWord);
            System.out.println("Enter your guess: (wrong guesses: " + wrongGuesses + ")");
            String guess = scan.nextLine();
            guessCheck(guess);
        }
    }

    private void guessCheck(String guess){
        guess = guess.toUpperCase();
        if(word.contains(guess)){
            blankWord = blankWord.replace(word.substring(word.indexOf(guess), word.indexOf(guess) + 1), guess);
        } else if(!word.contains(guess)){
            wrongGuesses += guess;
            wrongCounter++;
        }
        System.out.println(blankWord);
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


