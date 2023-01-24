package CollisionDetection;

import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class GamePanel extends JPanel implements ActionListener{

    Player player;
    ArrayList<Wall> walls = new ArrayList<>();

    int camX;

    Timer timer;

    public GamePanel() {
        player = new Player(400, 300, this);
        makeWalls(50);
        timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                player.set();
                for (Wall w : walls) {
                    w.set(camX);
                }
                repaint();
        }}, 0, 17);
    }

    public void reset() {
        player.x = 200;
        player.y = 150;
        camX = 150;
        player.xspeed = 0;
        player.yspeed = 0;

        walls.clear();
        
        int offset = 50;
        makeWalls(offset);
    }

    public void makeWalls(int offset) {
        for (int i = 50; i < 650; i += 50) {
            walls.add(new Wall(i, 600, 50, 50));
        }
        walls.add(new Wall(50, 550, 50, 50));
        walls.add(new Wall(50, 500, 50, 50));
        walls.add(new Wall(50, 450, 50, 50));
        walls.add(new Wall(600, 550, 50, 50));
        //walls.add(new Wall(600, 500, 50, 50));
        //walls.add(new Wall(600, 450, 50, 50));
        walls.add(new Wall(450, 550, 50, 50));
    }

    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D gtd = (Graphics2D) g;
        
        player.draw(gtd);
        for (Wall w : walls) {
            w.draw(gtd);
        }
    }

    void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'a')
            player.keyLeft = true;
        if (e.getKeyChar() == 'w')
            player.keyUp = true;
        if (e.getKeyChar() == 'd')
            player.keyRight = true;
        if (e.getKeyChar() == 's')
            player.keyDown = true;
    }

    void keyReleased(KeyEvent e) {
        if (e.getKeyChar() == 'a')
        player.keyLeft = false;
        if (e.getKeyChar() == 'w')
        player.keyUp = false;
        if (e.getKeyChar() == 'd')
        player.keyRight = false;
        if (e.getKeyChar() == 's')
        player.keyDown = false;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

    }
}
