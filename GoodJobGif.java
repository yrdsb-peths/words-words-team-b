import greenfoot.*;

public class GoodJobGif extends Actor {
    GifImage gif = new GifImage("images/goodJob.gif");

    public void act(){
        setImage(gif.getCurrentImage());
    }
}
