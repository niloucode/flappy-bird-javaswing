import Model.Model;
import java.awt.*;
import java.awt.font.*;
import javax.swing.*;
import java.io.File;

public class ViewPanel extends JPanel {
    
    private boolean birdFlying; // Used for sprite
    private Font FONT;
    
    private Model m;
    private Image birdImg;
    private Image birdFlyingImg;
    private Image upperPipeImg;
    private Image lowerPipeImg;
    private Image skyImg;

    public ViewPanel(Model em)
    {
        m = em;
        setPreferredSize(new Dimension(800,800));
        setBackground(Color.black);
        
        try {
            GraphicsEnvironment ge = 
            GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("./resources/micro5.ttf")));
            
            FONT = new Font ("Micro 5", Font.PLAIN, 120);
            
            birdFlyingImg = new ImageIcon(new ImageIcon("./resources/bird_fly.png").getImage().getScaledInstance(60,60,Image.SCALE_SMOOTH)).getImage();
            birdImg = new ImageIcon(new ImageIcon("./resources/bird.png").getImage().getScaledInstance(60,60,Image.SCALE_SMOOTH)).getImage();
            upperPipeImg = new ImageIcon("./resources/upper_pipe.png").getImage();
            lowerPipeImg = new ImageIcon("./resources/lower_pipe.png").getImage();
            skyImg = new ImageIcon("./resources/sky.png").getImage();
        } catch (Exception e)
        {
            System.out.println("ERROR");
        }
    }   
    
    public void paint(Graphics g)
    {
        super.paint(g);
        
        Graphics2D g2D = (Graphics2D) g;

        // Render the sky
        g2D.drawImage(skyImg, m.getSkyX(),0,skyImg.getWidth(null),getHeight(),null);

        // Render the bird
        if (birdFlying)
            g2D.drawImage(birdFlyingImg, m.getBirdPosX(), m.getBirdPosY()-10, null);
        else
            g2D.drawImage(birdImg, m.getBirdPosX(), m.getBirdPosY()-10, null);

        // Render the pipes
        for (int i = 0; i < m.getPipeX().length; i++) {
            g2D.drawImage(upperPipeImg, m.getPipeX()[i], m.getPipeUpperY()[i], null);
            g2D.drawImage(lowerPipeImg, m.getPipeX()[i], m.getPipeLowerY()[i], null);
        }

        // Set default font for g2D
        g2D.setFont(FONT);
              
        // Get String boundaries for centering
        int stringLen = (int) g2D.getFontMetrics().getStringBounds(m.getScore(), g2D).getWidth();
        int start = getWidth()/2 - stringLen/2;

        FontRenderContext frc = g2D.getFontRenderContext();
        GlyphVector gv = FONT.createGlyphVector(frc, m.getScore());
        Shape textOutline = gv.getOutline(start, 100);

        g2D.setColor(Color.BLACK); // Outline color
        g2D.setStroke(new BasicStroke(6)); // Outline thickness
        g2D.draw(textOutline);

        g2D.setColor(Color.WHITE); // Fill color
        g2D.fill(textOutline);
    }
    
    public void setBirdFlying(boolean birdFlying)
    {
        this.birdFlying = birdFlying;
    }
    
    public boolean isBirdFlying()
    {
        return birdFlying;
    }
}
