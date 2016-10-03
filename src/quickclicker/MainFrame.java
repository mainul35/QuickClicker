package quickclicker;

/**
*
* @author Mainul35
*/
import javax.swing.JFrame;

import java.awt.*;

public class MainFrame extends JFrame {

    FormPane formpanel = new FormPane();

    public MainFrame() {

        super("Login");
        setLayout(new BorderLayout());
        setSize(500, 400);
        setLocationRelativeTo(getParent());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(formpanel, BorderLayout.CENTER);

    }

}
