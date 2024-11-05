import greenfoot.*;
import java.util.List;

public class HangmanHead extends Hangman {

    GifImage headGif;
    GreenfootImage headPic;
    GreenfootImage imageOne;
    boolean notImageOne;
    boolean gifFinished = false;

    public HangmanHead() {

        gifFinished = false;

        // head
        headGif = new GifImage("head.gif");
        headPic = new GreenfootImage("images/head.png");
        headPic.scale(150, 150);

        List<GreenfootImage> images = headGif.getImages(); // get list of images
        imageOne = images.get(0); // get reference to first image

        for (GreenfootImage img : images) {
            img.scale(150, 150); // scale all images
        }

        setImage(headGif.getCurrentImage()); // set initial image
    }

    public void act() {
        if (gifFinished) {
            setImage(headPic);
        } else {
            playOnce();
        }

    }

    public void playOnce() {
        setImage(headGif.getCurrentImage());

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
