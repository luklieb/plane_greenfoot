import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;


/**
 * Diese Klasse dient nicht zur Veränderung der eigentlichen Spiellevel. Sie ist lediglich eine Hilfe,
 * um das derzeitige Level rechts unten in der World anzuzeigen!
 * Das neue Level wird in Plane mit der Methode createHigherLevel() erzeugt.
 * 
 * @author Lukas L, Markus M
 * @version 02.05.13
 */
public class Level extends Actor
{

 
    public void act() 
    {
        
        
    }    
    
    /**
     * Erzeugt die Level-Anzeige rechts unten. Das aktuelle Level bekommt dieser Konstruktor von der Welt 
     * übergeben.
     */
    public Level(int level)
    { 
        
        setImage(new GreenfootImage(100,30));
        levelUpdate(level);
    }
    
    /**
     * Jedes Mal, wenn eine neue myWorld erschaffen wird, bekommt diese Methode das aktuelle Level mitgeteilt.
     * Daraus wird dann ein transparentes Bild mit entsprechenden schwarzen Inhalt erzeugt.
     */
    public void levelUpdate(int level)
    {
        
        GreenfootImage img = getImage();
        img.setColor(Color.BLACK);
        img.setFont(img.getFont().deriveFont(Font.BOLD));
        img.setFont(img.getFont().deriveFont(16.0F));
        img.drawString("Level: " + level, 0, 20);
    }
}
