import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Letter extends Actor
{
    private char letter;
    private boolean guessed = false;
    private int size = 10;
    
    private int xPos;
    private int yPos;
    
    private Label letterLabel;

    /**
     * Constructor for objects of class Letter
     */
    public Letter(char theLetter, int theXPos, int theYPos)
    {
        letter = theLetter;
        xPos = theXPos;
        yPos = theYPos;
        
        letterLabel = new Label(letter, size);
    }

    public void addedToWorld(World world)
    {
        world.addObject(letterLabel, xPos, yPos);
    }

    public void guess()
    {
        guessed = true;
        
        crossLetter();
    }
    
    public void crossLetter()
    {
        Label crossLabel = new Label("/", size);
        getWorld().addObject(crossLabel, xPos, yPos);
    }
    
    public boolean isGuessed()
    {
        return guessed;
    }
}
