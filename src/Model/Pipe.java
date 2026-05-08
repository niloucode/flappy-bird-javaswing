package Model;

import java.lang.Math;

public class Pipe {
    private final int sizeX=120;
    private final int sizeY=560;
    private final int gap = 194;
    private final int velX=2;
    
    private int x;
    private int y;
    
    public Pipe(int x)
    {
        this.x = x; // Screen border
        generateY();
    }
    
    public void generateY()
    {
        y = (int)Math.floor(Math.random()*340)+250;
    }
    
    public void update()
    {
        x -= velX;
        
        if (x < -sizeX)
        {
            x = 800;
            generateY();
        }
    }
    
    public int getUpperY()
    {
        return y-(gap/2)-sizeY;
    }
    public int getLowerY()
    {
        return y+(gap/2);
    }
    
    public int getSizeX()
    {
        return sizeX;
    }
    public int getSizeY()
    {
        return sizeY;
    }

    public int getX()
    {
        return x;
    }
}
