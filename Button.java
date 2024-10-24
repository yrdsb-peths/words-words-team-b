import greenfoot.*;

public class Button extends Actor {
    private Runnable action;

    GreenfootSound clickSound = new GreenfootSound("sounds/mouseClick.mp3");

    public Button (Runnable action) {
        this.action = action;
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            
            clickSound.play();
            Greenfoot.delay(20);

            if (action != null) {
                action.run();
            }
        }
    }
}