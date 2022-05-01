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

    static int nbEatenSheep;
    public Wolf(){
        nbEatenSheep = 0;
        int lostPoints;
    }

    /**
     * Act - do whatever the Lobster wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        moveAround();
        eatFarmer();
        eatSheep();
        //getWorld().showText("Number of Eaten Sheep: "+ nbEatenSheep, 300, 300);
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
        move(2);

        if (Greenfoot.getRandomNumber(100) < 5)
        {
            randNb = Greenfoot.getRandomNumber(13); // repeatNb

            if (randNb == 0) 
            {
                repeatNb = Greenfoot.getRandomNumber(60);
                for( int i =0; i <= 4 + repeatNb; i++)
                {
                    //wolf_animation = wolf_Right.getImages().get(0);
                    if (Greenfoot.getRandomNumber(100) < 7)
                    {
                        setRotation(0);
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
                        setRotation(180);
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
                        setRotation(90);
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
                        setRotation(270);
                        wolf_animation = wolf_Up.getCurrentImage();
                        setImage(wolf_animation);
                    }
                }
            }

        }
        if (isTouching(Fence.class) || atWorldEdge() )
        {   setLocation(originalX, originalY);

        }
    }

    public void eatFarmer()
    {
        Actor farmer = getOneIntersectingObject(Farmer.class);
        if (farmer != null) {
            World world = getWorld();
            world.removeObject(farmer);
        }
    }

    public void eatSheep()
    {
        Actor sheep = getOneIntersectingObject(Sheep.class);
        if (sheep != null) {
            World world = getWorld();
            world.removeObject(sheep);
            Greenfoot.playSound("wolf-attack.wav");
            nbEatenSheep++;          
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
        //nbEatenSheep = getWorld().getObjects(Sheep.class).size();
        if ( nbEatenSheep ==3  || getWorld().getObjects(Farmer.class).isEmpty()) {
            //If Wolf ate 3 Sheep (LifeParameter = 0), it's game over OR if Wolf ate Farmer, it's instant game over
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
        World currentLevel = getWorld();
        currentLevel.stopped();
        World gameOverWorld =  new GameOverWorld();
        gameOverWorld.started();
        Greenfoot.setWorld(gameOverWorld);
    }

    public static int getNbEatenSheep() { //count how many sheep the Wolf ate
        return nbEatenSheep;
    }

    public int getLostPoints(){ // punish -50pts for every sheep Wolf ate
        return nbEatenSheep*(-50);
    }
}
