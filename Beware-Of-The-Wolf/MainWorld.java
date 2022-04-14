// WARNING: This file is auto-generated and any changes to it will be overwritten
import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class MainWorld extends World
{
    private GreenfootSound gameWonMusic;
    
    /**
     * Constructor for objects of class GameWonWorld.
     */
    public MainWorld()
    {
        super(560, 560, 1);
        gameWonMusic = new GreenfootSound("JoyRide.wav");
    }

    
    
    public void started()
    {
        gameWonMusic.playLoop();
    }
    
     public void stopped()
    {
        gameWonMusic.stop();
    }
}
