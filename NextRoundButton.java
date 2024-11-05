import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class NextRoundButton extends Button {
    public NextRoundButton(Runnable action) {
        super(action); // calls super class constructor 

        // Load and set image
        GreenfootImage image = new GreenfootImage("images/greenButton.png");
        image.scale(200, 75);
        setImage(image);
    }
}
