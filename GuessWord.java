
import java.util.*;

public class GuessWord  
{
    private HashMap<Character, Boolean> secretWord = new HashMap<Character, Boolean>();

    /**
     * Constructor for objects of class GuessWord
     */
    public GuessWord()
    {
        
    }

    private HashMap<Character, Boolean> createMap(String word)
    {
        HashMap<Character, Boolean> secretWord = new HashMap<Character, Boolean>();
        
        char[] charArray = word.toCharArray();
        
        for(char character : charArray)
        {
            secretWord.put((Character) character, new Boolean(false));
        }
        
        return secretWord;
    }
}
