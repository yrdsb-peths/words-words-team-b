import greenfoot.*;

public class SelectButton extends Button {
    private Runnable action;

    public SelectButton (Runnable action) {
        super(action);

        GreenfootImage image = new GreenfootImage("images/selectButton.png");
        image.scale(90, 40);
        setImage(image);
    }

}