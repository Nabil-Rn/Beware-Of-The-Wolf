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
    protected boolean isSheepPicked;
    protected boolean isTopFenceUnlocked;
    protected boolean isBottomFenceUnlocked;
    protected boolean isLeftFenceUnlocked;
    protected boolean isRightFenceUnlocked;

    static int nbSheep;
    static int safeSheep;
    static int pickedSheep;
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
        safeSheep = 0 ;
        pickedSheep = 0;
    }

    public void act()
    {
        // Add your action code here.
        moveAround();
        collectKey();
        unlockFence();
        pickSheep();
        depositSheep();
        //GameWon();
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
    {   
        Actor closedTopFence = getOneIntersectingObject(closedTopFence.class);
        if (closedTopFence != null && isKeyCollected && !isSheepPicked) {
            World world = getWorld();
            world.removeObject(closedTopFence);
            world.addObject(new openTopFence(),300,189);
            Greenfoot.playSound("Unlock_Fence.wav"); 
            isTopFenceUnlocked= true;
        }
        Actor closedBottomFence = getOneIntersectingObject(closedBottomFence.class);
        if (closedBottomFence != null && isKeyCollected && !isSheepPicked) {
            World world = getWorld();
            world.removeObject(closedBottomFence);
            world.addObject(new openBottomFence(),300,407);
            Greenfoot.playSound("Unlock_Fence.wav"); 
            isBottomFenceUnlocked= true;
        }
        Actor closedLeftFence = getOneIntersectingObject(closedLeftFence.class);
        if (closedLeftFence != null && isKeyCollected && !isSheepPicked){
            World world = getWorld();
            world.removeObject(closedLeftFence);
            world.addObject(new openLeftFence(), 185,300); 
            Greenfoot.playSound("Unlock_Fence.wav");
            isLeftFenceUnlocked = true;
        }
        Actor closedRightFence = getOneIntersectingObject(closedRightFence.class);
        if (closedRightFence != null && isKeyCollected && !isSheepPicked){
            World world = getWorld();
            world.removeObject(closedRightFence);
            world. addObject(new openRightFence(),415,300);
            Greenfoot.playSound("Unlock_Fence.wav");
            isRightFenceUnlocked = true;
        }
    }

    public void pickSheep()
    {  if (isKeyCollected && (isTopFenceUnlocked ||isBottomFenceUnlocked ||isLeftFenceUnlocked ||isRightFenceUnlocked)) {
            Actor sheep = getOneIntersectingObject(Sheep.class);
            if (Greenfoot.isKeyDown("space") && sheep != null) {
                World world = getWorld();
                world.removeObject(sheep);
                Greenfoot.playSound("sheep_cry.wav");
                isSheepPicked = true;
                pickedSheep += 1;
                
            }
        }
    }

    public void depositSheep() {
        if (isSheepPicked){
            Actor openBottomFence = getOneIntersectingObject(openBottomFence.class);
            if (openBottomFence != null) {
                World world = getWorld();
                isSheepPicked = false;
                world.addObject(new SafeSheep(),300, 300); //We have to figure out how to randomly position Sheep inside of Fence
                Greenfoot.playSound("Deposit_Sheep.wav");
                safeSheep += 1;
                pickedSheep -= 1;
            }
            Actor openTopFence = getOneIntersectingObject(openTopFence.class);
            if (openTopFence != null) {
                World world = getWorld();
                isSheepPicked = false;
                world.addObject(new SafeSheep(),380, 380); //We have to figure out how to randomly position Sheep inside of Fence
                Greenfoot.playSound("Deposit_Sheep.wav");
                safeSheep += 1;
                pickedSheep -= 1;
            }
            Actor openLeftFence = getOneIntersectingObject(openLeftFence.class);
            if (openLeftFence != null){
                World world = getWorld();
                isSheepPicked = false;
                world.addObject(new SafeSheep(), 350,350);
                Greenfoot.playSound("Deposit_Sheep.wav");
                safeSheep += 1;
                pickedSheep -= 1;
            }
            Actor openRightFence = getOneIntersectingObject(openRightFence.class);
            if (openRightFence != null){
                World world = getWorld();
                isSheepPicked = false;
                world.addObject(new SafeSheep(), 250,250);
                Greenfoot.playSound("Deposit_Sheep.wav");
                safeSheep += 1;
                pickedSheep -= 1;
            }
        }
    }
    
    public void GameWon()
    {
        if (nbSheep == 0 && safeSheep >= 1 && pickedSheep == 0){
            transitionToGameWonWorld();
        } else
        if (nbSheep == 0 && safeSheep == 0 && pickedSheep == 0){
            transitionToGameOverWorld();
        }
    }

    public void transitionToGameWonWorld()
    {
        World MyWorld = getWorld();
        getWorld().stopped();
        World gameWonWorld =  new GameWonWorld();
        gameWonWorld.started();
        Greenfoot.setWorld(gameWonWorld);
    }
    
    public void transitionToGameOverWorld()
    {
        World MyWorld = getWorld();
        getWorld().stopped();
        World gameOverWorld =  new GameOverWorld();
        gameOverWorld.started();
        Greenfoot.setWorld(gameOverWorld);
    }
    
    public void positionSheepInsideFence() {
        //new posX = 120
    }
    
    public static int getsafeSheep() {
        return safeSheep;
    }
    
}

