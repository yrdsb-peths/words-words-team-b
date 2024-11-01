import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NextRound here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NextRoundScreen extends World
{

    /**
     * Constructor for objects of class NextRound.
     * 
     */
    Face face;
    Button musicButton;

    public NextRoundScreen(Face face, Button musicButton)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        this.face = face;
        this.musicButton = musicButton;
        
        Label score = new Label("Score: " + GameWorld.getScore(), 40);
        addObject(score, 70, 40);
        
        CreateNextRoundButton();
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
