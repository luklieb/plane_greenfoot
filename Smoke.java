import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Erzeugt den Rauch, der aus dem Flugzeug kommmt.
 * 
 * @author Lukas L, Markus M
 * @version 02.05.13
 */
public class Smoke extends Actor
{
    private GreenfootImage image; // orginales Bild.
    private int fade;              //Schnelligkeit des Ausblassens.

    /**
     * Act-Methode
     */
    public void act() 
    {
        shrink();
    }  

    /**
     * Konstruktor
     */
    public Smoke()
    {
        image = getImage();
        fade = Greenfoot.getRandomNumber(4) + 1; 
        if (fade > 3) {
            fade = fade - 2;
        }
    }

    /**
     * Lässt den Rauch schrumpfen.
     */
    private void shrink()
    {
        if(getImage().getWidth() < 10) {
            getWorld().removeObject(this);
        }
        else {
            GreenfootImage img = new GreenfootImage(image);
            img.scale ( getImage().getWidth()-fade, getImage().getHeight()-fade );
            setImage (img);
        }
    }

}
