package CollisionDetection;

import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class GamePanel extends JPanel implements ActionListener{

    Player player;
    ArrayList<Wall> walls = new ArrayList<>();

    int camX;
    int offset;

    Timer timer;

    public GamePanel() {
        player = new Player(400, 300, this);
        makeWalls(50);
        timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (walls.get(walls.size() - 1).x < 800) {
                    offset += 700;
                    makeWalls(offset);
                    System.out.println(walls.size());
                }

                player.set();
                for (Wall w : walls) {
                    w.set(camX);
                }

                for (int i = 0; i < walls.size(); i++) {
                    if (walls.get(i).x < -800)
                        walls.remove(i);
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
        
        offset = -150;
        makeWalls(offset);
    }

    public void makeWalls(int offset) {
        int size = 50;
        Random rand = new Random();
        int index = rand.nextInt(4);

        if (index == 0) {
            for (int i = 0; i < 14; i++) {
                walls.add(new Wall(offset + i * 50, 600, size, size));
            }
        }
        else if (index == 1) {
            for (int i = 0; i < 14; i++) {
                if (i < 6 || i > 10)
                    walls.add(new Wall(offset + i * 50, 600, size, size));
                else
                    walls.add(new Wall(offset + i * 50, 500, size, size));
            }
        }
        else if (index == 2) {
            for (int i = 0; i < 14; i++) {
                walls.add(new Wall(offset + i * 50, 600, size, size));
                if (i > 4 && i < 11)
                    walls.add(new Wall(offset + i * 50, 550, size, size));
                if (i > 5 && i < 10)
                    walls.add(new Wall(offset + i * 50, 500, size, size));
            }

        }
        else if (index == 3) {
            for (int i = 0; i < 14; i++) {
                if (i < 8 || i > 12)
                    walls.add(new Wall(offset + i * 50, 600, size, size));
                if (i == 9)
                    walls.add(new Wall(offset + i * 50, 550, size, size));
                if (i == 13)
                    walls.add(new Wall(offset + i * 50, 500, size, size));
            }
        }
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
