import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SplashScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SplashScreen extends World
{
    double timeWelcomeScreenCreation = System.currentTimeMillis();
    //Capture the duration time of the WelcomeScreen
    /**
     * Constructor for objects of class SplashScreen.
     * 
     */
    public SplashScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1); 
    }
    
     public void act()
    {
        int timerValue = (int) (System.currentTimeMillis() - timeWelcomeScreenCreation)/1000; // in terms of milliseconds
        //store timer in a int variable

        if (Greenfoot.isKeyDown("space")) //let User press "Space bar" to switch to the MainScreen
        {
            Greenfoot.setWorld(new GameMenu()); 
        }

        if (System.currentTimeMillis() >= (timeWelcomeScreenCreation + (3 * 1000))) //let Timer switch to the MainScreen
        {
            Greenfoot.setWorld(new GameMenu()); 
        }
    }
}
