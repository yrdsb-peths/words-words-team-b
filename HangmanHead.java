import greenfoot.*;

public class HangmanHead extends Hangman {
    /*
     * Constructor
     */
    public HangmanHead() {
        super("head.gif", "images/head.png");

        for (GreenfootImage img : images) {
            img.scale(150, 150); // scale all images
        }

        setImage(gif.getCurrentImage()); // set initial image
    }
}
