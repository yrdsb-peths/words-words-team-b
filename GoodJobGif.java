import greenfoot.*;

public class GoodJobGif extends Actor {
    private GifImage gif = new GifImage("images/goodJob.gif");

    public void act() {
        setImage(gif.getCurrentImage());
    }
}
