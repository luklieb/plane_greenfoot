import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;

/**
 * Erzeugt die schwarzen, großen Zahlen ganz am Anfang am Spiel.
 * Es sind durchsichtige Bilder, die mit schwarzen Zahlen gefüllt werden.
 * 
 * @author Lukas L., Markus M.
 * @version 02.05.13
 */
public class Countdown extends Actor
{
    private int frames = 0; //wird für die Zählung der act-Frames benötigt.
    private static int threeSeconds = 48; //Festlegung in Frames, wie lange drei Sek sein sollen.
    GreenfootImage img; //deklariert für ganze Klasse Variable img als Bild.
    private static int fadeFactor = 15; //Wert, wie schnell Schrift ausbleicht, verschwindet. Bleibt immer gleich.

    /**
     * Konstruktor. Legt die Bildgröße fest.
     */
    public Countdown()
    {
        
        setImage(new GreenfootImage(150,250));
        

    }

    /**
     * Erhöht mit jedem Druchlauf (Frame) die Variable frame. Führt Methoden aus um zu zählen.
     * 
     */
    public void act() 
    {
        frames++;
        countThree();
        countTwo();
        countOne();
        removeNumber();

    }    

    /**
     * Legt die Schriftfarbe, -größe, etc. fest. Erstellt das Passende Bild zur Zahl.
     * Lässt die Zahl ausbleichen.
     */
    public void countThree()
    {

        if(frames==1)
        {
            img = getImage();
            img.clear();
            img.setColor(Color.BLACK);
            img.setFont(img.getFont().deriveFont(Font.BOLD));
            img.setFont(img.getFont().deriveFont(200.0F));

            img.setTransparency(255);
            img.drawString("3", 0, 200);
            
            Greenfoot.playSound("Countdown2.wav");

        }

        if(frames>1&&frames<threeSeconds/3)
        {img.setTransparency(img.getTransparency()-fadeFactor);
        }

    }
    
    /**
     * Legt die Schriftfarbe, -größe, etc. fest. Löscht das vorherige Bild. 
     * Erstellt das neue,passende Bild zur Zahl.
     * Lässt die Zahl ausbleichen.
     */
    public void countTwo()
    {
        if(frames==15)
        {
            img = getImage();
            img.clear();
            img.setTransparency(255);
            img.setColor(Color.BLACK);
            img.setFont(img.getFont().deriveFont(Font.BOLD));
            img.setFont(img.getFont().deriveFont(200.0F));
            img.drawString("2", 0, 200);
            
            Greenfoot.playSound("Countdown2.wav");

        }

        if(frames>threeSeconds/3&&frames<threeSeconds/3*2)
        { img.setTransparency(img.getTransparency()-fadeFactor);
        }
    }
    
    
    /**
     * Legt die Schriftfarbe, -größe, etc. fest. Löscht das alte Bild.
     * Erstellt das neue, passende Bild zur Zahl.
     * Lässt die Zahl ausbleichen.
     */
    public void countOne()
    {
        if(frames==30)
        {
            img = getImage();
            img.clear();
            img.setTransparency(255);
            img.setColor(Color.BLACK);
            img.setFont(img.getFont().deriveFont(Font.BOLD));
            img.setFont(img.getFont().deriveFont(200.0F));
            img.drawString("1", 0, 200);
            
            Greenfoot.playSound("Countdown2.wav");
        }

        if(frames>threeSeconds/3*2&&frames<threeSeconds)
        { img.setTransparency(img.getTransparency()-fadeFactor);
        }
    }
    
    /**
     * Löscht den Inahlt des Bilds mit der Nummer.
     */
    public void removeNumber()
    {
        if(frames==threeSeconds)
        {
            img.clear();
            
        }
    }
    
    /**
     * Gibt die variable threeSeconds als int wider.
     * (Damit weiß die Methode delayedStart in Plane wie lange sie den Start hinauszögern muss.
     */
    public int returnTime()
    {
        return threeSeconds;
    }
    
    
}
