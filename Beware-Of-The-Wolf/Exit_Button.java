import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Exit_Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Exit_Button extends Actor
{
    /**
     * Act - do whatever the Exit_Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.mouseMoved(this))
        {
            setImage("Exit_Button_Highlighted.png");
            Greenfoot.playSound("Menu_Selection.wav");
        }

        if (Greenfoot.mouseMoved(getWorld()))
        {
            setImage("Exit_Button.png");
        }

        if (Greenfoot.mouseClicked(this))
        {   
            //World MyWorld = getWorld();
            //getWorld().stopped();
            System.exit(0);
        }
    }
}
