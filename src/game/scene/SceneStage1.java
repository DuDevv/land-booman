package game.scene;


import box.Box;
import game.GameObject;
import game.background.Background;
import player.Player;
import renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

public class SceneStage1 extends Scene {
    @Override
    void init() {
        GameObject.recycle(Background.class);
        GameObject.recycle(Player.class);
        GameObject.recycle(Box.class);
    }

    @Override
    void clear() {
        GameObject.clearall();
    }
}
