import greenfoot.*;

public class TitleScreen extends World {
   
    Button musicButton;

    public TitleScreen() {
        super(600, 400, 1);

        // Add game name 
        Label gameLabel = new Label("Hangman", 100);
        addObject(gameLabel, getWidth()/2, 100);

        // Add buttons 
        Button startButton = new StartButton(this::goGameScreen);
        addObject(startButton, 300, 340);

        musicButton = new MusicButton(this::changeVolume);
        addObject(musicButton, 550, 350);

        // Button starButton = new StarButton(this::goHighScore);
        // addObject(starButton, 50, 50);
    }

    /*
     * Plays or pauses the music 
     */
    public void changeVolume() {
        ((MusicButton) musicButton).setButton(); 
    }

    /*
     * Create game screen 
     */
    public void goGameScreen() {
        Greenfoot.setWorld(new GameWorld());
    }


    // public void goInstructions() {
    //     Greenfoot.setWorld(new InstructionScreen());
    // }

    // public void goHighScore() {
    //     Greenfoot.setWorld(new HighScoreScreen());
    // }


}
