import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Medium_Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Medium_Button extends Actor
{
    /**
     * Act - do whatever the Medium_Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.mouseMoved(this))
        {
            setImage("Medium_Button_Highlighted.png");
            Greenfoot.playSound("Menu_Selection.wav");
        }

        if (Greenfoot.mouseMoved(getWorld()))
        {
            setImage("Medium_Button.png");
        }

        if (Greenfoot.mouseClicked(this))
        {   
            World currentWorld = getWorld();
            currentWorld.stopped();
            World lvl2 =  new Level2();
            Greenfoot.setWorld(lvl2);
            lvl2.started();
        }
    }
}
