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
            move(4);

        }
        else if (Greenfoot.isKeyDown("right") && stopFarmerMove == true)
        {
            move(-3);
            stopFarmerMove = false;
        }
        if (Greenfoot.isKeyDown("left") && stopFarmerMove == false) {
            move(-4);
        }
        else if (Greenfoot.isKeyDown("left") && stopFarmerMove == true)
        {
            move(3);
            stopFarmerMove = false;
        }
        if (Greenfoot.isKeyDown("up") && stopFarmerMove == false) {
            setLocation(getX(), getY()-4);
        }  
        else if (Greenfoot.isKeyDown("up") && stopFarmerMove == true)
        {
            setLocation(getX(), getY()+3);
            stopFarmerMove = false;
        }
        if (Greenfoot.isKeyDown("down") && stopFarmerMove == false) {
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
        Wall = getOneIntersectingObject(Gate.class);
        Actor Wall1;
        Wall1 = getOneIntersectingObject(Gate1.class);
        if (Wall != null) {
            stopFarmerMove = true;
            getWorld().showText("Hello world there is a gate", 200, 50);
        }
        else
        {

        }
        if (Wall1 != null) {
            stopFarmerMove = true;
        }
        else
        {

        }
    }

    public void pickSheep(){
        Actor Wall;
        Wall = getOneIntersectingObject(Gate.class);

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

