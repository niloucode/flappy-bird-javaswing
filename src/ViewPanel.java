import Model.Model;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ViewPanel extends JPanel {
    
    private Model m;
    private Image birdImg;
    private Image birdFlyingImg;
    private boolean birdFlying;

    private Image upperPipeImg;
    private Image lowerPipeImg;

    public ViewPanel(Model em)
    {
        birdFlyingImg = new ImageIcon(new ImageIcon("./resources/bird_fly.png").getImage().getScaledInstance(80,80,Image.SCALE_SMOOTH)).getImage();
        birdImg = new ImageIcon(new ImageIcon("./resources/bird.png").getImage().getScaledInstance(80,80,Image.SCALE_SMOOTH)).getImage();
        upperPipeImg = new ImageIcon("./resources/upper_pipe.png").getImage();
        lowerPipeImg = new ImageIcon("./resources/lower_pipe.png").getImage();
        
        m = em;
        setPreferredSize(new Dimension(800,900));
        setBackground(Color.black);
    }   
    
    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        if (birdFlying)
            g2D.drawImage(birdFlyingImg, m.getBirdX(), m.getBirdY(), null);
        else
            g2D.drawImage(birdImg, m.getBirdX(), m.getBirdY(), null);

        g2D.drawImage(upperPipeImg, m.getPipeX()[0], m.getPipeUpperY()[0], null);
        g2D.drawImage(lowerPipeImg, m.getPipeX()[0], m.getPipeLowerY()[0], null);
        g2D.drawImage(upperPipeImg, m.getPipeX()[1], m.getPipeUpperY()[1], null);
        g2D.drawImage(lowerPipeImg, m.getPipeX()[1], m.getPipeLowerY()[1], null);
    }
    
    public void setBirdFlying(boolean x)
    {
        birdFlying = x;
    }
    
    public boolean isBirdFlying()
    {
        return birdFlying;
    }
}
