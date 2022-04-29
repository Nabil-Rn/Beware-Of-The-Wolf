import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Easy_Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Easy_Button extends Actor
{
    /**
     * Act - do whatever the Easy_Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.mouseMoved(this))
        {
            setImage("Easy_Button_Highlighted.png");
            Greenfoot.playSound("Menu_Selection.wav");
        }

        if (Greenfoot.mouseMoved(getWorld()))
        {
            setImage("Easy_Button.png");
        }

        if (Greenfoot.mouseClicked(this))
        {   
            World currentWorld = getWorld();
            currentWorld.stopped();
            World lvl1 =  new Level1();
            Greenfoot.setWorld(lvl1);
            lvl1.started();
        }
    }
}
