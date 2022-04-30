import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sheep here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sheep extends Actor
{
    GreenfootImage sheep_animation;
    GifImage sheep_Up = new GifImage("sheep-up.gif");
    GifImage sheep_Down = new GifImage("sheep-down.gif");
    GifImage sheep_Right = new GifImage("sheep-right.gif");
    GifImage sheep_Left = new GifImage("sheep-left.gif");

    
    /**
     * Act - do whatever the Sheep wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        moveAround();
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
            randNb = Greenfoot.getRandomNumber(13); // repeatNb

            if (randNb == 0) 
            {
                repeatNb = Greenfoot.getRandomNumber(60);
                for( int i =0; i <= 4 + repeatNb; i++)
                {
                    //sheep_animation = sheep_Right.getImages().get(0);
                    if (Greenfoot.getRandomNumber(100) < 10)
                    {
                        setLocation(getX() - 5, getY());
                        sheep_animation = sheep_Right.getCurrentImage();
                        setImage(sheep_animation);
                    }
                }
            }
            if (randNb == 1) 
            {
                repeatNb = Greenfoot.getRandomNumber(60);
                for( int i =0; i <= 4 + repeatNb; i++)
                {
                    //sheep_animation = sheep_Left.getImages().get(0);
                    if (Greenfoot.getRandomNumber(100) < 10)
                    {
                        setLocation(getX() + 5, getY());
                        sheep_animation = sheep_Left.getCurrentImage();
                        setImage(sheep_animation);
                    }
                }
            }
            if (randNb == 2) 
            {
                repeatNb = Greenfoot.getRandomNumber(60);
                for( int i =0; i <= 4 + repeatNb; i++)
                {
                    //sheep_animation = sheep_Down.getImages().get(0);
                    if (Greenfoot.getRandomNumber(100) < 10)
                    {
                        setLocation(getX(), getY() + 5);
                        sheep_animation = sheep_Down.getCurrentImage();
                        setImage(sheep_animation);
                    }
                }
            }
            if (randNb == 3) 
            {
                repeatNb = Greenfoot.getRandomNumber(60);

                for( int i =0; i <= 4 + repeatNb; i++)
                {
                    //sheep_animation = sheep_Up.getImages().get(0);
                    if (Greenfoot.getRandomNumber(100) < 10)
                    {
                        setLocation(getX(), getY() - 5);
                        sheep_animation = sheep_Up.getCurrentImage();
                        setImage(sheep_animation);
                    }
                }
            }
            if ( atWorldEdge() || isTouching(Fence.class) )
            {   setLocation(originalX, originalY);
            }

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
}
