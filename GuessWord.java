
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
    
    
    
    //check if the player has won
    private boolean checkWin()
    {
        for(Character key : secretWord.keySet())
        {
            if(secretWord.get(key).booleanValue() == false) return false; 
        }
        
        return true;
    }

    //convert word into a map
    private HashMap<Character, Boolean> createMap(String word)
    {
        HashMap<Character, Boolean> secretWord = new HashMap<Character, Boolean>();
        
        char[] charArray = word.toCharArray();
        
        for(char character : charArray)
        {
            if(character == ' ' || character == '-')
            {
                secretWord.put((Character) char new Boolean(false));
            }
            
            secretWord.put((Character) character, new Boolean(false));
        }
        
        return secretWord;
    }
}
