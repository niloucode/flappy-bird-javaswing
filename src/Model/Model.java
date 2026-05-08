package Model;

public class Model {
    
    private final int PIPE_GAP = 300;
    private final int PIPE_INITIAL_DISTANCE = 600;
    
    private Bird bird;
    private Pipe[] pipes;
    private Sky sky;
    
    boolean gameOver;
    
    private int score;
    
    public Model()
    {
        init();
    }
    
    public void init()
    {
        score = 0;
        gameOver = false;

        bird = new Bird();
        pipes = new Pipe[]{
            new Pipe(PIPE_INITIAL_DISTANCE),
            new Pipe(PIPE_INITIAL_DISTANCE+PIPE_GAP),
            new Pipe(PIPE_INITIAL_DISTANCE+PIPE_GAP*2)};
        sky = new Sky();
    }
    
    public boolean hasCollided()
    {
    // Debugger
    // System.out.println("Pipe upperY:" +pipes[0].getUpperY()+"   Pipe sizeY:" +pipes[0].getSizeY() + "Bird posY "+bird.getPosY());

        if (bird.getPosY() < -10 || bird.getPosY() > 900)
            return true;

        for (int i = 0; i < pipes.length; i++) {

            boolean withinPipeX =
                    bird.getPosX() + bird.getSizeX() >= pipes[i].getX() &&
                    bird.getPosX() <= pipes[i].getX() + pipes[i].getSizeX();

            boolean hitUpperPipe =
                    bird.getPosY() <= pipes[i].getUpperY() + pipes[i].getSizeY();

            boolean hitLowerPipe =
                    bird.getPosY() + bird.getSizeY() >= pipes[i].getLowerY();

            if (withinPipeX && (hitUpperPipe || hitLowerPipe)) {
                return true;
            }
        }

        return false;
    }
    
    public void updateScore()
    {
        if ((bird.getPosX() == pipes[0].getX() || bird.getPosX() == pipes[1].getX() || bird.getPosX() == pipes[2].getX()) && !gameOver)
            score++;
    }
    
    public String getScore()
    {
        return String.valueOf(score);
    }

    public int[] getPipeUpperY()
    {
        return new int[]{pipes[0].getUpperY(), pipes[1].getUpperY(), pipes[2].getUpperY()};
    }

    public int[] getPipeLowerY()
    {
        return new int[]{pipes[0].getLowerY(), pipes[1].getLowerY(), pipes[2].getLowerY()};
    }

    public int[] getPipeX()
    {
        return new int[]{pipes[0].getX(), pipes[1].getX(), pipes[2].getX()};
    }

    public int getSkyX()
    {
        return sky.getX();
    }
    
    public void update()
    {
        if (!gameOver)
        {
            bird.update();
            for (Pipe pipe : pipes)
                pipe.update();
            updateScore();
        }
    }
    
    public void birdJump()
    {
        bird.jump();
    }
    
    public int getBirdPosX()
    {
        return bird.getPosX();
    }
    
    public int getBirdPosY()
    {
        return bird.getPosY();
    }

    public int getBirdSizeX()
    {
        return bird.getSizeX();
    }

    public int getBirdSizeY()
    {
        return bird.getSizeY();
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
