import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;

/**
 * Zählt die Punkte des Spieles (Frames, die durchlaufen werden).
 * 
 * @author Markus M, Lukas L
 * @version 02.05.13
 */
public class Counter extends Actor
{
    private int score;
    private int frame=0;

    /**
     * Konstruktor für den Counter.
     */
    public Counter()
    {
        score=0;
        setImage(new GreenfootImage(100,30));
        update();

    }

    /**
     *Erhöht die Punktezahl um eins. Zudem zählt er einmalig die gespeicherte Punktezahl aus den Vorrunden
     *dazu (Methode savedScore()).
     */
    public void addScore()
    {
        score++;

        if(frame<1)
        {
            MyWorld myWorld = (MyWorld) getWorld();
            score = score + myWorld.savedScore;
        }

        update();
        frame++;
    }

    /**
     * Aktualisiert das Zähler-Bild links unten mit der aktuellen Punktezahl.
     */
    public void update()
    {
        GreenfootImage img = getImage();
        img.clear();
        img.setColor(Color.BLACK);
        img.setFont(img.getFont().deriveFont(Font.BOLD));
        img.setFont(img.getFont().deriveFont(16.0F));
        img.drawString("Score: " + score, 0, 20);

    }

    

    /**
     * Wird benötigt, um am Ende des Spiels den Highscore anzuzeigen.
     * Gibt die Punktezahl wider.
     */
    public int returnScore()
    {
        return score;
    }
}
