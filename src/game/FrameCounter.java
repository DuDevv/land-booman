package game;

public class FrameCounter {
    int countMax, count;

    public FrameCounter(int countMax) {
        this.countMax = countMax;
        this.count = 0;
    }

    public boolean run() {
        if (this.count >= countMax) {
            return true; // da dem xong
        } else {
            this.count++;
            return false;
        }
    }

    public void reset() {
        this.count = 0;
    }
}
