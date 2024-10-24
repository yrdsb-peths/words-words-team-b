import greenfoot.*;

public class GameWorld extends World {
    private char[] trueWord;
    private char[] currentWord;
    private Label wordLabel;
    
    public GameWorld() {
        super(1000, 600, 1);
        
        // Load a random word for the game
        trueWord = WordLoader.getRandomWord(WordLoader.loadWords("word-lists/nouns.txt")).toCharArray();

        // Fill the current word with underscores
        currentWord = new char[trueWord.length];
        for (int i = 0; i < currentWord.length; i++) {
            currentWord[i] = '_';
        }

        // Create a label to display the word, and add it to the world
        wordLabel = new Label(String.valueOf(currentWord), 60);
        wordLabel.setFillColor(Color.BLACK);
        addObject(wordLabel, getWidth() / 2, 100);
    }

    private void updateWordLabel(char[] word) {
        wordLabel.setValue(String.valueOf(word));
    }
}
