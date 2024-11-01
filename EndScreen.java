import greenfoot.*;

public class EndScreen extends World{
    Label titleLabel; 
    Face face;
    Button musicButton;
    
    public EndScreen(Face face, Button musicButton) 
    {
        super(600, 400, 1);
        this.face = face;
        this.musicButton = musicButton;
        
        int highScore;
        
        if(GameWorld.getScore() > GameWorld.getHighScore())
        {
           GameWorld.setHighScore(GameWorld.getScore());
        }
        
        Label highScoreLabel = new Label(GameWorld.getHighScore(), 40);
        addObject(highScoreLabel, 50, 50);
        
        setBackground("images/black-background.jpg");
        
        titleLabel = new Label("YOU LOST", 60);
        addObject(titleLabel, getWidth() / 2, getHeight() / 2);
        
        fontColor();
        
        fireworks();
        
        GameWorld.resetScore();
    }
    
    public void CreateNextRoundButton()
    {
        // Add buttons 
        Button nextRoundButton = new NextRoundButton(this::nextRound);
        addObject(nextRoundButton, 300, 340);
    }
    
    public void nextRound()
    {
        Greenfoot.setWorld(new GameWorld(face, musicButton));
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
