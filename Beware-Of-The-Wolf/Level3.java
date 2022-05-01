import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level3 extends World
{
    private GreenfootSound farmWorldMusic;
    
    Farmer farmer = (Farmer) new Farmer();
    /**
     * Constructor for objects of class Level3.
     * 
     */
    public Level3() {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1); 
        farmWorldMusic = new GreenfootSound("FarmWorld_Faded.wav");  
        farmer.setCurrentLevel(3);
        prepare();
        
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare() {
        Farmer farmer = new Farmer();
        addObject(farmer,101,73);

        Wolf wolf = new Wolf();
        addObject(wolf,527,293);
        Wolf wolf1 = new Wolf();
        addObject(wolf1, 110,495);

        Sheep sheep = new Sheep();
        addObject(sheep,243,76);
        Sheep sheep2 = new Sheep();
        addObject(sheep2,59,338);
        Sheep sheep3 = new Sheep();
        addObject(sheep3,507,195);
        Sheep sheep4 = new Sheep();
        addObject(sheep4,269,552);

        Key key = new Key();
        addObject(key,491,476);

        Fence fence = new Fence();
        addObject(fence,300,300);

        closedBottomFence closedFence = new closedBottomFence();
        addObject(closedFence,300,407);

        LifeParameter lifeParameter = new LifeParameter();
        addObject(lifeParameter,512,564);
    }

    public void started() {
        farmWorldMusic.playLoop();
    }

    public void stopped() {
        farmWorldMusic.stop();
    }
}
