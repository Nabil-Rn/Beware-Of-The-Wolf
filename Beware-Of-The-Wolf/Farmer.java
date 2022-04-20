import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Farmer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Farmer extends Actor
{
    protected boolean sheepPicked;

    GreenfootImage farmer_animation;

    GifImage farmer_Up = new GifImage("farmer-up.gif");
    GifImage farmer_Down = new GifImage("farmer-down.gif");
    GifImage farmer_Right = new GifImage("farmer-right.gif");
    GifImage farmer_Left = new GifImage("farmer-Left.gif");

    GifImage pickSheep_Up = new GifImage("pickSheep-up.gif");
    GifImage pickSheep_Down = new GifImage("pickSheep-down.gif");
    GifImage pickSheep_Right = new GifImage("pickSheep-right.gif");
    GifImage pickSheep_Left = new GifImage("pickSheep-left.gif");

    /**
     * Act - do whatever the Farmer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public Farmer() {
    }

    public void act()
    {
        // Add your action code here.
        moveAround();
        collectKey();
        unlockFence();
        pickSheep();
        //farmerAnimation();
        if (isGameWon()) {
            transitionToGameWorld();
        }
    }

    /* public void farmerAnimation()
    {
    if (sheepPicked == false)
    {
    GifImage farmer_Up = new GifImage("farmer-up.gif");
    GifImage farmer_Down = new GifImage("farmer-down.gif");
    GifImage farmer_Right = new GifImage("farmer-right.gif");
    GifImage farmer_Left = new GifImage("farmer-Left.gif");
    }

    if (sheepPicked == true)
    {
    farmer_Up = new GifImage("pickSheep-up.gif");
    farmer_Down = new GifImage("pickSheep-down.gif");
    farmer_Right =new  GifImage("pickSheep-right.gif");
    farmer_Left = new GifImage("pickSheep-left.gif");

    }
    } */

    public void moveAround()
    {   int originalX = getX();
        int originalY = getY();
        if (Greenfoot.isKeyDown("left"))
        {   
            setLocation(getX() - 4, getY());
            if (!sheepPicked) 
                farmer_animation = farmer_Left.getCurrentImage();
            else
                farmer_animation = pickSheep_Left.getCurrentImage();
            setImage(farmer_animation);
        }
        if (Greenfoot.isKeyDown("right"))
        {   
            setLocation(getX() + 4, getY());
            if (!sheepPicked) 
                farmer_animation = farmer_Right.getCurrentImage();
            else
                farmer_animation = pickSheep_Right.getCurrentImage();
            setImage(farmer_animation);
        }
        if (Greenfoot.isKeyDown("up")) 
        {   
            setLocation(getX(), getY() - 4);
            if (!sheepPicked) 
                farmer_animation = farmer_Up.getCurrentImage();
            else
                farmer_animation = pickSheep_Up.getCurrentImage();
            setImage(farmer_animation);
        }
        if (Greenfoot.isKeyDown("down")) 
        {   
            setLocation(getX(), getY() + 4 );
            if (!sheepPicked) 
                farmer_animation = farmer_Down.getCurrentImage();
            else
                farmer_animation = pickSheep_Down.getCurrentImage();
            setImage(farmer_animation);
        }
        if (isTouching(Fence.class))
        {   setLocation(originalX, originalY);
            Greenfoot.playSound("bump.wav");
        }

    }

    public void pickSheep()
    {
        Actor sheep = getOneIntersectingObject(Sheep.class);
        if (sheep != null) {
            World world = getWorld();
            world.removeObject(sheep);
            Greenfoot.playSound("sheep_cry.wav");
            sheepPicked = true;
        }
    }
    
    public void collectKey()
    {
        Actor key = getOneIntersectingObject(Key.class);
        if (key != null) {
            World world = getWorld();
            world.removeObject(key);
            Greenfoot.playSound("Collect_Key.wav");
        }
    }
    
    public void unlockFence() 
    { Actor closedFence = getOneIntersectingObject(ClosedFence.class);
        if (closedFence != null) {
            World world = getWorld();
            world.removeObject(closedFence);
            world.addObject(new OpenFence(),280,387);
            Greenfoot.playSound("Unlock_Fence.wav"); 
        }
    }

    public boolean isGameWon()
    {
        World world = getWorld();
        if (world.getObjects(Sheep.class).isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }

    public void transitionToGameWorld()
    {
        World MyWorld = getWorld();
        getWorld().stopped();
        World gameWonWorld =  new GameWonWorld();
        //gameWonWorld.started();
        Greenfoot.setWorld(gameWonWorld);
    }

}

