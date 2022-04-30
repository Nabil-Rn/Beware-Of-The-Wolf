import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Retry_Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Retry_Button extends Actor
{   Farmer farmer;
    /**
     * Act - do whatever the Retry_Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Retry_Button() {
     farmer = new Farmer();
    }
    public void act()
    {
        if (Greenfoot.mouseMoved(this))
        {
            setImage("Retry_Button_Highlighted.png");
            Greenfoot.playSound("Menu_Selection.wav");
        }

        if (Greenfoot.mouseMoved(getWorld()))
        {
            setImage("Retry_Button.png");
        }

        if (Greenfoot.mouseClicked(this))
        {   
            int currentLevel = farmer.getCurrentLevel();
            
            if ( currentLevel == 1) {
                World currentWorld = getWorld();
                currentWorld.stopped();
                World level1 =  new Level1();
                Greenfoot.setWorld(level1);
                level1.started();
                
            }
            else if ( currentLevel == 2) {
                World currentWorld = getWorld();
                currentWorld.stopped();
                World level2 =  new Level2();
                Greenfoot.setWorld(level2);
                level2.started();
                
            }
            else if ( currentLevel == 3) {
                World currentWorld = getWorld();
                currentWorld.stopped();
                World level3 =  new Level3();
                Greenfoot.setWorld(level3);
                level3.started();
                
            }
        }
    }
}

