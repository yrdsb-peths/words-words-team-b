import greenfoot.*;

public class StartButton extends Button {

    public StartButton(Runnable action) {
        super(action);

        // Load and set image
        GreenfootImage image = new GreenfootImage("images/startButton.png");
        setImage(image);
    }

}