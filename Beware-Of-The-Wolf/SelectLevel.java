import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SelectLevel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SelectLevel extends World
{
    private GreenfootSound continueMusic;

    /**
     * Constructor for objects of class SelectLevel.
     * 
     */
    public SelectLevel()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1); 
        
        continueMusic= new GreenfootSound("GameMenu_Faded.wav");
        
        prepare();
    }
    
    public void started()
    {
        continueMusic.playLoop();
    }

    public void stopped()
    {
        continueMusic.stop();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Easy_Button easy_Button = new Easy_Button();
        addObject(easy_Button,300,365);
        
        Medium_Button medium_Button = new Medium_Button();
        addObject(medium_Button,300,432);
        
        Hard_Button hard_Button = new Hard_Button();
        addObject(hard_Button,300,499);
    }
}
