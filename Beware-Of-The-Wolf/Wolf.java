import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Wolf extends Actor
{
    GreenfootImage wolf;
    GifImage wolf_Up = new GifImage("wolf-up.gif");
    GifImage wolf_Down = new GifImage("wolf-down.gif");
    GifImage wolf_Right = new GifImage("wolf-right.gif");
    GifImage wolf_Left = new GifImage("wolf-left.gif");

    /**
     * 
     */
    public Wolf()
    {

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
        int originalX = getX();
        int originalY = getY();
        int randNb, repeatNb;
        //move(4);

        if (Greenfoot.getRandomNumber(100)<5)
        {
            randNb = Greenfoot.getRandomNumber(2);
            // repeatNb

            if (randNb == 0) 
            {
                repeatNb = Greenfoot.getRandomNumber(60);

                for( int i =0; i <= 40 + repeatNb; i++)
                {
                    //turn(45);
                    //setRotation(0);
                    //wolf = wolf_Right.getCurrentImage();
                    wolf = wolf_Right.getImages().get(0);
                    setImage(wolf);
                    if (Greenfoot.getRandomNumber(100)<50)
                    {
                        setLocation(getX() - 1, getY());
                    }
                }
            }

            if (randNb == 1) 
            {
                repeatNb = Greenfoot.getRandomNumber(60);

                for( int i =0; i <= 40 + repeatNb; i++)
                {
                    //turn(90);
                    //setRotation(90);
                    //wolf = wolf_Left.getCurrentImage();
                    wolf = wolf_Left.getImages().get(0);
                    setImage(wolf);
                    if (Greenfoot.getRandomNumber(100)<50)
                    {
                        setLocation(getX() + 1, getY());
                    }
                }
            }

            if (randNb == 2) 
            {
                repeatNb = Greenfoot.getRandomNumber(20);

                for( int i =0; i <= 4 + repeatNb; i++)
                {
                    //turn(180);
                    //setRotation(180);
                    //wolf = wolf_Down.getCurrentImage();
                    wolf = wolf_Down.getImages().get(0);
                    setImage(wolf);
                    setLocation(getX(), getY() + 25);
                }
            }

            if (randNb == 3) 
            {
                repeatNb = Greenfoot.getRandomNumber(4);

                for( int i =0; i <= 4 + repeatNb; i++)
                {
                    //turn(275);
                    //setRotation(275);
                    //wolf = wolf_Up.getCurrentImage();
                    wolf = wolf_Up.getImages().get(0);
                    setImage(wolf);
                    setLocation(getX(), getY() - 25);
                }
            }
            /*if (isAtEdge() ||isTouching(Fence.class) ) {
            turn(180);
            }*/
            if (isTouching(Fence.class))
            {   setLocation(originalX, originalY);
                //Greenfoot.playSound("bump.wav");
            }
        }

    }

    public void eatFarmer()
    {
        Actor farmer = getOneIntersectingObject(Farmer.class);
        if (farmer != null) {
            World world = getWorld();
            world.removeObject(farmer);
            //Greenfoot.playSound("");
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
        if (world.getObjects(Sheep.class).isEmpty() || world.getObjects(Farmer.class).isEmpty()) {
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
