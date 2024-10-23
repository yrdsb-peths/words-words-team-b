import greenfoot.*;

public class MusicButton extends Button {
    private Runnable action;
    public boolean isOff = false;

    public MusicButton (Runnable action) {
        super(action);

        GreenfootImage musicOn = new GreenfootImage("images/musicOn.png");
        GreenfootImage musicOff = new GreenfootImage("images/musicOff.png");

        setImage(musicOn);
    }

    



}