package Model;

public class Model {
    
    private final int PIPE_GAP = 300;
    private final int PIPE_INITIAL_DISTANCE = 600;
    
    private Bird b;
    private Pipe[] p;
    private Sky s;
    
    boolean gameOver;
    
    private int score;
    
    public Model()
    {
        init();
    }
    
    public void init()
    {
        gameOver = false;
        
        score = 0;
        
        b = new Bird();
        p = new Pipe[]{
            new Pipe(PIPE_INITIAL_DISTANCE),
            new Pipe(PIPE_INITIAL_DISTANCE+PIPE_GAP),
            new Pipe(PIPE_INITIAL_DISTANCE+PIPE_GAP*2)};
        s = new Sky();
    }
    
    public boolean hasCollided()
    {
        return ((b.getX()+60>=p[0].getX() && b.getX()<=(p[0].getX() + p[0].getBoundX())) &&
                ((b.getY() >= p[0].getUpperY() && b.getY()+15 <= p[0].getUpperY() + p[0].getBoundY()) ||
                b.getY()+60 >= (p[0].getLowerY()))) ||
                ((b.getX()+60>=p[1].getX() && b.getX()<=(p[1].getX() + p[1].getBoundX())) &&
                ((b.getY() >= p[1].getUpperY() && b.getY()+15 <= p[1].getUpperY() + p[1].getBoundY()) ||
                b.getY()+60 >= (p[1].getLowerY()))) ||
                b.getY() < -10 || b.getY() > 900;
    }
    
    public void updateScore()
    {
        if ((b.getX() == p[0].getX() || b.getX() == p[1].getX()) && !gameOver)
            score++;
    }
    
    public String getScore()
    {
        return String.valueOf(score);
    }
    
    public int[] getPipeUpperY()
    {
        return new int[]{p[0].getUpperY(),p[1].getUpperY(),p[2].getUpperY()};
    }
    
    public int[] getPipeLowerY()
    {
        return new int[]{p[0].getLowerY(),p[1].getLowerY(),p[2].getLowerY()};
    }
    
    public int[] getPipeX()
    {
        return new int[]{p[0].getX(),p[1].getX(),p[2].getX()};
    }
    
    public int getSkyX()
    {
        return s.getX();
    }
    
    public void update()
    {
        if (!gameOver)
        {
            b.update();
            for (Pipe pipe : p)
                pipe.update();
            updateScore();
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
    
    public boolean isGameOver()
    {
        return gameOver;
    }
    
    public void setGameOver(boolean moving)
    {
        this.gameOver = moving;
    }
}
