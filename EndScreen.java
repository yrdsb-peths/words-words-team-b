import greenfoot.World;
import greenfoot.Color;

public class EndScreen extends World{
    Label titleLabel; 
    
    public EndScreen() 
    {
        super(600, 400, 1);

        setBackground("images/black-background.jpg");
        // if win
        titleLabel = new Label("YOU WON!", 60);
        fireworks();
        // else if lost
        // titleLabel = new Label("YOU LOST", 60);
        
        
        addObject(titleLabel, getWidth() / 2, getHeight() / 2);
        
        fontColor();
    }
    
    public void act()
    {
        // Add your action code here.

    }
    
    private void fontColor()
    {
        titleLabel.setFillColor(Color.WHITE);
        titleLabel.setLineColor(Color.WHITE);
        
    }
    
    private void fireworks()
    {
        Fireworks f1 = new Fireworks();
        Fireworks f2 = new Fireworks();
        addObject(f1, 100, 150);
        addObject(f2, 500, 150);
    }
}
