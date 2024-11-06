import greenfoot.*;

public class EndScreen extends World {
    private Label titleLabel;
    private Label wordLabel;
    
    GreenfootSound guessSound = new GreenfootSound("sounds/lossSound.mp3");

    public EndScreen(Face face, Button musicButton, char[] word) 

    {
        super(600, 400, 1);
        setBackground("images/black-background.jpg");

        // Update high score
        if (GameWorld.getScore() > GameWorld.getHighScore()) {
            GameWorld.setHighScore(GameWorld.getScore());
        }
        
        // Score label
        Label score = new Label("Score: " + GameWorld.getScore(), 40);
        addObject(score, 70, 20);

        // High score label
        Label highScoreLabel = new Label("Highscore: " + GameWorld.getHighScore(), 40);
        addObject(highScoreLabel, 110, 50);  

        // Display title label and the correct word
        titleLabel = new Label("YOU LOST", 60);

        addObject(titleLabel, getWidth() / 2, getHeight() / 2);

        wordLabel = new Label("",30);
        wordLabel(word);
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
