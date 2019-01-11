package tklibs;

import game.FrameCounter;
import game.physics.BoxCollider;

import java.awt.image.BufferedImage;

public class Setting {
    public static int CANVAS_HEIGHT = 1000;
    public static int CANVAS_WIDTH = 1000;
    public static int WAY_SIZE = 50;
    public static int ROW_COUNT = CANVAS_HEIGHT / WAY_SIZE;
    public static int COL_COUNT = CANVAS_WIDTH / WAY_SIZE;
    public static int FPS = 1000 / 60;
    public final static int STAY = 0;
    public final static int TOP = 1;
    public final static int RIGHT = 2;
    public final static int BOT = 3;
    public final static int LEFT = 4;
    public final static FrameCounter existTimeBomb = new FrameCounter(3);
}
