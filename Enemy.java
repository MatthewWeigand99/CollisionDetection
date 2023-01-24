package CollisionDetection;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Graphics2D;


public class Enemy {
    int x; int y;
    int width; int height;
    int startX;

    Rectangle hitBox;

    public Enemy(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        startX = x;

        this.width = width;
        this.height = height;

        hitBox = new Rectangle(x, y, width, height);
    }

    public void set(int camX) {
        x = startX + camX;
        hitBox.x = x;
    }

    public void draw(Graphics2D gtd) {
        gtd.setColor(Color.RED);
        gtd.fillRect(x, y, width, height);

        //Check x position of player
        //gtd.drawString(Integer.toString(x), 100, 100);
    }

}
