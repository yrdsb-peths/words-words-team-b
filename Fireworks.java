import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fireworks here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fireworks extends Actor
{
    GreenfootImage[] firework = new GreenfootImage[9];
    SimpleTimer animationTimer = new SimpleTimer();
    
    public Fireworks()
    {
        for(int i = 0; i < firework.length; i++)
        {
            firework[i] = new GreenfootImage("images/fireworks/tile" + i + ".png");
            firework[i].scale(150, 150);
        }
        
        animationTimer.mark();
        
        setImage(firework[0]);
    }
    
    public void act()
    {
        // Add your action code here.
        animateFirework();
    }
    
    int imageIndex = 0;
    public void animateFirework()
    {
        if(animationTimer.millisElapsed() < 150)
        {
            return;
        }
        animationTimer.mark();
        
        setImage(firework[imageIndex]);
        imageIndex = (imageIndex + 1) % firework.length;
    }
}
