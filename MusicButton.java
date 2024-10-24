import greenfoot.*;

public class MusicButton extends Button {
    private Runnable action;
    public boolean isOff = false;

    GreenfootImage musicOn = new GreenfootImage("images/musicOn.png");
    GreenfootImage musicOff = new GreenfootImage("images/musicOff.png");

    public MusicButton (Runnable action) {
        super(action);
        setImage(musicOn);
    }

    public void setButton() {
        
        isOff = !isOff;

        if(isOff) {
            setImage(musicOff);
        } else {
            setImage(musicOn);
        }
    }



}