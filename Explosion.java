import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Explosion wird erzeugt.
 * 
 * @author Lukas L, Markus M
 * @version 02.05.13
 */
public class Explosion extends Actor
{

    private GreenfootImage image;
    private int fade;
    private int expand = 3;
    private int i = 0;
    /**
     * Mittels act wird die "Animation" des Feuerballs ausgeführt.
     */
    public void act() 
    {
        explode();
     
    }  

    /**
     * Erzeugt das hinterlegte .jpg-Bild.
     */
    public Explosion ()
    {   
        image = getImage();
        
    }
    
    
    /**
     * Lässt das Bild ausdehnen, um eine Explosionseffekt zu erzeugen. Wenn der Feuerball 
     * zu groß wird, dann wird er aus der Welt entfernt.
     */
    public void explode()
    {
     if(getImage().getWidth() > 100) {
            getWorld().removeObject(this);
        }
        else {
            GreenfootImage img = new GreenfootImage(image);
            img.scale ( getImage().getWidth()+expand, getImage().getHeight()+expand );
            img.setTransparency(img.getTransparency()-100);
            setImage (img);
        }   
    }
}