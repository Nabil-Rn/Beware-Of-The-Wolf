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
        gameOverMusic = new GreenfootSound("GameOver_ Cropped.wav");        
        //showTextWithBigBlackFont("Game Over", 180, 200);
        prepare();
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
        gameOverMusic.playLoop();
    }

    public void stopped()
    {
        gameOverMusic.stop();
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Retry_Button retry_Button = new Retry_Button();
        addObject(retry_Button,300,425);
        Return_Button return_Button = new Return_Button();
        addObject(return_Button,300,504);
    }
}
