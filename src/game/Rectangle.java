import game.Vector2D;

public class Rectangle {
    Vector2D position; // vị trí hình chữ nhật (góc trên bên trái)
    int width; // chiều rộng hcn
    int height; // chiều cao hcn

    public Rectangle() {
        this(new Vector2D(), 1, 1);
    }


    public Rectangle(Vector2D position, int width, int height) {
        this.position = position;
        this.width = width;
        this.height = height;
    }

    public float top() {
        return this.position.y;
    }

    public float bottom() {
        return this.position.y + this.height;
    }

    public float left() {
        return this.position.x;
    }

    public float right() {
        return this.position.x + this.width;
    }

    /**
     * @param other
     * @return false: nếu 2 hình chữ nhật ko giao nhau
     */
    public boolean intersects(Rectangle other) {
        if (other.top() <= this.bottom() &&
                other.bottom() >= this.top() &&
                this.left() <= other.right() &&
                this.right() >= other.left())
            return true;

        else return false;

    }

    //TODO: 2. Chạy hàm main này để test
    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle(new Vector2D(5, 5), 3, 3);
        Rectangle rect2 = new Rectangle(new Vector2D(4, 4), 3, 3);
        Rectangle rect3 = new Rectangle(new Vector2D(10, 10), 3, 3);
        System.out.println(String.format("rect1 intersects rect2: %s (correct: true)", rect1.intersects(rect2)));
        System.out.println(String.format("rect2 intersects rect1: %s (correct: true)", rect2.intersects(rect1)));
        System.out.println(String.format("rect1 intersects rect3: %s (correct: false)", rect1.intersects(rect3)));
        System.out.println(String.format("rect3 intersects rect2: %s (correct: false)", rect3.intersects(rect2)));
    }
}
