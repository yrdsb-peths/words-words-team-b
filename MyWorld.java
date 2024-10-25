import greenfoot.*;
import java.util.*;

public class MyWorld extends World {
    private final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    HashMap<Character, Letter> alphabetMap = new HashMap<Character, Letter>();


    public MyWorld() {
        super(600, 400, 1);
        
        alphabetMap = createMap(ALPHABET);
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
