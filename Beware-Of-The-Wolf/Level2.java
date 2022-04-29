import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends World
{
    // To dynamically calculate the time step duration
    private long lastFrameTimeMS;
    private double timeStepDuration;

    protected boolean isLevel2Completed;

    private GreenfootSound farmWorldMusic;
    /**
     * Constructor for objects of class Level2.
     * 
     */
    public Level2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1); 
        farmWorldMusic = new GreenfootSound("FarmWorld_Faded.wav"); 
        getLevelNumber();
        prepare();
    }

    public void act() {
        // Update time step duration
        timeStepDuration = (System.currentTimeMillis() - lastFrameTimeMS) / 1000.0;
        lastFrameTimeMS = System.currentTimeMillis();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Farmer farmer = new Farmer();
        addObject(farmer,101,73);

        Wolf wolf = new Wolf();
        addObject(wolf,508,377);

        Sheep sheep = new Sheep();
        addObject(sheep,243,76);
        Sheep sheep2 = new Sheep();
        addObject(sheep2,59,338);
        Sheep sheep3 = new Sheep();
        addObject(sheep3,507,195);
        Sheep sheep4 = new Sheep();
        addObject(sheep4, 420,500);

        Key key = new Key();
        addObject(key,88,243);

        Fence fence = new Fence();
        addObject(fence,300,300);

        closedTopFence closedTopFence = new closedTopFence();
        addObject(closedTopFence,300,189);

        closedBottomFence closedFence = new closedBottomFence();
        addObject(closedFence,300,407);

        LifeParameter lifeParameter = new LifeParameter();
        addObject(lifeParameter,512,564);
    }

    public void started()
    {
        farmWorldMusic.playLoop();
    }

    public void stopped()
    {
        farmWorldMusic.stop();
    }
    
    public int getLevelNumber() {
    return 2;
    }
}
