package game;

public class Vector2D {
    public float x;
    public float y;

    public Vector2D() {
        this(0, 0);
    }

    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D set(float x, float y) {
        this.x = x;
        this.y = y;
        return this;
    }

    public Vector2D set(Vector2D other) {
        return this.set(other.x, other.y);
    }

    public Vector2D addLocationThis(float x, float y) {
        this.x += x;
        this.y += y;
        return this;
    }

    public Vector2D addLocationThis(Vector2D other) {
        this.x += other.x;
        this.y += other.y;
        return this;
    }

    public Vector2D plusLocation(float x, float y) {
        return new Vector2D(this.x + x, this.y + y);
    }

    public Vector2D plusLocation(Vector2D other) {
        return this.set(other.x, other.y);
    }

    public Vector2D minusLocationThis(float x, float y) {
        this.x -= x;
        this.y -= y;
        return this;
    }

    public Vector2D minusLocationThis(Vector2D other) {
        this.x *= other.x;
        this.y -= other.y;
        return this;
    }

    public Vector2D minusLocation(float x, float y) {
        return new Vector2D(this.x - x, this.y - y);
    }

    public Vector2D minusLocation(Vector2D other) {
        return this.set(other.x, other.y);
    }

    public Vector2D multiplyLocationThis(float ratio) {
        this.x *= ratio;
        this.y *= ratio;
        return this;
    }

    public Vector2D multiplyLocation(float x, float y) {
        return new Vector2D(this.x * x, this.y * y);
    }

    public float getLength() {
        return (float) Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
    }

    public Vector2D setLength(float length) {
        if (this.getLength() == 0) return this;
        else {
            float rate = length / this.getLength();
            this.x = this.x * rate;
            this.y = this.y * rate;
            return this;
        }
    }

    public float getAngle() {
        return (float) (Math.acos(this.x / this.getLength()));
    }

    public Vector2D setAngle(float angle) {
        float length = this.getLength();
        this.x = (float) (length * Math.cos(angle));
        this.y = (float) (length * Math.sin(angle));
        return this;
    }

    @Override
    public String toString() {
        return "Vector2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
