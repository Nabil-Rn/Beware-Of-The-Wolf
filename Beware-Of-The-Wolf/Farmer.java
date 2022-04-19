import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Farmer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Farmer extends Actor
{
    protected boolean keyLeftPressed;
    protected boolean keyRightPressed;
    protected boolean keyUpPressed;
    protected boolean keyDownPressed;
    
    GreenfootImage farmer_animation;
    GifImage farmer_Up = new GifImage("farmer-up.gif");
    GifImage farmer_Down = new GifImage("farmer-down.gif");
    GifImage farmer_Right = new GifImage("farmer-right.gif");
    GifImage farmer_Left = new GifImage("farmer-Left.gif");
    
    GreenfootImage pickSheep_animation;
    GifImage pickSheep_Up = new GifImage("pickSheep-up.gif");
    GifImage pickSheep_Down = new GifImage("pickSheep-down.gif");
    GifImage pickSheep_Right = new GifImage("pickSheep-right.gif");
    GifImage pickSheep_Left = new GifImage("pickSheep-left.gif");
    
    boolean stopFarmerMove;
    
    /**
     * Act - do whatever the Farmer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Farmer() {
        
        updateFarmerKeyboardState();
    }
    
    public void act()
    {
        // Add your action code here.
        moveAround();
        hitWall();
        pickSheep();
        updateFarmerKeyboardState();
        if (isGameWon()) {
            //transitionToGameWorld();
        }
        else
        {
            transitionToGameWorld();
        }
    }

    public void moveAround()
    {   int originalX = getX();
        int originalY = getY();
        
        if (isLeftKeyPressed())
        {   
            setLocation(getX() - 1, getY());
            move(-4);
            farmer_animation = farmer_Left.getCurrentImage();
            setImage(farmer_animation);
        }
        if (isRightKeyPressed())
        {   
            setLocation(getX() + 1, getY());
            move(4);
            farmer_animation = farmer_Right.getCurrentImage();
            setImage(farmer_animation);
        }
        if (isUpKeyPressed()) 
        {   
            setLocation(getX(), getY() - 1 );
            farmer_animation = farmer_Up.getCurrentImage();
            setImage(farmer_animation);
        }
        if (isDownKeyPressed()) 
        {   
            setLocation(getX(), getY() + 1 );
            farmer_animation = farmer_Down.getCurrentImage();
            setImage(farmer_animation);
        }
        if (isTouching(Fence.class))
        { setLocation(originalX, originalY);
          Greenfoot.playSound("bump.wav");
        }
        updateFarmerKeyboardState();
        
    /*
        if (Greenfoot.isKeyDown("right") && stopFarmerMove == false) {
            farmer_animation = farmer_Right.getCurrentImage();
            setImage(farmer_animation);
            move(4);
        }
        else if (Greenfoot.isKeyDown("right") && stopFarmerMove == true)
        {
            move(-3);
            stopFarmerMove = false;
        }
        if (Greenfoot.isKeyDown("left") && stopFarmerMove == false) {
            farmer_animation = farmer_Left.getCurrentImage();
            setImage(farmer_animation);
            move(-4);
        }
        else if (Greenfoot.isKeyDown("left") && stopFarmerMove == true)
        {
            move(3);
            stopFarmerMove = false;
        }
        if (Greenfoot.isKeyDown("up") && stopFarmerMove == false) {
            farmer_animation = farmer_Up.getCurrentImage();
            setImage(farmer_animation);
            setLocation(getX(), getY()-4);
        }  
        else if (Greenfoot.isKeyDown("up") && stopFarmerMove == true)
        {
            setLocation(getX(), getY()+3);
            stopFarmerMove = false;
        }
        if (Greenfoot.isKeyDown("down") && stopFarmerMove == false) {
            farmer_animation = farmer_Down.getCurrentImage();
            setImage(farmer_animation);
            setLocation(getX(), getY()+4);
        }    
        else if (Greenfoot.isKeyDown("up") && stopFarmerMove == true)
        {
            setLocation(getX(), getY()-3);
            stopFarmerMove = false;
        }*/
    }
    
      public boolean isLeftKeyPressed() 
    {
        return keyLeftPressed == false && Greenfoot.isKeyDown("left");
    }
    
    public boolean isRightKeyPressed() 
    {
        return keyRightPressed == false && Greenfoot.isKeyDown("right");
    }
    public boolean isUpKeyPressed() 
    {
        return keyUpPressed == false && Greenfoot.isKeyDown("up");
    }
    public boolean isDownKeyPressed() 
    {
        return keyDownPressed == false && Greenfoot.isKeyDown("down");
    }
    
    public void updateFarmerKeyboardState()
    { 
        keyLeftPressed = Greenfoot.isKeyDown("left");
        keyRightPressed = Greenfoot.isKeyDown("right");
        keyUpPressed = Greenfoot.isKeyDown("up");
        keyDownPressed = Greenfoot.isKeyDown("down");
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
        Actor Fence;
        Fence = getOneIntersectingObject(ClosedFence.class);

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

