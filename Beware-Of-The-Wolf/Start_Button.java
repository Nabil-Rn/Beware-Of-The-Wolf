import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Start_Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Start_Button extends Actor
{   
    
    /**
     * Act - do whatever the Start_Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.mouseMoved(this))
        {
            setImage("Start_Button_Highlighted.png");
            Greenfoot.playSound("Menu_Selection.wav");
        }

        if (Greenfoot.mouseMoved(getWorld()))
        {
            setImage("Start_Button.png");
        }

        if (Greenfoot.mouseClicked(this))
        {   
            World MyWorld = getWorld();
            getWorld().stopped();
            World farmWorld =  new FarmWorld();
            farmWorld.started();
            Greenfoot.setWorld(farmWorld);
        }
    }
}
