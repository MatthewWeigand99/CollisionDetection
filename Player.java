package CollisionDetection;

import java.awt.Color;
import java.awt.Rectangle;

import java.awt.Graphics2D;

public class Player {

    GamePanel panel;
    int x; int y;
    int width; int height;

    double xspeed; double yspeed;

    Rectangle hitBox;
    boolean keyLeft;
    boolean keyRight;
    boolean keyDown;
    boolean keyUp;

    public Player(int x, int y, GamePanel panel) {
        this.panel = panel;
        this.x = x;
        this.y = y;

        width = 50;
        height = 100;

        hitBox = new Rectangle(x, y, width, height){};
    }

    public void set() {
        if(keyLeft && keyRight || !keyLeft && !keyRight)
            xspeed *= 0.8;
        else if (keyLeft && !keyRight)
            xspeed--;
        else if (keyRight && !keyLeft)
            xspeed++;

        if (xspeed > 0 && xspeed < 0.75)
            xspeed = 0;
        if (xspeed < 0 && xspeed > -0.75)
            xspeed = 0;

        if (xspeed > 6)
            xspeed = 6;
        if (xspeed < -6)
            xspeed = -6;

        if (keyUp) {
            hitBox.y++;
            for (Wall w : panel.walls) {
                if (w.hitBox.intersects(hitBox))
                    yspeed = -6;
            }
            hitBox.y--;
        }
        yspeed += 0.3;

        hitBox.x += xspeed;
        for(Wall w : panel.walls) {
            if (hitBox.intersects(w.hitBox)) {
                hitBox.x -= xspeed;
                while (!w.hitBox.intersects(hitBox)) {
                    hitBox.x += Math.signum(xspeed);
                }
                hitBox.x -= Math.signum(xspeed);
                xspeed = 0;
                x = hitBox.x;
            }
        }

        hitBox.y += yspeed;
        for(Wall w : panel.walls) {
            if (hitBox.intersects(w.hitBox)) {
                hitBox.y -= yspeed;
                while (!w.hitBox.intersects(hitBox)) {
                    hitBox.y += Math.signum(yspeed);
                }
                hitBox.y -= Math.signum(yspeed);
                yspeed = 0;
                y = hitBox.y;
            }
        }


        x += xspeed;
        y += yspeed;

        hitBox.x = x;
        hitBox.y = y;
    }

    public void draw(Graphics2D gtd) {
        gtd.setColor(Color.GREEN);
        gtd.fillRect(x, y, width, height);
    }
}
