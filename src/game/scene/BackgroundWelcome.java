package game.scene;


import game.FrameCounter;
import game.GameObject;
import game.GameWindow;
import renderer.SingleImageRenderer;
import tklibs.Setting;
import tklibs.SpriteUtils;

import java.awt.*;

public class BackgroundWelcome extends GameObject {
    FrameCounter waitCounter;

    public BackgroundWelcome() {
        this.renderer = new SingleImageRenderer(SpriteUtils.loadImage("assets/images/background/welcome.jpg"));
        this.position.set(Setting.CANVAS_WIDTH / 2, Setting.CANVAS_HEIGHT / 2);
        this.waitCounter = new FrameCounter(3);
    }

    @Override
    public void run() {
        super.run();
        if (GameWindow.isAnyKeyPress && this.waitCounter.run()) {
            SceneManage.signNewScene(new SceneStage1());
        }
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
    }
}
