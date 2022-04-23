import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ControlScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ControlScreen extends World
{
    double timeControlsScreen = System.currentTimeMillis();

    /**
     * Constructor for objects of class ControlScreen.
     * 
     */
    public ControlScreen()
    {    
        // Create a new world with 600x600 cells with a cell size of 1x1 pixels.
        super(600, 600, 1); 

    }

    public void act()
    {

        Display display = new Display();
        addObject(display , 300, 525);

        display.setImage(new GreenfootImage("Press Space Bar to return to Game Menu" , 30, Color.WHITE,
        getColorAt(50, 50)));

        if (Greenfoot.isKeyDown("space")) //let User press "Space bar" to switch back to the Game Menu
        {
            World gameMenu = new GameMenu();
            Greenfoot.setWorld(gameMenu); 
            gameMenu.started();
            
        }
    }

}
