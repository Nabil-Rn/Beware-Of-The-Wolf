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
    Score score;
    double timeEndScreenCreation = System.currentTimeMillis();

    /**
     * Constructor for objects of class GameWonWorld.
     */
    public GameWonWorld()
    {
        super(600, 600, 1);
        gameWonMusic = new GreenfootSound("Lively Meadow (Song Loop) B 118.wav");
        showTextWithBigBlackFont("Level Completed", 100, 100);
        prepare();
        
        Score result = new Score();
        addObject(result, 300, 280);
        result.setImage(new GreenfootImage("You finished with a score of " + result.getScore() + ".",40, Color.WHITE, Color.GREEN));;

        Score feedback = new Score();
        addObject(feedback,300,325);
        String ranking = new String();
        if (result.getScore() >= 300 )
            ranking = " Professional player";
        else if (result.getScore() >= 200)
            ranking = " Intermediate player";
        else
            ranking = " Novice player";
        feedback.setImage(new GreenfootImage("You are a" + ranking + ".", 40, Color.WHITE, Color.GREEN));;
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
        NextLevel_Button nextLevel_Button = new NextLevel_Button();
        addObject(nextLevel_Button,300,390);
        
        Retry_Button retry_Button = new Retry_Button();
        addObject(retry_Button,300,460);
        
        Return_Button return_Button = new Return_Button();
        addObject(return_Button,300,530);
        
        Stars stars = new Stars();
        addObject(stars,300,180);

        
    }
}
