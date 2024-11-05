import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Letter extends Actor {
    private char letter;
    private boolean guessed = false;
    private int size = 50;

    private int xPos;
    private int yPos;

    private Label letterLabel;

    /**
     * Constructor for objects of class Letter
     */
    public Letter(char theLetter, int theXPos, int theYPos) {
        letter = theLetter;
        xPos = theXPos;
        yPos = theYPos;

        setImage((GreenfootImage) null);

        letterLabel = new Label(Character.toString(letter), size);        
    }

    public void addedToWorld(World world) {
        world.addObject(letterLabel, xPos, yPos);
    }

    /*
     * Crosses the letter if not guessed
     */
    public void guess() {
        if (!guessed) crossLetter();

        guessed = true;
    }

    /*
     * Create a cross for guessed word 
     */
    public void crossLetter() {
        Label crossLabel = new Label("/", size);
        // Set the cross to be red
        crossLabel.setFillColor(new Color(180, 20, 20));
        getWorld().addObject(crossLabel, xPos, yPos);
    }

    /*
     * Return if guessed
     */
    public boolean isGuessed() {
        return guessed;
    }
}
