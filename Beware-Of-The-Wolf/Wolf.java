import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Wolf extends Actor
{
    GreenfootImage wolf_animation;
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
        if (Greenfoot.getRandomNumber(100) < 5)
        {
            randNb = Greenfoot.getRandomNumber(13);
            // repeatNb
            
            if (randNb == 0) 
            {
                repeatNb = Greenfoot.getRandomNumber(60);
                for( int i =0; i <= 4 + repeatNb; i++)
                {
                    //wolf_animation = wolf_Right.getImages().get(0);
                    if (Greenfoot.getRandomNumber(100) < 7)
                    {
                        //turn(0);
                        //setRotation(0);
                        setLocation(getX() - 10, getY());
                        wolf_animation = wolf_Right.getCurrentImage();
                        setImage(wolf_animation);
                    }
                }
            }
            if (randNb == 1) 
            {
                repeatNb = Greenfoot.getRandomNumber(60);
                for( int i =0; i <= 4 + repeatNb; i++)
                {
                    //wolf_animation = wolf_Left.getImages().get(0);
                    if (Greenfoot.getRandomNumber(100) < 7)
                    {
                        //turn(180);
                        //setRotation(180);
                        setLocation(getX() + 10, getY());
                        wolf_animation = wolf_Left.getCurrentImage();
                        setImage(wolf_animation);
                    }
                }
            }
            if (randNb == 2) 
            {
                repeatNb = Greenfoot.getRandomNumber(60);
                for( int i =0; i <= 4 + repeatNb; i++)
                {
                    //wolf_animation = wolf_Down.getImages().get(0);
                    if (Greenfoot.getRandomNumber(100) < 20)
                    {
                        //turn(270);
                        //setRotation(270);
                        setLocation(getX(), getY() + 20);
                        wolf_animation = wolf_Down.getCurrentImage();
                        setImage(wolf_animation);
                    }
                }
            }
            if (randNb == 3) 
            {
                repeatNb = Greenfoot.getRandomNumber(60);

                for( int i =0; i <= 4 + repeatNb; i++)
                {
                    //wolf_animation = wolf_Up.getImages().get(0);
                    if (Greenfoot.getRandomNumber(100) < 20)
                    {
                        //turn(90);
                        //setRotation(90);
                        setLocation(getX(), getY() - 20);
                        wolf_animation = wolf_Up.getCurrentImage();
                        setImage(wolf_animation);
                    }
                }
            }
            if ( atWorldEdge() || isTouching(Fence.class) )
            {   setLocation(originalX, originalY);
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
            Greenfoot.playSound("wolf-attack.wav");
        }
    }

    public boolean atWorldEdge()
    {
        if(getX() < 30 || getX() > getWorld().getWidth() - 30)
            return true;
        if(getY() < 30 || getY() > getWorld().getHeight() - 30)
            return true;
        else
            return false;
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
