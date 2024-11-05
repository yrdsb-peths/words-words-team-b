import greenfoot.*;
import java.util.List;

public class HangmanBodyParts extends Hangman {

    /*
     * Constructor
     */
    public HangmanBodyParts(String bodyPart, boolean isLeft) {
        super("redLine.gif", "images/redLine.png");


        // Checks which part of body
        if (bodyPart == "body") {
            pic.rotate(90);

            for (GreenfootImage img : images) {
                img.scale(150, 150); // scale all images
                img.rotate(90);
            }

        } else if (isLeft) {
            pic.mirrorVertically();
            pic.rotate(135);

            for (GreenfootImage img : images) {
                img.scale(150, 150); // scale all images
                img.mirrorVertically();
                img.rotate(135);
            }
        } else {
            pic.rotate(45);

            for (GreenfootImage img : images) {
                img.scale(150, 150); // scale all images
                img.rotate(45);
            }
        }

        setImage(gif.getCurrentImage()); // set initial image
    }
}
