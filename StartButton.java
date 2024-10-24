import greenfoot.*;

public class StartButton extends Button {
    private Runnable action;

    public StartButton (Runnable action) {
        super(action);

        GreenfootImage image = new GreenfootImage("images/startButton.png");
        setImage(image);
    }

}