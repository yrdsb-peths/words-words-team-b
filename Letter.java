import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Letter extends Actor
{
    private char letter;
    private boolean guessed = false;
    private int size = 10;
    
    private int xPos;
    private int yPos;
    
    private GameWorld world = (GameWorld) getWorld();

    /**
     * Constructor for objects of class Letter
     */
    public Letter(char theLetter, int theXPos, int theYPos)
    {
        letter = theLetter;
        xPos = theXPos;
        yPos = theYPos;
        
        Label letterLabel = new Label(letter, size);
        world.addObject(letterLabel, xPos, yPos);
    }

    public void guess()
    {
        guessed = true;
        
        crossLetter();
    }
    
    public void crossLetter()
    {
        Label crossLabel = new Label("/", 10);
        world.addObject(crossLabel, xPos, yPos);
    }
    
    public boolean isGuessed()
    {
        return guessed;
    }
}
