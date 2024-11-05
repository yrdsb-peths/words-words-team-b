import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class NextRoundScreen extends World {
    private Face face;
    private Button musicButton;

    private String userInput;

    public NextRoundScreen(Face face, Button musicButton) {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        this.face = face;
        this.musicButton = musicButton;
        setBackground("images/BlackBackground.png");

        // Score label
        Label score = new Label("Score: " + GameWorld.getScore(), 40);
        addObject(score, 70, 40);

        // Gif
        GoodJobGif goodJob = new GoodJobGif();
        addObject(goodJob, 300, 200);

        // Creates next round button
        CreateNextRoundButton();
    }

    public void act() {
        userInput = Greenfoot.getKey(); // gets user pressed key

        // Return to game world if user pressed space or enter
        if (userInput != null) {
            if (userInput.equals("space") || userInput.equals("enter")) {
                nextRound();
            }
        }
    }

    /*
     * Creates a button for next round
     */
    public void CreateNextRoundButton() {
        // Add button
        Button nextRoundButton = new NextRoundButton(this::nextRound);
        addObject(nextRoundButton, 300, 340);
    }

    /*
     * Returns to game world 
     */
    public void nextRound() {
        Greenfoot.setWorld(new GameWorld(face, musicButton));
    }

}
