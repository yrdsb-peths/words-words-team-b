import greenfoot.*;

public class Gallow extends Actor {

    public Gallow() {
        // Load and set image
        GreenfootImage image = new GreenfootImage("images/gallow.png");
        image.mirrorHorizontally();
        image.scale(250, 500);
        setImage(image);
    }
}
