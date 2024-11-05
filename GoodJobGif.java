import greenfoot.*;

public class GoodJobGif extends Actor {
    GifImage gif = new GifImage("images/goodJob.gif");

    public void act() {
        // Change the frame of gif 
        setImage(gif.getCurrentImage());
    }
}
