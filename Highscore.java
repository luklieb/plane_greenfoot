import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;

/**
 * Erzeugt das "Grundgerüst" für das Anzeigen der Spieldaten am Ende eines Spiels.
 * Plane verwendet es. 
 * 
 * @author Markus M, Lukas L
 * @version 02.05.13
 */
public class Highscore extends Actor
{
   
    /**
     * Wenn, nach einer Kollision des Flugzeuges, Highscore von Plane mit der Methode 
     * createGameover() erstellt wird, dann bekommt Higscore von Plane bestimmte Parameter
     * (z.B. Spielstand, aktuelles Level,...) übermittelt, die dann in das Bild eingebaut werden.
     * 
     */
    public Highscore(String text)
    {
        displayHighscore(text);
    }

    public void act() 
    {
        
    }    
    
    /**
     * Erstellt ein durchsichtiges Bild, das mit Inhalt, gemäß der Plane-Methode createGameover()
     * gefüllt wird.
     */
    public void displayHighscore(String text)
    {
         GreenfootImage img;
        img = new GreenfootImage(500,150);
            img.setColor(Color.BLACK);
            img.setFont(img.getFont().deriveFont(Font.BOLD));
            img.setFont(img.getFont().deriveFont(50.0F));
            img.drawString(text,0,80);
            setImage(img);
            
            
            
            
            
           
            
    }
}
