import greenfoot.*;

public class BackButton extends Button {
    private Runnable action;

    /*
     * Constructor
     */
    public BackButton (Runnable action) {
        super(action); // Calling constructor from super class

        // Set Image 
        GreenfootImage image = new GreenfootImage("images/backButton.png");
        setImage(image);
    }

}