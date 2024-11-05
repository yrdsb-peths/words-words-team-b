import greenfoot.*;

public class BackButton extends Button {
    public BackButton(Runnable action) {
        super(action); // calls super class constructor 

        GreenfootImage image = new GreenfootImage("images/backButton.png");
        setImage(image);
    }

}