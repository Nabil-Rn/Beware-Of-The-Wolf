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
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1); 
        gameMenuMusic= new GreenfootSound("GameMenu_Faded.wav");
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
        addObject(start_Button,300,383);
        Exit_Button exit_Button = new Exit_Button();
        addObject(exit_Button,300,461);
    }
}
