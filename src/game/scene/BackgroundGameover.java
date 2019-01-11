package game.scene;

import game.FrameCounter;
import game.GameCanvas;
import game.GameObject;
import game.GameWindow;

import renderer.SingleImageRenderer;
import tklibs.Setting;
import tklibs.SpriteUtils;

public class BackgroundGameover extends GameObject {
    FrameCounter waitCounter;

    public BackgroundGameover() {
        this.renderer = new SingleImageRenderer(SpriteUtils.loadImage("assets/images/background/gameover.jpg"));
        this.position.set(Setting.CANVAS_WIDTH / 2, Setting.CANVAS_HEIGHT / 2);
        this.waitCounter = new FrameCounter(3);
    }

    @Override
    public void run() {
        super.run();
        if (GameWindow.isAnyKeyPress && this.waitCounter.run()) {
            SceneManage.signNewScene(new SceneWelcome());
        }
    }
}

