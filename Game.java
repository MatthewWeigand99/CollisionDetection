package CollisionDetection;

//import java.awt.Dimension;
//import java.awt.Toolkit;

import javax.swing.JFrame;

public class Game{
    public static void main(String[] args) {
        Frame frame = new Frame();

        frame.setSize(700, 700);
        //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //frame.setLocation((int)(screenSize.getWidth() / 2 - frame.getSize().getWidth() / 2),
        //                  (int)(screenSize.getHeight() / 2 - frame.getSize().getHeight() / 2));

        frame.setLocationRelativeTo(null);

        frame.setResizable(false);
        frame.setTitle("Collison Detection");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
