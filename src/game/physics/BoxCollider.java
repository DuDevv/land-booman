package game.physics;

import game.GameObject;
import game.Vector2D;

import java.awt.*;

public class BoxCollider extends GameObject {
    Vector2D position; // vị trí hình chữ nhật (góc trên bên trái)
    public int width; // chiều rộng hcn
    public int height; // chiều cao hcn
    Vector2D anchor;

    public BoxCollider() {
        this(new Vector2D(), new Vector2D(), 1, 1);
    }


    public BoxCollider(Vector2D position, Vector2D anchor, int width, int height) {
        this.position = position;
        this.anchor = anchor;
        this.width = width;
        this.height = height;

    }

    public float top() {
        return this.position.y - this.anchor.y * this.height;
    }

    public float bottom() {
        return this.position.y + this.height;
    }

    public float left() {
        return this.position.x - this.anchor.x * this.width;
    }

    public float right() {
        return this.position.x + this.width;
    }

    /**
     * @param other
     * @return false: nếu 2 hình chữ nhật ko giao nhau
     */
    public boolean intersects(BoxCollider other) {
        if (other.top() <= this.bottom() &&
                other.bottom() >= this.top() &&
                this.left() <= other.right() &&
                this.right() >= other.left())
            return true;

        else return false;

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.drawRect((int) this.left(), (int) this.top(), width, height);
    }
}
