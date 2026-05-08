package Model;

public class Bird {
    private final int sizeX=60;
    private final int sizeY=30;

    private int posX=100;
    private int posY=400;

    private double velY=1;
    private final double accY=.2;
    
    public void update()
    {
        posY += velY;
        velY += accY;
    }
    
    public void jump()
    {
        velY = -5;
    }
    
    public int getPosX()
    {
        return posX;
    }
    public int getPosY()
    {
        return posY;
    }

    public int getSizeX()
    {
        return sizeX;
    }
    public int getSizeY()
    {
        return sizeY;
    }
}
