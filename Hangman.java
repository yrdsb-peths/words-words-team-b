import greenfoot.*;
import java.util.List;

/*
 * Parent class for hangmanHead and HangmanBodyParts
 */
public class Hangman extends Actor {
    
    GifImage gif;
    GreenfootImage pic;
    GreenfootImage imageOne;

    boolean notImageOne;
    boolean gifFinished = false;
    
    List<GreenfootImage> images;
    
    public Hangman(String gifFile, String imageFile)
    {
        gifFinished = false;
        
        // Gif 
        gif = new GifImage(gifFile);
        images = gif.getImages(); // get list of images
        imageOne = images.get(0); // get reference to first image
        
        // Image
        pic = new GreenfootImage(imageFile);
        pic.scale(150, 150);
        
    }
    
    //play the gif
    public void playOnce() {
        setImage(gif.getCurrentImage());

        if ((getImage() != imageOne) != notImageOne) // was there a change involving first image
        {
            notImageOne = !notImageOne; // record change

            if (!notImageOne) {
                gifFinished = true;
            }
        }
    }
    
    public void act() {
        if (gifFinished) {
            setImage(pic);
        } else {
            playOnce();
        }

    }
    
    public List<GreenfootImage> getImages()
    {
        return images;
    }
}
