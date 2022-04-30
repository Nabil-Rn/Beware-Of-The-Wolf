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

    Farmer farmer = (Farmer) new Farmer();
    Wolf wolf = (Wolf) new Wolf();
   
    //private Wolf wolf;
    //private Farmer farmer;
    int accumulatedPoints;
    
    /**
     * Constructor for objects of class GameWonWorld.
     */
    public GameWonWorld() {
        super(600, 600, 1);
        gameWonMusic = new GreenfootSound("Lively Meadow (Song Loop) B 118.wav");
        displayText();
        prepare();
        
    }
    
    public void displayText() {
        showTextWithBigBlackFont("Level Completed", 120, 100);
        /* 
        Calculate the accumulated points
        200 + nbSafeSheep*(+50) + nbEatenSheep*(-50)
        */
        accumulatedPoints = 200 + farmer.getGainedPoints() + wolf.getLostPoints();
        showText("You finished with a score of " + accumulatedPoints, 90, 300);
        String ranking = new String();
        if (accumulatedPoints > 300 )
            ranking = " Professional player";
        else if (accumulatedPoints >= 200 && accumulatedPoints <= 300)
            ranking = " Mediocre player";
        else if (accumulatedPoints < 200) 
            ranking = " Novice player";
        showText("You are a" + ranking + "!", 100, 360);
        
    }

    /**
     * 
     */
    public void showTextWithBigBlackFont(String message, int x, int y) {
        GreenfootImage bg = getBackground();
        Font font =  new Font(50);
        bg.setFont(font);
        bg.setColor(Color.BLACK);
        bg.drawString(message, x, y);
        
    }

    public void showText(String message, int x, int y) {
        GreenfootImage bg = getBackground();
        Font font =  new Font(30);
        bg.setFont(font);
        bg.setColor(Color.BLACK);
        bg.drawString(message, x, y);
        
    }

    public void started() {
        gameWonMusic.playLoop();
        
    }

    public void stopped() {
        gameWonMusic.stop();
        
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare() {   
        Retry_Button retry_Button = new Retry_Button();
        addObject(retry_Button,300,425);

        Return_Button return_Button = new Return_Button();
        addObject(return_Button,300,504);

        Stars stars = new Stars();
        addObject(stars,300,180);

    }

    public int getAccumulatedPoints() {
        return accumulatedPoints;
        
    }
}
