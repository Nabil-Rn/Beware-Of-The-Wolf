import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hard_Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hard_Button extends Actor
{
    /**
     * Act - do whatever the Hard_Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.mouseMoved(this))
        {
            setImage("Hard_Button_Highlighted.png");
            Greenfoot.playSound("Menu_Selection.wav");
        }

        if (Greenfoot.mouseMoved(getWorld()))
        {
            setImage("Hard_Button.png");
        }

        if (Greenfoot.mouseClicked(this))
        {   
            World currentWorld = getWorld();
            currentWorld.stopped();
            World lvl3 =  new Level3();
            Greenfoot.setWorld(lvl3);
            lvl3.started();
        }
    }
}
