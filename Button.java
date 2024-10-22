import greenfoot.*;

public class Button extends Actor {
    private Runnable action;

    public Button (Runnable action) {
        this.action = action;
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            if (action != null) {
                action.run();
            }
        }
    }
}