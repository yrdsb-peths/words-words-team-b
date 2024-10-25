import greenfoot.World;
import greenfoot.Color;

public class EndScreen extends World{
    /**
     * Check if user lost or won, then display correct text
     * If possible, create a function that restarts the game?
     */

    // boolean isWin = true;

    Label titleLabel; 
    
    public EndScreen() 
    {
        super(600, 400, 1);

        setBackground("images/black-background.jpg");
        titleLabel = new Label("YOU WON!", 60);
        addObject(titleLabel, getWidth() / 2, getHeight() / 2);
        
        fontColor();
        prepare();
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
    
    private void prepare()
    {
        Fireworks f1 = new Fireworks();
        Fireworks f2 = new Fireworks();
        addObject(f1, 100, 100);
        addObject(f2, 500, 100);
    }
}
