import greenfoot.*;
import java.util.List;

/*
 * Parent class for hangmanHead and HangmanBodyParts
 */
public class Hangman extends Actor {
    
    GifImage gif;
    GreenfootImage finalImage;
    GreenfootImage imageOne;

    boolean notImageOne;
    boolean gifFinished = false;
    
    List<GreenfootImage> images;
    
    boolean flagged = false;
    
    public Hangman(String gifFile, String imageFile)
    {
        gifFinished = false;
        
        // Gif 
        gif = new GifImage(gifFile);
        images = gif.getImages(); // get list of images
        imageOne = images.get(0); // get reference to first image
        
        // Image
        finalImage = new GreenfootImage(imageFile);
        finalImage.scale(153, 153);
        
    }
    
    //play the gif
    public void updateImage() {
        setImage(gif.getCurrentImage());

        if ((getImage() != imageOne) != notImageOne) // was there a change involving first image
        {
            notImageOne = !notImageOne; // record change

            if (!notImageOne) {
                gifFinished = true;
            }
        }
    }
    
    //animate the image
    public void act() {
        if (!gifFinished) {
            updateImage();
        } else if (!flagged){
            flagged = true;
            setImage(finalImage);
        }

    }
    
    public List<GreenfootImage> getImages()
    {
        return images;
    }
}
