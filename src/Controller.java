import Model.Model;
import java.awt.event.*;
import javax.swing.*;

public class Controller implements KeyListener, ActionListener {
    
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
        
        v.addKeyListener(this);
    }
    

    @Override
    public void keyTyped(KeyEvent e) {
        m.birdJump();
        vp.setBirdFlying(true); // Let the bird fly
        if (!m.isMoving())
            m.reset();
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        m.update();
        v.repaint();
        
        // Bird sprite updating
        if (vp.isBirdFlying())
        {
            spritecounter++;
            if (spritecounter > 30)
            {
                vp.setBirdFlying(false);
                spritecounter=0;
            }
        }
        
        // Check for collision!!!!!!!!!!!!!!!!!!!!!!!
        if (m.hasCollided())
            m.setMoving(false);
    }
}
