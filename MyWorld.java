import greenfoot.*;
import java.util.*;

public class MyWorld extends World {
    private final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";


    public MyWorld() {
        super(600, 400, 1);
        
        System.out.println(ALPHABET.length());
    }
    
    //map the alphabet 
    private HashMap<Character, Letter> createMap(String word)
    {
        HashMap<Character, Letter> secretWord = new HashMap<Character, Letter>();
        
        char[] charArray = ALPHABET.toCharArray();
        
        for(char letter : charArray)
        {
            //change the position latter
            secretWord.put((Character) character, new Letter(letter, 300, 200));
        }
        
        return secretWord;
    }
}
