import greenfoot.*;
import java.util.List;

public class HangmanBodyParts extends Hangman {

    GifImage lineGif;
    GreenfootImage linePic;
    GreenfootImage imageOne;
    boolean notImageOne;
    boolean gifFinished = false;

    public HangmanBodyParts(String bodyPart, boolean isLeft) {

        gifFinished = false;

        lineGif = new GifImage("redLine.gif");
        List<GreenfootImage> images = lineGif.getImages(); // get list of images
        imageOne = images.get(0); // get reference to first image

        linePic = new GreenfootImage("images/redLine.png");
        linePic.scale(150, 150);

        if (bodyPart == "body") {
            linePic.rotate(90);

            for (GreenfootImage img : images) {
                img.scale(150, 150); // scale all images
                img.rotate(90);
            }

        } else if (isLeft) {
            linePic.mirrorVertically();
            linePic.rotate(135);

            for (GreenfootImage img : images) {
                img.scale(150, 150); // scale all images
                img.mirrorVertically();
                img.rotate(135);
            }
        } else {
            linePic.rotate(45);

            for (GreenfootImage img : images) {
                img.scale(150, 150); // scale all images
                img.rotate(45);
            }
        }

        setImage(lineGif.getCurrentImage()); // set initial image
    }

    public void act() {
        if (gifFinished) {
            setImage(linePic);
        } else {
            playOnce();
        }

    }

    public void playOnce() {
        setImage(lineGif.getCurrentImage());

        if ((getImage() != imageOne) != notImageOne) // was there a change involving first image
        {
            notImageOne = !notImageOne; // record change
            // if setting first image,
            if (!notImageOne) {
                gifFinished = true;
            }
        }
    }
}
