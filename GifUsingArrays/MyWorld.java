import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author Omar Nakhleh
 * @professor Scott Hardman
 * @Assigment Assignment 2 part 2
 * @version (3/23/2017)
 */
public class MyWorld extends World
{
    private long startTime;
    private GreenfootSound soundFile = new GreenfootSound("Tai Lopez-Knowledge!.mp3");

    private static GreenfootImage[] images = new GreenfootImage[30];

    private int slowness = 5;
    private int gifSpeedCounter = 5;
    private int actCycle = 0;

    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(302, 180, 1); 
        for( int i = 0; i < 30; i++ )
        {
            images[i] = new GreenfootImage( "frame_" + i + "_delay-0.07s.gif" );

        }
        setBackground(images[0]);
    }

    /**
     * act handles the actions must be taken everytime the program is run 
     * @param There is no paramters
     * @return Nothing is returned 
     */
    public void act()
    {
        setBackground( images[actCycle % images.length] );

        if ( gifSpeedCounter == slowness )
        {
            actCycle++;
            gifSpeedCounter = 5;
        }
        else 
        {
            gifSpeedCounter++;  
        }

        if( actCycle % images.length == 10 )
        {
            soundFile.stop();
            soundFile.play();
            startTime = System.currentTimeMillis();
        }
    }

    /**
     * setSlowness alows the user to control the in slowness of the gif
     * @param x is the number the represents the slowness
     * @return Nothing is returned      
     */
    public void setSlowness(int x)
    {
        slowness = x;
    }

}