import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LineOfSight here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LineOfSight extends Actor
{   
    //https://www.youtube.com/watch?v=qvjvqRzCqow
    Actor wolf;
    Actor sheep;
    int sheepX;
    int sheepY;
    int wolfX;
    int wolfY;
    GreenfootImage myImage;
    /**
     * Act - do whatever the LineOfSight wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public LineOfSight (Actor w, Actor s) {
        wolf = w;
        sheep = s;
        setImage ( new GreenfootImage(1,1));
    }

    public void act()
    {
        if (sheep.getWorld() != null && wolf.getWorld() != null)
        {
            sheepX = sheep.getX();
            sheepY = sheep.getY();
            wolfX = wolf.getX();
            wolfY = wolf.getY();
            int myX = (wolfX + sheepX)/2;
            int myY = (wolfY + sheepY)/2;
            setLocation(myX, myY);
            turnTowards(sheepX, sheepY);
            int d = (int) Math.sqrt(Math.pow((wolfX-sheepX),2) + Math.pow((wolfY-sheepY),2));
            //myImage = getImage();
            myImage.setColor(Color.BLACK);
            myImage.drawLine(0, 0, d, 0);

        }
    }

    public boolean clearLineOfSight() {
        return (getIntersectingObjects(Fence.class) == null);
    }
}
