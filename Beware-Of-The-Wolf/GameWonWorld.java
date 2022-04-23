// WARNING: This file is auto-generated and any changes to it will be overwritten
import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class GameWonWorld extends World
{

    private GreenfootSound gameWonMusic;
    
    /**
     * Constructor for objects of class GameWonWorld.
     */
    public GameWonWorld()
    {
        super(600, 600, 1);
        gameWonMusic = new GreenfootSound("Lively Meadow (Song Loop) B 118.wav");
        //showTextWithBigBlackFont("You Win!", 180, 200);
    }

    /**
     * 
     */
    public void showTextWithBigBlackFont(String message, int x, int y)
    {
        GreenfootImage bg = getBackground();
        Font font =  new Font(50);
        bg.setFont(font);
        bg.setColor(Color.BLACK);
        bg.drawString(message, x, y);
    }
    
    public void stars(){
        
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
