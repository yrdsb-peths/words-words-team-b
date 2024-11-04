import greenfoot.*;

public class EndScreen extends World{
    
    // Labels
    Label titleLabel; 
    Label wordLabel;

    // Actors
    Face face;
    Button musicButton;

    private char[] trueword; 

    /*
     * Constructor 
     */
    public EndScreen(Face face, Button musicButton, char[] word) 
    {
        super(600, 400, 1); // Creates the world 
        setBackground("images/black-background.jpg");
        
        // Sets properties 
        this.face = face;
        this.musicButton = musicButton;
        trueword = word;
        
        // Set highScore
        int highScore;
        
        if(GameWorld.getScore() > GameWorld.getHighScore())
        {
           GameWorld.setHighScore(GameWorld.getScore());
        }
        
        // Add Labels 
        Label highScoreLabel = new Label(GameWorld.getHighScore(), 40);
        addObject(highScoreLabel, 50, 50);
        
        titleLabel = new Label("YOU LOST", 60);
        addObject(titleLabel, getWidth() / 2, getHeight() / 2);

        wordLabel = new Label("",30);
        wordLabel(trueword);
        addObject(wordLabel, getWidth() / 2, 300);

        // Add button to return to titleScreen
        Button menuButton = new BackButton(this::backToMenu);
        addObject(menuButton, 550, 350);
        
        fontColor();
        fireworks();
        
        GameWorld.resetScore();
    }

    /*
     * Create titleScreen
     */
    public void backToMenu() {
        Greenfoot.setWorld(new TitleScreen());
    }

    /*
     * Set wordLabel value as the correct word 
     */
    private void wordLabel(char[] word) {
        // Add a space between each character in the word for spacing
        String wordString = "";
        for (int i = 0; i < word.length; i++) {
            wordString += word[i];
        }

        wordLabel.setValue("Correct word: " + wordString);
    }
    
    /*
     * Sets label colour 
     */
    private void fontColor()
    {
        titleLabel.setFillColor(Color.WHITE);
        titleLabel.setLineColor(Color.WHITE);
    }
    
    /*
     * Creates fireworks 
     */
    private void fireworks()
    {
        Fireworks f1 = new Fireworks();
        Fireworks f2 = new Fireworks();
        addObject(f1, 100, 150);
        addObject(f2, 500, 150);
    }
}
