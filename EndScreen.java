import greenfoot.*;

public class EndScreen extends World {
    Label titleLabel;

    Label wordLabel;

    Face face;
    Button musicButton;

    public EndScreen(Face face, Button musicButton, char[] trueWord) {
        super(600, 400, 1);
        this.face = face;
        this.musicButton = musicButton;

        // Update high score
        if (GameWorld.getScore() > GameWorld.getHighScore()) {
            GameWorld.setHighScore(GameWorld.getScore());
        }

        Label highScoreLabel = new Label(GameWorld.getHighScore(), 40);
        addObject(highScoreLabel, 50, 50);

        setBackground("images/black-background.jpg");

        // Display title label and the correct word
        titleLabel = new Label("YOU LOST", 60);
        addObject(titleLabel, getWidth() / 2, getHeight() / 2);

        wordLabel = new Label("", 30);
        wordLabel(trueWord);
        addObject(wordLabel, getWidth() / 2, 300);

        // Back to menu button
        Button menuButton = new BackButton(this::backToMenu);
        addObject(menuButton, 550, 350);

        fontColor();
        fireworks();

        GameWorld.resetScore();
    }

    public void backToMenu() {
        Greenfoot.setWorld(new TitleScreen());
    }

    private void wordLabel(char[] word) {
        // Add a space between each character in the word for spacing
        String wordString = "";
        for (int i = 0; i < word.length; i++) {
            wordString += word[i];
        }

        wordLabel.setValue("Correct word: " + wordString);
    }

    private void fontColor() {
        titleLabel.setFillColor(Color.WHITE);
        titleLabel.setLineColor(Color.WHITE);
    }

    private void fireworks() {
        Fireworks f1 = new Fireworks();
        Fireworks f2 = new Fireworks();
        addObject(f1, 100, 150);
        addObject(f2, 500, 150);
    }
}
