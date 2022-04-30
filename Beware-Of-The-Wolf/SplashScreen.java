import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SplashScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SplashScreen extends World
{   
    //Capture the duration time of the SplashScreen
    double timeSplashScreenCreation = System.currentTimeMillis();
    
    /**
     * Constructor for objects of class SplashScreen.
     * 
     */
    public SplashScreen() {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1); 
        
    }

    public void act() {
        pressSpace();
        timerCount();

    }
    public void pressSpace() {
        if (Greenfoot.isKeyDown("space")) //let User press "Space bar" to switch to the MainScreen
        {
            GameMenu gameMenu = new GameMenu();
            Greenfoot.setWorld(gameMenu); 
            gameMenu.started();

        }
    }

    public void timerCount() {
        
        //Store timer in a int variable
        int timerValue = (int) (System.currentTimeMillis() - timeSplashScreenCreation)/1000; 
        // in terms of milliseconds
        if (System.currentTimeMillis() >= (timeSplashScreenCreation + (3 * 1000))) //let Timer switch to the MainScreen
        { 
            World gameMenu = new GameMenu();
            Greenfoot.setWorld(gameMenu); 
            gameMenu.started();
        }
    }
}
