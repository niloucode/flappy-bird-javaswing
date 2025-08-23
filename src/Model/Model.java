package Model;

public class Model {
    
    private final int MAX_PIPES = 2;
    
    private Bird b;
    private Pipe[] p;
    
    boolean moving;
    
    public Model()
    {
        moving = true;
        b = new Bird();
        p = new Pipe[]{new Pipe(600), new Pipe(1060)};
    }
    
    public void reset()
    {
        moving = true;
        b = new Bird();
        p = new Pipe[]{new Pipe(600), new Pipe(1060)};
    }
    
    public boolean hasCollided()
    {
        return ((b.getX()+60>=p[0].getX() && b.getX()+60<=(p[0].getX() + p[0].getBoundX())) &&
                ((b.getY() >= p[0].getUpperY() && b.getY() <= p[0].getUpperY() + p[0].getBoundY()) ||
                b.getY()+60 >= (p[0].getLowerY()))) ||
                ((b.getX()+60>=p[1].getX() && b.getX()+60<=(p[1].getX() + p[1].getBoundX())) &&
                ((b.getY() >= p[1].getUpperY() && b.getY() <= p[1].getUpperY() + p[1].getBoundY()) ||
                b.getY()+60 >= (p[1].getLowerY())));
    }
    
    public int[] getPipeUpperY()
    {
        return new int[]{p[0].getUpperY(),p[1].getUpperY()};
    }
    
    public int[] getPipeLowerY()
    {
        return new int[]{p[0].getLowerY(),p[1].getLowerY()};
    }
    
    public int[] getPipeX()
    {
        return new int[]{p[0].getX(),p[1].getX()};
    }
    
    public void update()
    {
        if (moving)
        {
            b.update();
            p[0].update();
            p[1].update();
        }
    }
    
    public void birdJump()
    {
        b.jump();
    }
    
    public int getBirdX()
    {
        return b.getX();
    }
    
    public int getBirdY()
    {
        return b.getY();
    }
    
    public boolean isMoving()
    {
        return moving;
    }
    
    public void setMoving(boolean moving)
    {
        this.moving = moving;
    }
}
