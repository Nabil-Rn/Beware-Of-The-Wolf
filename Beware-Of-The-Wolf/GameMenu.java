import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameMenu extends World
{
    private GreenfootSound gameMenuMusic;

    /**
     * Constructor for objects of class GameMenu.
     * 
     */
    public GameMenu()
    {    
        // Create a new world with 600x600 cells with a cell size of 1x1 pixels.
        super(600, 600, 1); 
        
        //Menu Music
        gameMenuMusic= new GreenfootSound("GameMenu_Faded.wav");
        
        //Game Menu Screen
        prepare();
    }

    public void started()
    {
        gameMenuMusic.playLoop();
    }

    public void stopped()
    {
        gameMenuMusic.stop();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Start_Button start_Button = new Start_Button();
        addObject(start_Button,170,365);
        Controls_Button controls_Button = new Controls_Button();
        addObject(controls_Button,170,432);
        Exit_Button exit_Button = new Exit_Button();
        addObject(exit_Button,170,499);
    
    }
}
