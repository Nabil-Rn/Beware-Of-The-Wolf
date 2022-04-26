import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Return_Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Return_Button extends Actor
{
    /**
     * Act - do whatever the Return_Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.mouseMoved(this))
        {
            setImage("Return_Button_Highlighted.png");
            Greenfoot.playSound("Menu_Selection.wav");
        }

        if (Greenfoot.mouseMoved(getWorld()))
        {
            setImage("Return_Button.png");
        }

        if (Greenfoot.mouseClicked(this))
        {   
            World currentWorld = getWorld();
            currentWorld.stopped();
            World gameMenu =  new GameMenu();
            Greenfoot.setWorld(gameMenu);
            gameMenu.started();
        }
    }
}
