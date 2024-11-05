import greenfoot.*;

public class TitleScreen extends World {

    private Button musicButton;
    private Face face;

    public TitleScreen() {
        super(600, 400, 1);
        setBackground("images/BlackBackground.png");

        // Add game name
        Label gameLabel = new Label("Hangman", 100);
        addObject(gameLabel, getWidth() / 2, 100);

        // Add buttons
        Button startButton = new StartButton(this::goGameScreen);
        addObject(startButton, 300, 340);

        musicButton = new MusicButton(this::changeVolume);
        addObject(musicButton, 550, 350);

        Button selectButton = new SelectButton(this::changeFace);
        addObject(selectButton, 340, 220);

        RedCircle redCircle = new RedCircle();
        addObject(redCircle, 250, 220);

        face = new Face(false);
        addObject(face, 250, 220);
    }

    /*
     * Plays or pauses the music
     */
    public void changeVolume() {
        ((MusicButton) musicButton).setButton();
    }

    /*
     * Creates game screen
     */
    public void goGameScreen() {
        Greenfoot.setWorld(new GameWorld(face, musicButton));
    }

    public void changeFace() {
        face.changeImage();
    }

}
