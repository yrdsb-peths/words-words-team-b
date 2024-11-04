import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NextRound here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NextRoundScreen extends World
{
    Face face;
    Button musicButton;
    
    String userInput;
    /**
     * Constructor for objects of class NextRound.
     * 
     */
    public NextRoundScreen(Face face, Button musicButton)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        this.face = face;
        this.musicButton = musicButton;
        setBackground("images/BlackBackground.png");
        
        Label score = new Label("Score: " + GameWorld.getScore(), 40);
        addObject(score, 70, 40);

        GoodJobGif goodJob = new GoodJobGif();
        addObject(goodJob, 300, 200);
        
        CreateNextRoundButton();
    }

    public void act() {
        userInput = Greenfoot.getKey();

        if(userInput != null) {
            if(userInput.equals("space") || userInput.equals("enter")) {
                nextRound();
            }
        }
    }
    
    public void CreateNextRoundButton()
    {
        // Add buttons 
        Button nextRoundButton = new NextRoundButton(this::nextRound);
        addObject(nextRoundButton, 300, 340);
    }
    
    public void nextRound()
    {
        Greenfoot.setWorld(new GameWorld(face, musicButton));
    }
    
}
