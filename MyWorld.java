import greenfoot.*;

public class MyWorld extends World {
    public MyWorld() {
        super(600, 400, 1);

        Hangman hangmanHead = new HangmanHead();
        addObject(hangmanHead, 150, 150);
    }
}
