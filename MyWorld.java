import greenfoot.*;

public class MyWorld extends World {
    private final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";


    public MyWorld() {
        super(600, 400, 1);
        
        System.out.println(ALPHABET.length());
    }
    
    //map the alphabet 
    private HashMap<Character, Letter> createMap(String word)
    {
        HashMap<Character, Boolean> secretWord = new HashMap<Character, Boolean>();
        
        char[] charArray = word.toCharArray();
        
        for(char character : charArray)
        {
            if(character == ' ' || character == '-')
            {
                /secretWord.put((Character), char new Boolean(false));
            }
            
            secretWord.put((Character) character, new Boolean(false));
        }
        
        return secretWord;
    }
}
