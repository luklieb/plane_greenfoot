import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;

/**
 * Write a description of class Introduction here.
 * 
 * @author Lukas L, Markus M 
 * @version 02.05.13
 */
public class Introduction extends Actor
{
    /**
     * Act - do whatever the Introduction wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        getWorld().removeObject(this);
    }    

    public Introduction(String text)
    {
        showIntroduction(text);
    }

    public void showIntroduction(String text)
    {
        GreenfootImage img;
        img = new GreenfootImage(550,150);
        img.setColor(Color.BLACK);
        img.setFont(img.getFont().deriveFont(Font.BOLD));
        img.setFont(img.getFont().deriveFont(40.0F));
        img.drawString(text,0,80);
        setImage(img);

    }
}
