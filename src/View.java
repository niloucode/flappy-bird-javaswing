import java.awt.*;
import javax.swing.*;


public class View extends JFrame {
    private ViewPanel panel;
    
    public View(ViewPanel vp)
    {
        panel = vp;
       
        setTitle("Flappy!");
        setSize(800,900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel);

        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
    
}
