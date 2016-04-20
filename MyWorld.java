import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color; //Wird für die Farbe der Schrift und des Hintergrundes benötigt.
import java.awt.Font; //Wird für die Schrift benötigt.

/**
 * Write a description of class MyWorld here.
 * 
 * @author Markus M, Lukas L
 * @version 02.05.13
 */
public class MyWorld extends World
{
    private int rot = 160;
    private Plane plane;
    private Counter counter; //Benötigt für score Methode.
    private Countdown countdown;
    private int startX = 50;
    private int startY = 200;
    int savedScore; //Muss public sein, da Plane diese Variable benötigt.
    private int score;
    private int level;
    private int savedHighscore;

    public void act()
    {
        if(counter.returnScore()>=savedHighscore)
        {
            savedHighscore = counter.returnScore();
        }
    }

    /**
     * Dieser Konstruktor wird als aller erster aufgerufen. Er übergibt das erste "Level" den nächsten
     * Konstruktor. 
     * 
     */
    public MyWorld ()
    {    
        this(1,0,0);

    }

    /**
     * Dieser Konstruktor wird von Methode "higherLevel" in Plane aufgerufen. Methode erhöht Level
     * um 1 und übergibt den neuen Wert der neu erstellten Welt. (Ansonsten würder der Level-Wert
     * verloren gehen). Überprüft zudem, ob es das erste Level ist, falls ja, wird der Countdown
     * angezeigt, ansonsten wird er nicht erstellt.
     */
    public MyWorld (int lev, int sscr, int shscr)
    {    
        super(1500, 400, 1); 

        level=lev; //Die für myWord eingegebenen Werte werden in anderen Variablen abgespeichert.
        savedScore=sscr;
        savedHighscore=shscr;

        setColor(); //Methode zur Hintergrundfarbe wird aufgerufen.

        plane = new Plane(); //Erzeugt Flugzeug.
        addObject (plane, startX, startY);

        createOneFloor(); //Erzeugt den braunen Boden.
        createOneCeiling(); //Erzeugt die braune Decke.

        counter = new Counter(); //Die aktuelle Punktzahl wird links unten angezeigt.
        addObject (counter, getBackground().getWidth()-getBackground().getWidth()+70,getBackground().getHeight()-20);

        Level levelDisplay = new Level(level); //Das aktuelle Level wird rechts unten angezeigt.
        addObject (levelDisplay, getBackground().getWidth()-70, getBackground().getHeight()-20);

        setPaintOrder ( Plane.class, Smoke.class, Button.class, Highscore.class); //Flugzeug erscheint vor Rauch.

        if(level==1)
        {
            countdown = new Countdown();
            addObject (countdown, getWidth()/2, getHeight()/2);
            createIntroduction();
        }
    }

    /**
     * Hintergrundbild-Farbe wird gesetzt. Lokale Variablen helfen die Farbe schneller 
     * auszutauschen.
     */
    public void setColor() //muss von außen nicht erreichbar sein.
    {   int r = 160;
        int g = 190;
        int b = 142;
        int alpha = 150;
        getBackground().setColor(new Color(rot, g, b, alpha));
        getBackground().fill();
    }

    /**
     *Erstellt die Decke aus zufällig erzeugten, mit einer bestimmten Farbe ausgefüllten, Polygonen. 
     *Mit der if-Bedingung wird ein unmögliches Anfangszenario ausgeschlossen.
     */
    public void createOneCeiling()
    {
        int limitX = getWidth()/5;
        int limitY= getHeight()/2-10+level;

        int a = getWidth()-getWidth() + Greenfoot.getRandomNumber(limitX);
        int b = a + Greenfoot.getRandomNumber(limitX);
        int c = b + Greenfoot.getRandomNumber(limitX);
        int d = c + Greenfoot.getRandomNumber(limitX);
        int e = d + Greenfoot.getRandomNumber(limitX);
        int f = e + Greenfoot.getRandomNumber(limitX);
        int g = f + Greenfoot.getRandomNumber(limitX);
        int h = g + Greenfoot.getRandomNumber(limitX);

        int j = getHeight()-getHeight()+Greenfoot.getRandomNumber(limitY);
        int k = Greenfoot.getRandomNumber(limitY);
        int l = Greenfoot.getRandomNumber(limitY);
        int m = Greenfoot.getRandomNumber(limitY);
        int n = Greenfoot.getRandomNumber(limitY);
        int o = Greenfoot.getRandomNumber(limitY);
        int p = Greenfoot.getRandomNumber(limitY);
        int q = Greenfoot.getRandomNumber(limitY);

        if(j>startY)
        {j = startY-15;}

        if(k>startY)
        {k = startY-10;}

        int [] xs = {getWidth()-getWidth(), a, b, c, d, e, f, g, h, getWidth()};
        int [] ys = {0, j, k, l, m, n, o,180,150, 0};
        GreenfootImage ceiling = getBackground();
        ceiling.setColor(new Color(rot+1, 50, 60, 100));
        ceiling.fillPolygon(xs, ys, 10);

    }

    /**
     *Erstellt den Boden aus zufällig erzeugten, mit einer bestimmten Farbe ausgefüllten, Polygonen. 
     *Mit der if-Bedingung wird ein unmögliches Anfangszenario ausgeschlossen.
     * 
     */
    public void createOneFloor()
    {
        int limitX = getWidth()/5;
        int limitY = getHeight()/2-10;

        int a = getWidth()-getWidth() + Greenfoot.getRandomNumber(limitX);
        int b = a + Greenfoot.getRandomNumber(limitX);
        int c = b + Greenfoot.getRandomNumber(limitX);
        int d = c + Greenfoot.getRandomNumber(limitX);
        int e = d + Greenfoot.getRandomNumber(limitX);
        int f = e + Greenfoot.getRandomNumber(limitX);
        int g = f + Greenfoot.getRandomNumber(limitX);
        int h = g + Greenfoot.getRandomNumber(limitX);

        int j = getHeight()/2-level + Greenfoot.getRandomNumber(limitY);
        int k = getHeight()/2-level + Greenfoot.getRandomNumber(limitY);
        int l = getHeight()/2-level + Greenfoot.getRandomNumber(limitY);
        int m = getHeight()/2-level + Greenfoot.getRandomNumber(limitY);
        int n = getHeight()/2-level + Greenfoot.getRandomNumber(limitY);
        int o = getHeight()/2-level + Greenfoot.getRandomNumber(limitY);
        int p = getHeight()/2-level + Greenfoot.getRandomNumber(limitY);
        int q = getHeight()/2-level + Greenfoot.getRandomNumber(limitY);

        if(j<startY)
        {j = startY+15;}

        if(k<startY)
        {k = startY+10;}

        int [] xs = {getWidth()-getWidth(), a, b, c, d, e, f, g, h, getWidth()};
        int [] ys = {getHeight(), j, k, l, m, n, o, p, q, getHeight()};
        GreenfootImage floor = getBackground();
        floor.setColor(new Color(rot+1, 50, 60, 100));
        floor.fillPolygon(xs, ys, 10);
    }   

    /**
     * Führt die addScore Methode des Counters aus, damit Methode countScore in Klasse Plane auf die addScore 
     * Methode zugreifen kann.
     */ 
    public void addScore()
    {
        counter.addScore();
    }

    /**
     * Übernimmt aus Counter eine Wert (aktuelle Punktzahl), der dann wiederrum widergegeben wird.
     * Wird von Plane verwendet, die diesen Wert an Highscore übergibt, um, am Spielende, die aktuelle Punktzahl anzuzeigen.
     */
    public int returnScore()
    {
        int score;
        return score = counter.returnScore();
    }

    /**
     * Übernimmt aus Countdown einen Wert (dort eingestellte Zeit).
     * Wird von Plane benötigt, um den verzögerten Start (delayedStart()) mit dem Countdown abzugleichen.
     */
    public int returnTime()
    {
        int time;
        return time = countdown.returnTime();
    }

    /**
     * Gibt das aktuelle Level wider.
     * Wird von Plane benötigt, das den Wert an Highscore übergibt, um, am Spielende, das aktuelle Level anzuzeigen.
     */
    public int returnLevel()
    {
        return level;
    }

    /**
     * Gibt den gespeicherten Highscore wider.
     * Wird von Plane benötigt, das den Wert an Highsocre übergibt, um, am Spielende, den Highscore anzuzeigen.
     */
    public int returnSavedHighscore()
    {
        return savedHighscore;
    }

    /**
     * Erzeugt die Einleitung.
     */
    public void createIntroduction()
    {
        Introduction introduction1 = new Introduction("Your plane caught fire!");
        addObject(introduction1, getBackground().getWidth()-getBackground().getWidth()/2, getBackground().getHeight()-getBackground().getHeight()/2-50);

        Introduction introduction2 = new Introduction("Try to exit the cave");
        addObject(introduction2, getBackground().getWidth()-getBackground().getWidth()/2, getBackground().getHeight()-getBackground().getHeight()/2);

        Introduction introduction3 = new Introduction("Press Space to gain height");
        addObject(introduction3, getBackground().getWidth()-getBackground().getWidth()/2, getBackground().getHeight()-getBackground().getHeight()/2+70);

        Introduction introduction4 = new Introduction("Click Run once to play");
        addObject(introduction4, getBackground().getWidth()-getBackground().getWidth()/2, getBackground().getHeight()-getBackground().getHeight()/2+120);

    }
  
}