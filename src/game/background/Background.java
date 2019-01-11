package game.background;

import game.GameObject;
import tklibs.Setting;

import java.awt.*;

public class Background extends GameObject {
    public Background() {
        this.anchor.set(0, 0);
    }

    @Override
    public void render(Graphics g) {

        g.setColor(Color.BLACK);
        for (int i = 0; i < Setting.ROW_COUNT; i++) {
            g.drawLine(0, i * Setting.WAY_SIZE, Setting.CANVAS_WIDTH, i * Setting.WAY_SIZE);
        }
        for (int i = 0; i < Setting.COL_COUNT; i++) {
            g.drawLine(i * Setting.WAY_SIZE, 0, i * Setting.WAY_SIZE, Setting.CANVAS_HEIGHT);
        }
    }
}
