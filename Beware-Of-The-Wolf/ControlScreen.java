import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ControlScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ControlScreen extends World
{
    /**
     * Constructor for objects of class ControlScreen.
     * 
     */
    public ControlScreen() {    
        // Create a new world with 600x600 cells with a cell size of 1x1 pixels.
        super(600, 600, 1); 
        displayText();

    }
    
    public void act() {
        pressSpace();
    }

    public void pressSpace() {
        if (Greenfoot.isKeyDown("space")) //let User press "Space bar" to switch back to the Game Menu
        {
            World gameMenu = new GameMenu();
            Greenfoot.setWorld(gameMenu); 
            gameMenu.started();

        }
    }

    public void displayText() {
        showText("Press Space Bar to return to Game Menu", 75, 525);
    }

    public void showText(String message, int x, int y) {
        GreenfootImage bg = getBackground();
        Font font =  new Font(25);
        bg.setFont(font);
        bg.setColor(Color.WHITE);
        bg.drawString(message, x, y);

    }

}
