import Model.Model;
import java.awt.event.*;
import javax.swing.*;

public class Controller implements MouseListener, KeyListener, ActionListener {

    private Model m;
    private View v;
    private ViewPanel vp;
    private Timer t;
    private int spritecounter=0;
    
    public Controller()
    {
        m = new Model();
        vp = new ViewPanel(m);
        v = new View(vp);
        t = new Timer(10, this);
        t.start();
        
        v.addMouseListener(this);
        v.addKeyListener(this);
    }
    
    public void birdJump(){
        m.birdJump();
        
        vp.setBirdFlying(true); // Set bird sprite to flying
        
        if (m.isGameOver()) // If the game is paused, reset it
            m.init();
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        birdJump();
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        birdJump();
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        m.update();
        v.repaint();
        
        // Bird sprite updating
        if (vp.isBirdFlying()) // If bird is set to flying sprite,
        {
            spritecounter++; // Increment timer to revert back to normal sprite
            if (spritecounter > 30) // At 30 frames
            {
                vp.setBirdFlying(false);
                spritecounter=0;
            }
        }
        
        // Check for collision!
        if (m.hasCollided())
            m.setGameOver(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }


    @Override
    public void keyReleased(KeyEvent e) {
    }
}
