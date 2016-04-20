import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Ein interaktiver Button, mit dem man ein neues Spiel starten kann, nachdem man verloren hat.
 * 
 * @author Lukas L., Markus M.
 * @version 02.05.13
 */
public class Button extends Actor

{
    Button button;  //deklariert die Variable button als ein Objekt der Button-Klasse.
    private int savedHighscore;
    MyWorld myWorld = (MyWorld) getWorld();  
  
    public void act() 
    {
       click();
    }    
    
    /**
     * Nachdem eine Kollision erfolgt ist, wird ein Button erstellt. Dieser bekommt von Plane
     * die aktuelle Variable savedHighscore von myWorld. Dieser Wert wird in savedHighscore hier 
     * zwischen gespeichert.
     */
    public Button(int shscr)
    {
       savedHighscore = shscr;
       getImage().scale(getImage().getWidth()/3, getImage().getHeight()/3);
      
    }
    
    /**
     *Wenn man auf den Button klick, wird eine neue MyWorld erschaffen. 
     *(1 Level, 0 Punkte, gerade abgespeicherter Wert in savedHighscore). Diese Werte werden der 
     *neuen myWorld übergeben.
     */
    public void click()
    {
         if (Greenfoot.mouseClicked(button)==true)
        {Greenfoot.setWorld(new MyWorld(1, 0, savedHighscore));} 
    }
}
