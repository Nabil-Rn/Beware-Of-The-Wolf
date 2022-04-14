import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Wolf extends Actor
{

    /**
     * 
     */
    public Wolf()
    {
        turn(Greenfoot.getRandomNumber(360));
    }

    /**
     * Act - do whatever the Lobster wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        moveAround();
        eatFarmer();
        eatSheep();
        if (isGameLost()) {
            transitionToGameOver();
        }
    }

    /**
     * 
     */
    public void moveAround()
    {
        move(4);
        if (Greenfoot.getRandomNumber(10) == 1) {
            turn(Greenfoot.getRandomNumber(90) - 45);
        }
        if (isAtEdge()) {
            turn(180);
        }
    }

    /**
     * 
     */
    public void eatFarmer()
    {
        Actor farmer = getOneIntersectingObject(Farmer.class);
        if (farmer != null) {
            World world = getWorld();
            world.removeObject(farmer);
            //Greenfoot.playSound("Alien Creak1.wav");
        }
    }

    
    public void eatSheep()
    {
        Actor sheep = getOneIntersectingObject(Sheep.class);
        if (sheep != null) {
            World world = getWorld();
            world.removeObject(sheep);
        }
    }

    /**
     * 
     */
    public boolean isGameLost()
    {
        World world = getWorld();
        if (world.getObjects(Sheep.class).isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * 
     */
    public void transitionToGameOver()
    {
        World crabWorld = getWorld();
        getWorld().stopped();
        World gameOverWorld =  new  GameOverWorld();
        gameOverWorld.started();
        Greenfoot.setWorld(gameOverWorld);
    }
}
