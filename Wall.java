package CollisionDetection;

import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics2D;

public class Wall {
    //Wall variables
    int x; int y; int width; int height;
    int startX;

    Rectangle hitBox;

    //Wall constructor
    public Wall(int x, int y, int width, int height) {
        this.x = x;
        startX = x;
        this.y = y;
        this.width = width;
        this.height = height;

        hitBox = new Rectangle(x, y, width, height);
    }

    //Wall draw method
    public void draw(Graphics2D gtd) {
        gtd.setColor(Color.BLACK);
        gtd.drawRect(x, y, width, height);
        gtd.setColor(Color.WHITE);
        gtd.fillRect(x + 1, y + 1, width - 2, height - 2);
    }

    //Wall set method
    public int set(int camX) {
        x = startX + camX;
        hitBox.x = x;

        return x;
    }
}
