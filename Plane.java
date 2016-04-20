import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.awt.Color;
import java.awt.Font;

/**
 * Write a description of class Plane here.
 * 
 * @author Markus M, Lukas L
 * @version 02.05.16
 */
public class Plane extends Actor
{
    private int factor = 6; //damit kann man das Flugzeug verkleinern.
    private int speed = 8; //Setzt die Geschwindigkeit.
    private static final int climbStrength = 3; //Steiggeschwindigkeit.
    private static final int acceleration = 1; //Beschleunigung für den Fall.
    private int vSpeed = 0;                    // Momemtane vertikale Geschwindigkeit.
    private int count = 2;                       // wird für Rauch benötigt.
    int frames = 0;                             //wird für die Wartezeit während des Countdowns benötigt.
    int playOnce=0;
    
    
    /**
     * Act-Methode
     */
    public void act() 
    {
        createHigherLevel();
        delayedStart();

    }  

    /**
     * Konstruktor
     */

    public Plane()
    {
        setSize();

    }

    /**
     * Verkleinert das Flugzeug um einen bestimmten Faktor.
     */
    public void setSize()
    {
        getImage().scale(getImage().getWidth()/factor, getImage().getHeight()/factor);
    }

    /**
     * Setzt die Geschwindigkeit des horizontalen Fluges.
     */
    public void setSpeed()
    {
        setLocation(getX()+speed, getY());

    }

    /**
     * Damit kann man das Flugzeug auf und ab bewegen. Zudem wird die Steigung des Bildes angepasst.
     */
    public void upAndDown ()
    {
        if (Greenfoot.isKeyDown("space"))
        {
            climb();
            changeUpAngle();
        }

        else
        {
            fall();
            changeDownAngle();   
        }

    }

    /**
     * Methode des Steigfluges. Entspricht der des Fallens, nur das vSpeed jetzt eine negative
     * Zahl ist und somit immer mehr vom Y-Wert des Flugzeuges abzieht. (Koordinatenursprung ist oben!)
     */
    public void climb()
    {
        setVSpeed(-climbStrength);
        fall();

    }

    /**
     * climbStrentgh wird der Variablen vSpeed (Vertikale Geschwindigkeit) übergeben.
     */
    public void setVSpeed (int speed)
    {
        vSpeed = speed;
    }

    /**
     * vSpeed addiert von der Y-Koordinate die Steigung. Somit fällt das Flugzeug.
     * acceleration, also die Gravitation, wird zur vertikalen Geschwindigkeit addiert, damit
     * das Flugzeug schneller fällt.
     * Wird vSpeed von der Methode climb als ein negativer Wert übergeben, dann steigt das Flugzeug.
     */
    public void fall()
    {
        setLocation (getX(), getY() + vSpeed);
        vSpeed = vSpeed + acceleration;

    }

    /**
     * Erkennt eine Kollision, in dem die Methode die Farben abtastet. 
     * Wenn der 
     * Deswegen haben "Hindernisse" immer +1 im roten rgb-Farbraum gegenüber dem grünen rgb-Farbraum.
     * Dementsprechend muss der Hintergrund weniger rot als grün enthalten.
     */
    public void collision()
    {

        int red = getWorld().getColorAt(getX()+getImage().getWidth()/3, getY()+getImage().getHeight()/3).getRed();
        int green = getWorld().getColorAt(getX()+getImage().getWidth()/3, getY()-getImage().getHeight()/3).getGreen();

        if(red>green)
        {
            createExplosion();
            createGameover();
            getWorld().removeObject(this);
            Greenfoot.playSound("Explosion.mp3");

        }

    }

    /**
     * Passt die positive Steigung des Flugzeugbildes and die echte an.
     */
    public void changeUpAngle()
    {
        setRotation(getRotation()-2);
        if(getRotation()<340)
        {setRotation(340);}
    }

    /**
     * Passt die negative Steigung des Flugzeugbildes an die echte an.
     */
    public void changeDownAngle()
    {
        setRotation(getRotation()+2);
        if(getRotation()>20 && getRotation() < 21)
        {setRotation(20);}
    }

    /**
     * Erstellt ein Rauchbild alle zwei Durchläufe (Frames).
     */
    public void createSmoke()
    {
        count--;
        if (count == 0) {
            getWorld().addObject ( new Smoke(), getX(), getY());
            count = 2;}
    }

    /**
     * Erstellt die Explosion, wenn das Flugzeug gegen Decke/Boden fliegt.
     * Lässt die Explosion vor dem Flugzeug erscheinen.
     */
    public void createExplosion()
    {
        getWorld().addObject(new Explosion(), getX(),getY());
        getWorld().setPaintOrder(Explosion.class, Plane.class);
    }

    /**
     * Es wird gezählt, wie weit das Flugzeug fliegt.
     * score
     */
    public void countScore()
    {
        int score = 1;
        score--;
        if(score==0){
            MyWorld myWorld = (MyWorld) getWorld();
            myWorld.addScore();
            score = 1;

        }
    }

    /**
     * Verzögert den Start des Flugzeuges, um Countdown anzuzeigen. Die Zeit dazu bekommt sie von der World Methode returnTime,
     * damit nicht eine extra Zeit-variable in Plane angelegt werden muss. So vermeidet man Redudanzen.
     * Überprüft Level und Zeit, damit nur beim aller ersten Durchgang der Countdown und der verzögerte Start erscheint.
     */
    public void delayedStart()
    {
        MyWorld myWorld = (MyWorld) getWorld();
        frames++;

        if(myWorld.returnLevel()==1)
        {
            if(frames>myWorld.returnTime())
            {
                upAndDown();
                setSpeed();
                countScore();
                createSmoke();
                collision();
                
            }
            
  
        }
       

        if(myWorld.returnLevel()>1)
        {
            upAndDown();
            setSpeed();
            countScore();
            createSmoke();
            collision();
        }
    }

    /**
     * Wenn man in die Wände fliegt, bekommt man den Hinweis, dass das Spiel zu Ende sein, zudem sieht man seine Punktzahl.
     * returnScore() wird über die Welt zum auslesen der Punktzahl gebraucht.
     * Zudem wird ein Button erstellt, mit dem man, wenn man ihn anklickt, ein neues Spiel starten kann.
     */
    public void createGameover()
    {

        MyWorld myWorld = (MyWorld) getWorld();
        int highscoreCorrected = myWorld.returnSavedHighscore()+1;
        
        getWorld().addObject(new Highscore("Game Over"), getWorld().getWidth()/2+20, getWorld().getHeight()/2-60);
        getWorld().addObject(new Highscore("Highscore: "+highscoreCorrected), getWorld().getWidth()/2+20, getWorld().getHeight()/2-60+getImage().getHeight()*2);
        getWorld().addObject(new Highscore("Your Score: "+myWorld.returnScore()), getWorld().getWidth()/2+20, getWorld().getHeight()/2-60+getImage().getHeight()*4);
        getWorld().addObject(new Highscore("Your Level: "+myWorld.returnLevel()), getWorld().getWidth()/2+20, getWorld().getHeight()/2-60+getImage().getHeight()*6);
        getWorld().addObject(new Button(myWorld.returnSavedHighscore()),getWorld().getWidth()/2-50, getWorld().getHeight()-50);
    }

    /**
     * Sobald das Flugzeug über den rechten Rand hinausfliegt, wird automatisch das Level um "eins" nach oben gesetzt.
     * Dazu wird eine neue MyWorld erschaffen, die bestimmte Parameter übergeben bekommt.
     */
    public void createHigherLevel()
    {
        if(getX()>getWorld().getWidth()-50)
        {

            MyWorld myWorld = (MyWorld) getWorld();
            Greenfoot.setWorld(new MyWorld(myWorld.returnLevel()+1,myWorld.returnScore(), myWorld.returnSavedHighscore()));
        }
    }

}
