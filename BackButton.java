import greenfoot.*;

public class BackButton extends Button {
    private Runnable action;

    public BackButton (Runnable action) {
        super(action);

        GreenfootImage image = new GreenfootImage("images/backButton.png");
        setImage(image);
    }

}