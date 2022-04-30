import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Star here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stars extends Actor
{
    private GreenfootImage star1;
    private GreenfootImage star2;
    private GreenfootImage star3;

    
    static int pts;
    public Stars() {
        star1 = new GreenfootImage ("1-star.png");
        star2 = new GreenfootImage ("2-stars.png");
        star3 = new GreenfootImage ("3-stars.png");
        setImage(star3);
    }

    /**
     * Act - do whatever the Star wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        starsRating();
    }

    public void starsRating() {
        
        World world = getWorld(); 
        GameWonWorld gameWon = (GameWonWorld) world;
        pts = gameWon.getAccumulatedPoints();
        if ( pts < 200) {
            setImage (star1);
        }
        else if ( pts >= 200 && pts <= 300) {
            setImage(star2);
        }
        else if (pts > 300) {
            setImage(star3);
        }
    }
}
