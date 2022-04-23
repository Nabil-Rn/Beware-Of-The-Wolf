import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Controls_Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Controls_Button extends Actor
{   
    /**
     * Act - do whatever the Controls_Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.mouseMoved(this))
        {
            setImage("Controls_Button_Highlighted.png");
            Greenfoot.playSound("Menu_Selection.wav");
        }

        if (Greenfoot.mouseMoved(getWorld()))
        {
            setImage("Controls_Button.png");
        }

        if (Greenfoot.mouseClicked(this))
        {   
            World currentScreen = getWorld();
            currentScreen.stopped();
            World controls =  new ControlScreen();
            Greenfoot.setWorld(controls);
            
        }

    }
}
