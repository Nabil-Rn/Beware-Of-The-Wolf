import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor
{
    private double score = 0;
    private Wolf wolf;
    /**
     * Act - do whatever the Score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        World currentWorld = getWorld();
        Level1 level1 = new Level1();
        Level2 level2 = new Level2();
        Level3 level3 = new Level3();

        List<SafeSheep> safesheep;
        if (level1 == currentWorld) {
            safesheep = level1.getObjects(SafeSheep.class);
            if (safesheep.size() > 0)
            {
                score += 50;
            }
        }
        else if (level2 == currentWorld) {
            safesheep = level2.getObjects(SafeSheep.class);
            if (safesheep.size() > 0)
            {
                score += 50;
            }
        }
        else if (level3 == currentWorld) {
            safesheep = level3.getObjects(SafeSheep.class);
            if (safesheep.size() > 0)
            {
                score += 50;
            }
        }

        if ( wolf.getNbaEatenSheep() > 0)
        {
            score -= 50;
        }

    }  

    public double getScore()
    {
        return score;
    }

}