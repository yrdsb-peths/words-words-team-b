import greenfoot.*;

public class Button extends Actor {
    private Runnable action;
    private GreenfootSound clickSound = new GreenfootSound("sounds/mouseClick.mp3");

    /*
     * Constructor
     */
    public Button(Runnable action) {
        this.action = action;
    }

    /*
     * act method for all buttons
     */
    public void act() {
        // Checks if user clicked the button
        if (Greenfoot.mouseClicked(this)) {

            // Plays the mouse clicking sound and delays to match the sound
            clickSound.play();
            Greenfoot.delay(20);

            // runs the action
            if (action != null) {
                action.run();
            }
        }
    }
}