package Model;

public class Bird {
    
    private int x=100;
    private int y=400;
    private double vely=1;
    private double accely=.2;
    
    public void update()
    {
        y += vely; 
        vely += accely;
    }
    
    public void jump()
    {
        vely = -5;
    }
    
    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
}
