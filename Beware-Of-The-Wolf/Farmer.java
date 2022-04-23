import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Farmer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Farmer extends Actor
{
    protected boolean isKeyCollected;
    protected boolean isFenceUnlocked;
    protected boolean isSheepPicked;

    static int nbSheep= 0;
    static int safeSheep = 0;

    GreenfootImage farmer_animation;
    GifImage farmer_Up = new GifImage("farmer-up.gif");
    GifImage farmer_Down = new GifImage("farmer-down.gif");
    GifImage farmer_Right = new GifImage("farmer-right.gif");
    GifImage farmer_Left = new GifImage("farmer-left.gif");

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
        depositSheep();
        if (isGameWon()) {
            transitionToGameWorld();
        }
    }
    public void moveAround()
    {   int originalX = getX();
        int originalY = getY();
        if (Greenfoot.isKeyDown("left"))
        {   
            setLocation(getX() - 4, getY());
            if (!isSheepPicked) 
                farmer_animation = farmer_Left.getCurrentImage();
            else
                farmer_animation = pickSheep_Left.getCurrentImage();
            setImage(farmer_animation);
        }
        if (Greenfoot.isKeyDown("right"))
        {   
            setLocation(getX() + 4, getY());
            if (!isSheepPicked) 
                farmer_animation = farmer_Right.getCurrentImage();
            else
                farmer_animation = pickSheep_Right.getCurrentImage();
            setImage(farmer_animation);
        }
        if (Greenfoot.isKeyDown("up")) 
        {   
            setLocation(getX(), getY() - 4);
            if (!isSheepPicked) 
                farmer_animation = farmer_Up.getCurrentImage();
            else
                farmer_animation = pickSheep_Up.getCurrentImage();
            setImage(farmer_animation);
        }
        if (Greenfoot.isKeyDown("down")) 
        {   
            setLocation(getX(), getY() + 4 );
            if (!isSheepPicked) 
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

    public void collectKey()
    {
        Actor key = getOneIntersectingObject(Key.class);
        if (key != null) {
            World world = getWorld();
            world.removeObject(key);
            Greenfoot.playSound("Collect_Key.wav");
            isKeyCollected = true;
        }
    }

    public void unlockFence() 
    {   Actor closedFence = getOneIntersectingObject(ClosedFence.class);
        if (closedFence != null) {
            World world = getWorld();
            world.removeObject(closedFence);
            world.addObject(new OpenFence(),300,407);
            Greenfoot.playSound("Unlock_Fence.wav"); 
            isFenceUnlocked= true;

        }
    }

    public void pickSheep()
    {  if (isKeyCollected && isFenceUnlocked && !isSheepPicked) {
            Actor sheep = getOneIntersectingObject(Sheep.class);
            if (Greenfoot.isKeyDown("space") && sheep != null) {
                World world = getWorld();
                world.removeObject(sheep);
                Greenfoot.playSound("sheep_cry.wav");
                isSheepPicked = true;
                nbSheep += 1;
            }
        }
    }

    public void depositSheep() {
        if (isSheepPicked){
            Actor openFence = getOneIntersectingObject(OpenFence.class);
            if (openFence != null) {
                World world = getWorld();
                isSheepPicked = false;
                world.addObject(new Sheep(),300, 300); //We have to figure out how to randomly position Sheep inside of Fence
                Greenfoot.playSound("Deposit_Sheep.wav");
                safeSheep += 1;
            }
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

