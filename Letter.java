
public class Letter extends Actor
{
    private char letter;
    private boolean isGuess = false;
    private int size = 10;
    
    private int xPos;
    private int yPos;
    
    private MyWorld world = (MyWorld) getWorld();

    /**
     * Constructor for objects of class Letter
     */
    public Letter(char theLetter, int theXPos, int theYPos)
    {
        letter = theLetter;
        xPos = theXPos;
        yPos = theYPos;
        
        Label letterLabel = new Label(letter, 10);
        world.addObject(letterLabel, xPos, yPos);
    }

     public void guess()
    {
        isGuess = true;
        
        crossLetter();
    }
    
    public void crossLetter()
    {
        Label crossLabel = new Label("/", 10);
        world.addObject(crossLabel, xPos, yPos);
    }
    
    public boolean getIsGuess()
    {
        return isGuess;
    }
}
