import java.awt.*;
import javax.swing.*;

public class View extends JFrame {
    private ViewPanel vp;
    
    public View(ViewPanel vp)
    {
        this.vp = vp;
       
        setTitle("Flappy!");
        setSize(700,900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(this.vp);

        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);
    }
    
}
