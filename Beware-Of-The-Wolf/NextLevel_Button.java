import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NextLevel_Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NextLevel_Button extends Actor
{
    /**
     * Act - do whatever the NextLevel_Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.mouseMoved(this))
        {
            setImage("NextLevel_Button_Highlighted.png");
            Greenfoot.playSound("Menu_Selection.wav");
        }

        if (Greenfoot.mouseMoved(getWorld()))
        {
            setImage("NextLevel_Button.png");
        }

        if (Greenfoot.mouseClicked(this))
        {   
            World currentWorld = getWorld();
            currentWorld.stopped();
            if (currentWorld == new Level1()) {
                World level1 =  new Level1();
                Greenfoot.setWorld(level1);
                level1.started();
            }
            if (currentWorld == new Level2()) {
                World level2 =  new Level2();
                Greenfoot.setWorld(level2);
                level2.started();
            }
            if (currentWorld == new Level3()) {
                World level3 =  new Level3();
                Greenfoot.setWorld(level3);
                level3.started();
            }
        }
    }
}
