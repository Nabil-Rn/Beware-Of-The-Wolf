import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Farmer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Farmer extends Actor
{
    boolean stopFarmerMove = false;
    
    GreenfootImage farmer;
    GifImage farmer_Up = new GifImage("farmer-up.gif");
    GifImage farmer_Down = new GifImage("farmer-down.gif");
    GifImage farmer_Right = new GifImage("farmer-right.gif");
    GifImage farmer_Left = new GifImage("farmer-Left.gif");
    
    GreenfootImage pickSheep;
    GifImage pickSheep_Up = new GifImage("pickSheep-up.gif");
    GifImage pickSheep_Down = new GifImage("pickSheep-down.gif");
    GifImage pickSheep_Right = new GifImage("pickSheep-right.gif");
    GifImage pickSheep_Left = new GifImage("pickSheep-left.gif");
    
    
    /**
     * Act - do whatever the Farmer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public void act()
    {
        // Add your action code here.
        moveCharacter();
        hitWall();
        pickSheep();
        if (isGameWon()) {
            //transitionToGameWorld();
        }
        else
        {
            transitionToGameWorld();
        }
    }

    public void moveCharacter()
    {
        if (Greenfoot.isKeyDown("right") && stopFarmerMove == false) {
            farmer = farmer_Right.getCurrentImage();
            setImage(farmer);
            move(4);
        }
        else if (Greenfoot.isKeyDown("right") && stopFarmerMove == true)
        {
            move(-3);
            stopFarmerMove = false;
        }
        if (Greenfoot.isKeyDown("left") && stopFarmerMove == false) {
            farmer = farmer_Left.getCurrentImage();
            setImage(farmer);
            move(-4);
        }
        else if (Greenfoot.isKeyDown("left") && stopFarmerMove == true)
        {
            move(3);
            stopFarmerMove = false;
        }
        if (Greenfoot.isKeyDown("up") && stopFarmerMove == false) {
            farmer = farmer_Up.getCurrentImage();
            setImage(farmer);
            setLocation(getX(), getY()-4);
        }  
        else if (Greenfoot.isKeyDown("up") && stopFarmerMove == true)
        {
            setLocation(getX(), getY()+3);
            stopFarmerMove = false;
        }
        if (Greenfoot.isKeyDown("down") && stopFarmerMove == false) {
            farmer = farmer_Down.getCurrentImage();
            setImage(farmer);
            setLocation(getX(), getY()+4);
        }    
        else if (Greenfoot.isKeyDown("up") && stopFarmerMove == true)
        {
            setLocation(getX(), getY()-3);
            stopFarmerMove = false;
        }

    }

    public void hitWall()
    {
        Actor Wall;
        Wall = getOneIntersectingObject(Fence.class);
        if (Wall != null) {
            stopFarmerMove = true;
            getWorld().showText("Hello world there is a gate", 200, 50);
        }
        else
        {

        }
    }

    public void pickSheep(){
        Actor Wall;
        Wall = getOneIntersectingObject(ClosedFence.class);

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

