import greenfoot.*;
import java.util.*;

public class GameWorld extends World {
    private final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    HashMap<Character, Letter> alphabetMap = new HashMap<Character, Letter>();

    private char[] trueWord;
    private char[] currentWord;
    private String category;

    private Label wordLabel;
    private Label categoryLabel;

    private int incorrect = 0;
    private Face face;
    private Button musicButton;

    private int timer = Integer.MAX_VALUE;
    private int displayTime = 30;

    private static int score = 0;
    private static int highScore = 0;

    public GameWorld(Face face, Button musicButton) {
        super(1000, 600, 1);
        setBackground("images/blueBackground.png");
        this.face = face;

        // Add score
        Label score = new Label("Score: " + GameWorld.getScore(), 40);
        addObject(score, 70, 20);
        
        // Add music button 
        this.musicButton = musicButton;
        addObject(musicButton, 950, 555);

        Gallow gallow = new Gallow();
        addObject(gallow, 570, 430);

        // Load a random word for the game from a random list
        String[] wordLists = { "word-lists/verbs-themed.txt", "word-lists/nouns-themed.txt",
                "word-lists/adjectives-themed.txt" };
        String[] randomWord = WordLoader.getRandomWord(wordLists[(int) (Math.random() * wordLists.length)]);
        // Separate the word and the category
        trueWord = randomWord[0].toCharArray();
        category = randomWord[1];

        // Fill the current word with underscores, check if space or dash, if so,
        // display it
        currentWord = new char[trueWord.length];
        for (int i = 0; i < currentWord.length; i++) {
            if (trueWord[i] == ' ' || trueWord[i] == '-') {
                currentWord[i] = trueWord[i];
            } else {
                currentWord[i] = '_';
            }
        }

        // Create a label to display the word, and add it to the world
        wordLabel = new Label(String.valueOf(currentWord), 60);
        // Font fill black - default is gross hollow text
        wordLabel.setFillColor(Color.BLACK);
        addObject(wordLabel, getWidth() / 2, 100);
        // Update the word label - initial display
        updateWordLabel(currentWord);

        // Create a label to display the category
        categoryLabel = new Label("Category: " + category, 30);
        categoryLabel.setFillColor(Color.BLACK);
        addObject(categoryLabel, getWidth() / 2, 50);

        alphabetMap = createMap(ALPHABET);

        // clear any previous keys input
        Greenfoot.getKey();
    }

    public void act() {
        //displays a countdown timer
        countdownTimer();
        
        // Get keypresses and interpret it
        handleUserInput(Greenfoot.getKey());
    }

    private void updateWordLabel(char[] word) {
        // Add a space between each character in the word for spacing
        String wordString = "";
        for (int i = 0; i < word.length; i++) {
            wordString += word[i] + " ";
        }

        wordLabel.setValue(wordString);
    }

    private void handleUserInput(String letter) {
        // Null check (no key pressed) and length check (keys like escape, shift, etc.)
        if (letter != null && letter.length() == 1 && Character.isLetter(letter.charAt(0))) {

            // Check if the letter is in the word
            boolean letterInWord = false;
            for (int i = 0; i < trueWord.length; i++) {
                if (trueWord[i] == letter.charAt(0)) {
                    currentWord[i] = trueWord[i];
                    letterInWord = true;

                }
            }

            // Update the word label
            updateWordLabel(currentWord);

            if (letterInWord) {
                // Checks if user got the word right
                checkWin();
            } else if (!alphabetMap.get(letter.charAt(0)).isGuessed()) {
                incorrect++;
                createHangman();
            }

            alphabetMap.get(letter.charAt(0)).guess();
        }
    }

    /*
     * Creates the hangman and endScreen at the end
     */
    private void createHangman() {
        if (incorrect == 1) {
            HangmanHead head = new HangmanHead();
            addObject(head, 500, 305);
        } else if (incorrect == 2) {
            HangmanBodyParts body = new HangmanBodyParts("body", false);
            addObject(body, 570, 408);
        } else if (incorrect == 3) {
            HangmanBodyParts leftArm = new HangmanBodyParts("arm", true);
            addObject(leftArm, 420, 360);
        } else if (incorrect == 4) {
            HangmanBodyParts rightArm = new HangmanBodyParts("arm", false);
            addObject(rightArm, 580, 360);
        } else if (incorrect == 5) {
            HangmanBodyParts leftLeg = new HangmanBodyParts("leg", true);
            addObject(leftLeg, 420, 450);
        } else if (incorrect == 6) {
            HangmanBodyParts rightLeg = new HangmanBodyParts("arm", false);
            addObject(rightLeg, 580, 450);
        } else if (incorrect == 7) {
            addObject(face, 498, 309);
            Greenfoot.delay(5);

            // Create game end screen
            EndScreen newScreen = new EndScreen(face, musicButton, trueWord);

            Greenfoot.setWorld(newScreen);
        }

    }

    // map the alphabet
    private HashMap<Character, Letter> createMap(String word) {
        HashMap<Character, Letter> alphabet = new HashMap<Character, Letter>();

        char[] charArray = ALPHABET.toCharArray();

        int xPos = 100;
        int yPos = 200;
        int counter = 0;

        for (char letter : charArray) {
            // add the letter to the map
            Letter letterObj = new Letter(letter, xPos, yPos);
            alphabet.put((Character) letter, letterObj);

            addObject(letterObj, xPos, yPos);

            counter++;

            if (counter % 6 == 0) {
                yPos += 50;
                xPos = 50;
            }

            xPos += 50;
        }

        return alphabet;

    }

    // Checks if currentWord matches trueWord, then goes to EndScreen if true
    private void checkWin() {
        int count = 0;

        // Loop through the current word and check if it matches the true word
        for (int i = 0; i < trueWord.length; i++) {
            if (currentWord[i] == trueWord[i]) {
                count++;
            }
        }

        // If the count is equal to the length of the true word, the user has won
        if (count == trueWord.length) {
            score++;
            Greenfoot.delay(5);
            NextRoundScreen newScreen = new NextRoundScreen(face, musicButton);
            Greenfoot.setWorld(newScreen);
        }
    }
    
    // Creates a countdown timer
    private void countdownTimer() {
        if(timer % 100 == 0)
        {
            displayTime--;
        }
        TimerLabel tl = new TimerLabel(displayTime, 50);
        removeObjects(getObjects(TimerLabel.class));
        addObject(tl, 950, 50);
        timer--;
        
        if(displayTime == -1)
        {
            EndScreen newScreen = new EndScreen(face, musicButton, trueWord);
            Greenfoot.setWorld(newScreen);
        }
    }

    public static int getScore() {
        return score;
    }

    public static int getHighScore() {
        return highScore;
    }

    public static void resetScore() {
        score = 0;
    }

    public static void setHighScore(int theHighScore) {
        highScore = theHighScore;
    }
}
