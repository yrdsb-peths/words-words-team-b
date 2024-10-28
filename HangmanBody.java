import greenfoot.*;
import java.util.List;

public class HangmanBody extends Hangman {

    GifImage lineGif; 
    GreenfootImage linePic;
    GreenfootImage imageOne;
    boolean notImageOne;
    boolean gifFinished = false; 

    public HangmanBody() {

        gifFinished = false; 

        // head 
        lineGif = new GifImage("redLine.gif");
        linePic = new GreenfootImage("images/redLine.png");
        linePic.scale(75,75);

        List<GreenfootImage> images = lineGif.getImages(); // get list of images
        imageOne = images.get(0); // get reference to first image

        for (GreenfootImage img : images) {
            img.scale(75, 75); // scale all images
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
            notImageOne = ! notImageOne; // record change
            // if setting first image,
            if (! notImageOne) {
                gifFinished = true;
            } 
        }
    }
}
