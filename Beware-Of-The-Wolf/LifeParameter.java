import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LifeParameter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LifeParameter extends Actor
{
    private GreenfootImage heart1;
    private GreenfootImage heart2;
    private GreenfootImage heart3;
    
    private Wolf wolf;
    
    
    public LifeParameter() {
        //this.wolf= wolf;
        heart1 = new GreenfootImage ("1-heart-parameter.png");
        heart2 = new GreenfootImage ("2-hearts-parameter.png");
        heart3 = new GreenfootImage ("3-hearts-parameter.png");
        setImage(heart3);
    }
    /**
     * Act - do whatever the LifeParameter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        animateLifeParameter();
    }
    public void animateLifeParameter() {
        
        int count = wolf.getNbaEatenSheep();
        if (getImage() == heart3 && count==1) {
            setImage (heart2);
        }
        else if (getImage() == heart2 && count ==2) {
            setImage(heart1);
        }
        else {
            //transitionToGameOver();
        }
    }
}