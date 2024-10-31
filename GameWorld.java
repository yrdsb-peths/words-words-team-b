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
    private int incorrectLetterX = 350;
    
    public GameWorld() {
        super(1000, 600, 1);
        
        // Load a random word for the game from a random list
        String[] wordLists = {"word-lists/verbs-themed.txt", "word-lists/nouns-themed.txt", "word-lists/adjectives-themed.txt"};
        String[] randomWord = WordLoader.getRandomWord(wordLists[(int) (Math.random() * wordLists.length)]);
        // Separate the word and the category
        trueWord = randomWord[0].toCharArray();
        category = randomWord[1];

        // Fill the current word with underscores, check if space or dash, if so, display it
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
    }

    public void act() {
        // Get keypresses and interpret it
        handleUserInput(Greenfoot.getKey());
        // Checks if user got the word right
        checkWin();
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
        if (letter != null && letter.length() == 1) {
            alphabetMap.get(letter.charAt(0)).guess();
            
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
            
            // If the letter is not in the word
            if (!letterInWord) {
                // TODO handle incorrect guesses
                incorrect++;
                incorrectLetterX += 50;

                Label incorrectLetter = new Label(letter, 30);
                addObject(incorrectLetter, incorrectLetterX, 550);

                if(incorrect == 1 ) {
                    HangmanHead head = new HangmanHead();
                    addObject(head, 500, 285);
                } else if (incorrect == 2) {
                    HangmanBody body = new HangmanBody("body", false);
                    addObject(body, 570, 388);
                } else if (incorrect == 3) {
                    HangmanBody leftArm = new HangmanBody("arm", true);
                    addObject(leftArm, 420, 340);
                } else if (incorrect == 4) {
                    HangmanBody rightArm = new HangmanBody("arm", false);
                    addObject(rightArm, 580, 340);
                } else if (incorrect == 5) {
                    HangmanBody leftLeg = new HangmanBody("leg", true);
                    addObject(leftLeg, 420, 430);
                } else if (incorrect == 6) {
                    HangmanBody rightLeg = new HangmanBody("arm", false);
                    addObject(rightLeg, 580, 430);
                } else {
                    // create game end screen
                }
            }
        }
    }

    //map the alphabet 
    private HashMap<Character, Letter> createMap(String word)
    {
        HashMap<Character, Letter> alphabet = new HashMap<Character, Letter>();
        
        char[] charArray = ALPHABET.toCharArray();
        
        int xPos = 100;
        int yPos = 200;
        int counter = 0;
        
        for(char letter : charArray)
        {
            //change the position latter
            Letter letterObj = new Letter(letter, xPos, yPos);
            alphabet.put((Character) letter, letterObj);
            
            addObject(letterObj, xPos, yPos);
            
            counter++;
            
            if(counter % 6 == 0)
            {
                yPos += 50;
                xPos = 50;
            }
            
            xPos += 50;
        }
        
        return alphabet;

    }
    
    // Checks if currentWord matches trueWord, then goes to EndScreen if true
    private void checkWin()
    {
        int count = 0;
        for(int i = 0; i < trueWord.length; i++)
        {
            if(currentWord[i] == trueWord[i])
            {
                count++;
            }
        }
        if(count == trueWord.length)
        {
            EndScreen newScreen = new EndScreen();
            Greenfoot.setWorld(newScreen);
        }
    }
}
