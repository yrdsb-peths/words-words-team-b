import greenfoot.*;

public class MusicButton extends Button {
    private Runnable action;
    public boolean isOff = false;

    GreenfootImage musicOn = new GreenfootImage("images/musicOn.png");
    GreenfootImage musicOff = new GreenfootImage("images/musicOff.png");
    GreenfootSound music = new GreenfootSound("sounds/backgroundMusic.mp3");

    public MusicButton (Runnable action) {
        super(action);
        setImage(musicOn);
        music.play();
        music.playLoop();
    }

    public void setButton() {
        
        isOff = !isOff;

        if(isOff) {
            setImage(musicOff);
            music.pause();
        } else {
            setImage(musicOn);
            music.play();
        }
    }

}