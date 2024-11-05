import greenfoot.*;

public class SelectButton extends Button {
    public SelectButton(Runnable action) {
        super(action); // calls super class constructor 

        // Load and set image
        GreenfootImage image = new GreenfootImage("images/selectButton.png");
        image.scale(90, 40);
        setImage(image);
    }

}