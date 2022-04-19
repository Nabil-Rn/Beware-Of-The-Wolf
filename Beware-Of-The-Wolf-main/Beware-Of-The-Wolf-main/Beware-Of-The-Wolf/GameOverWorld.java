// WARNING: This file is auto-generated and any changes to it will be overwritten
import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class GameOverWorld extends World
{
    
    private GreenfootSound gameOverMusic;

    /**
     * Constructor for objects of class GameOverWorld.
     */
    public GameOverWorld()
    {
        super(600, 600, 1);
        //gameOverMusic = new GreenfootSound("GameOver_ Cropped");        
        //showTextWithBigBlackFont("Game Over", 180, 200);
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
    
    public void started()
    {
        //gameOverMusic.playLoop();
    }
    
     public void stopped()
    {
        //gameOverMusic.stop();
    }
}
