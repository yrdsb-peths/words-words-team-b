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
            finalImage.rotate(90);

            for (GreenfootImage img : images) {
                img.scale(150, 150); // scale all images
                img.rotate(90);
            }

        } else if (isLeft) {
            finalImage.mirrorVertically();
            finalImage.rotate(135);

            for (GreenfootImage img : images) {
                img.scale(150, 150); // scale all images
                img.mirrorVertically();
                img.rotate(135);
            }
        } else {
            finalImage.rotate(45);

            for (GreenfootImage img : images) {
                img.scale(150, 150); // scale all images
                img.rotate(45);
            }
        }

        setImage(gif.getCurrentImage()); // set initial image
    }
}
