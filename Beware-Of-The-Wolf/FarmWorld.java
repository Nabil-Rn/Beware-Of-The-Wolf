import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FarmWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FarmWorld extends World
{
    Sheep sheep = new Sheep();
    Wolf wolf = new Wolf();
    LineOfSight los = new LineOfSight(wolf, sheep);
    /**
     * Constructor for objects of class FarmWorld.
     * 
     */
    public FarmWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1); 
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Fence fence = new Fence();
        addObject(fence,280,280);
        Farmer farmer = new Farmer();
        addObject(farmer,101,73);
        Wolf wolf = new Wolf();
        addObject(wolf,508,377);
        Sheep sheep = new Sheep();
        addObject(sheep,511,87);
        Sheep sheep2 = new Sheep();
        addObject(sheep2,487,165);
        Sheep sheep3 = new Sheep();
        addObject(sheep3,521,259);
        addObject(los, 0, 0);
        ClosedFence closedFence = new ClosedFence();
        addObject(closedFence,280,387);
        Key key = new Key();
        addObject(key,88,243);
    }

    public LineOfSight getLOS () {
        return los;
    }
    public Sheep getSheep() {
        return sheep;
    }
}
