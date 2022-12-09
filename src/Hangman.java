import java.util.Scanner;
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

    public Hangman(){
        topic = "";
        word = "";
        blankWord = "";
        wrongGuesses = "";
        wrongCounter = 0;
        guessesLeft = 0;
    }

    public Hangman(String topic) {
        this.topic = topic;
        word = "";
        blankWord = "";
        wrongGuesses = "";
        wrongCounter = 0;
        guessesLeft = 0;
    }

    Scanner scan = new Scanner(System.in);

    private void randomWord(){
        topic = topicList[(int) (Math.random() * topicList.length)].toUpperCase();
        if(topic.equals("SCHOOL SUBJECT")){
            word = subjWords[(int) (Math.random() * subjWords.length)].toUpperCase();
        } else if(topic.equals("COLOR")){
            word = colorWords[(int) (Math.random() * colorWords.length)].toUpperCase();
        } else if(topic.equals("HOLIDAY")){
            word = holidayWords[(int) (Math.random() * holidayWords.length)].toUpperCase();
        } else if(topic.equals("ANIMAL")){
            word = animalWords[(int) (Math.random() * animalWords.length)].toUpperCase();
        } else if(topic.equals("FRUIT")){
            word = fruitWords[(int) (Math.random() * fruitWords.length)].toUpperCase();
        }

    }

    private void randomWord(String userTopic){
        userTopic = userTopic.toUpperCase();
        if(userTopic.equals("SCHOOL SUBJECT")){
            word = subjWords[(int) (Math.random() * subjWords.length)].toUpperCase();
        } else if(userTopic.equals("COLOR")){
            word = colorWords[(int) (Math.random() * colorWords.length)].toUpperCase();
        } else if(userTopic.equals("HOLIDAY")){
            word = holidayWords[(int) (Math.random() * holidayWords.length)].toUpperCase();
        } else if(userTopic.equals("ANIMAL")){
            word = animalWords[(int) (Math.random() * animalWords.length)].toUpperCase();
        } else if(userTopic.equals("FRUIT")){
            word = fruitWords[(int) (Math.random() * fruitWords.length)].toUpperCase();
        }
    }

    public void play(int userChoice) {
        if (userChoice == 1) {
            randomWord();
        } else {
            randomWord(topic);
        }
        wrongGuesses = "";
        blankWord = "";
        wrongCounter = 0;
        guessesLeft = 5;
        for (int i = 1; i <= word.length(); i++) {
            blankWord += "-";
        }
        System.out.println(hangmanPrinter(0));


        while(wrongCounter < 5 && !(blankWord.equals(word))) {
            System.out.println("Your topic is: " + topic);
            System.out.println("Your word is: " + blankWord);
            System.out.println("Wrong guesses: " + wrongGuesses);
            System.out.println("Limbs left: " + (guessesLeft-wrongCounter));
            System.out.print("Enter a character or a guess: ");
            String guess = scan.nextLine();
            guessCheck(guess);
            System.out.println(hangmanPrinter(wrongCounter));
            if(blankWord.equals(word)){
                System.out.println("You win!");
            }
            if(wrongCounter == 5 && (guessesLeft - wrongCounter == 0)){
                System.out.println("Wrong guesses: " + wrongGuesses);
                System.out.println("Limbs left: " + (guessesLeft-wrongCounter));
                System.out.println("You lose!");
                System.out.println("The word was: " + word);
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
            } else {
                wrongCounter++;
                wrongGuesses += guess + " ";
            }
        }
    }

    public String hangmanPrinter
            (int numWrong) {
        if (numWrong == 0) {
            return "   ____________\n   |          |\n   |\n   |\n   |\n   |\n   |\n   | \n___|___";
        }else if(numWrong == 1){
            return "   ____________\n   |          _|_\n   |         /   \\\n   |        |     |\n   |         \\_ _/\n   |\n   |\n   |\n___|___";
        }else if(numWrong == 2){
            return "   ____________\n   |          _|_\n   |         /   \\\n   |        |     |\n   |         \\_ _/\n   |           |\n   |           |\n   |\n___|___";
        }else if(numWrong == 3){
            return "   ____________\n   |          _|_\n   |         /   \\\n   |        |     |\n   |         \\_ _/\n   |           |\n   |           |\n   |          /  \n___|___      /   ";
        }else if(numWrong == 4){
            return "   ____________\n   |          _|_\n   |         /   \\\n   |        |     |\n   |         \\_ _/\n   |           |\n   |           |\n   |          / \\ \n___|___      /   \\";
        } else {
            return "   ____________\n   |          _|_\n   |         /   \\\n   |        |     |\n   |         \\_ _/\n   |          _|_\n   |         / | \\\n   |          / \\ \n___|___      /   \\";
        }
    }
}


