package Model;

public class Sky {
    private int x;
    private int velx;
    private int boundx;
    
    public Sky()
    {
        x = 0;
        velx = 20;
        boundx = 3072;
    }
    
    public void update()
    {
        x -= velx;
        
        if (x < -boundx)
        {
            x = 800;
        }
    }
    
    public int getX()
    {
        return x;
    }
}
