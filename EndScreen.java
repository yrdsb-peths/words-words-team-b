import greenfoot.*;

public class EndScreen extends World {
    
    // Labels
    Label titleLabel;
    Label wordLabel;

    // Actors
    Face face;
    Button musicButton;

    private char[] trueword; 
    
    GreenfootSound guessSound = new GreenfootSound("sounds/lossSound.mp3");

    public EndScreen(Face face, Button musicButton, char[] word) 

    {
        super(600, 400, 1);
        setBackground("images/black-background.jpg");
        this.face = face;
        this.musicButton = musicButton;
        trueword = word;
                
        // High score label
        Label highScoreLabel = new Label("Highscore: " + GameWorld.getHighScore(), 40);
        addObject(highScoreLabel, 100, 50);  

        // Display title label and the correct word
        titleLabel = new Label("YOU LOST", 60);

        addObject(titleLabel, getWidth() / 2, getHeight() / 2);

        wordLabel = new Label("",30);
        wordLabel(trueword);
        addObject(wordLabel, getWidth() / 2, 300);

        Button menuButton = new BackButton(this::backToMenu);
        addObject(menuButton, 550, 350);
        
        fontColor();
        fireworks();
        
        GameWorld.resetScore();
        
        guessSound.play();
    }

    /*
     * Return back to title screen
     */
    public void backToMenu() {
        Greenfoot.setWorld(new TitleScreen());
    }

    private void wordLabel(char[] word) {
        // Add a space between each character in the word for spacing
        String wordString = "";
        for (int i = 0; i < word.length; i++) {
            wordString += word[i];
        }

        wordLabel.setValue("Correct word: " + wordString);
    }

    /*
     * Set title label colour
     */
    private void fontColor() {
        titleLabel.setFillColor(Color.WHITE);
        titleLabel.setLineColor(Color.WHITE);
    }

    /*
     * Create fireworks 
     */
    private void fireworks() {
        Fireworks f1 = new Fireworks();
        Fireworks f2 = new Fireworks();
        addObject(f1, 100, 150);
        addObject(f2, 500, 150);
    }
}
