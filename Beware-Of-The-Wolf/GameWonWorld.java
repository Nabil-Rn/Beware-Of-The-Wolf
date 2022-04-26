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
