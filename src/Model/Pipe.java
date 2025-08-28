package Model;

import java.lang.Math;

public class Pipe {
    // gap - 194 / 2 = 97
    // boundx - 120
    // boundy - 560
    
    // some function: update, getters/setters
    private int velx=2;
    
    private int x;
    private int y;
    private int boundx=120;
    private int boundy=560;
    private int gap = 194;
    
    public Pipe(int x)
    {
        this.x = x; // Screen border
        generateY();
    }
    
    public void generateY()
    {
        y = (int)Math.floor(Math.random()*340)+250;
        // BEST AVG        y = 420;
        // HIGHEST        y = 250;
        // LOWEST         y = 590;
    }
    
    public void update()
    {
        x -= velx;
        
        if (x < -boundx)
        {
            x = 800;
            generateY();
        }
    }
    
    public int getUpperY()
    {
        return y-(gap/2+boundy);
    }
    
    public int getLowerY()
    {
        return y+(gap/2);
    }
    
    public int getBoundX()
    {
        return boundx;
    }
    public int getBoundY()
    {
        return boundy;
    }
    
    public int getGap()
    {
        return gap;
    }
    
    public int getX()
    {
        return x;
    }
}
