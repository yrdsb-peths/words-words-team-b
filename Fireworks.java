import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Fireworks extends Actor {
    GreenfootImage[] firework = new GreenfootImage[9];
    SimpleTimer animationTimer = new SimpleTimer();

    int imageIndex = 0;

    public Fireworks() {
        // Load images
        for (int i = 0; i < firework.length; i++) {
            firework[i] = new GreenfootImage("images/fireworks/tile" + i + ".png");
            firework[i].scale(150, 150);
        }

        animationTimer.mark();

        setImage(firework[0]);
    }

    public void act() {
        animateFirework();
    }

    public void animateFirework() {
        // Display a frame every 150 ms
        if (animationTimer.millisElapsed() < 150) {
            return;
        }
        animationTimer.mark();

        setImage(firework[imageIndex]);
        imageIndex = (imageIndex + 1) % firework.length;
    }
}
