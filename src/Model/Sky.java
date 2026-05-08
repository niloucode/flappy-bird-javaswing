package Model;

public class Sky {
    private int x;
    private int velX;
    private int boundX;
    
    public Sky()
    {
        x = 0;
        velX = 20;
        boundX = 3072;
    }
    
    public void update()
    {
        x -= velX;
        
        if (x < -boundX)
        {
            x = 800;
        }
    }
    
    public int getX()
    {
        return x;
    }
}
