import greenfoot.*;
import java.util.*;

public class GameWorld extends World {
    private final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    HashMap<Character, Letter> alphabetMap = new HashMap<Character, Letter>();

    private char[] trueWord;
    private char[] currentWord;
    private Label wordLabel;
    
    public GameWorld() {
        super(1000, 600, 1);
        
        // Load a random word for the game
        trueWord = WordLoader.getRandomWord(WordLoader.loadWords("word-lists/nouns.txt")).toCharArray();

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
        wordLabel.setFillColor(Color.BLACK);
        addObject(wordLabel, getWidth() / 2, 100);

        updateWordLabel(currentWord);

        alphabetMap = createMap(ALPHABET);
    }

    private void updateWordLabel(char[] word) {
        // Add a space between each character in the word for spacing
        String wordString = "";
        for (int i = 0; i < word.length; i++) {
            wordString += word[i] + " ";
        }

        wordLabel.setValue(wordString);
    }

    //map the alphabet 
    private HashMap<Character, Letter> createMap(String word)
    {
        HashMap<Character, Letter> alphabet = new HashMap<Character, Letter>();
        
        char[] charArray = ALPHABET.toCharArray();
        
        for(char letter : charArray)
        {
            //change the position latter
            alphabet.put((Character) letter, new Letter(letter, 300, 200));
        }
        
        return alphabet;
    }
}
