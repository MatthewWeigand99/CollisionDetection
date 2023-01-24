package CollisionDetection;

import java.awt.Color;

import javax.swing.JFrame;

public class Frame extends JFrame{
    public Frame() {
        GamePanel panel = new GamePanel();
        panel.setLocation(0, 0);
        panel.setSize(this.getSize());
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setVisible(true);
        this.add(panel);

        addKeyListener(new KeyCheck(panel));
    }
}
