import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(650, 650, 1); 
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Farmer farmer = new Farmer();
        addObject(farmer,39,43);
        Gate gate = new Gate();
        addObject(gate,246,131);
        Gate1 gate1 = new Gate1();
        addObject(gate1,337,200);
        Gate1 gate12 = new Gate1();
        addObject(gate12,154,201);
        Gate gate2 = new Gate();
        addObject(gate2,253,295);
        gate2.setLocation(245,321);
        gate2.setLocation(309,468);
        gate1.setLocation(403,390);
        gate.setLocation(333,271);
        gate12.setLocation(267,389);
        gate2.setLocation(320,425);
        gate12.setLocation(271,392);
        farmer.setLocation(100,108);
        gate12.setLocation(318,487);
        gate12.setLocation(277,377);
        gate.setLocation(334,291);
    }
}
