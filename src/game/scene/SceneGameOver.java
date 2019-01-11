package game.scene;

import game.GameObject;
import game.GameWindow;

public class SceneGameOver extends Scene {
    @Override
    void init() {
        BackgroundGameover backgroundGameover = GameObject.recycle(BackgroundGameover.class);
    }

    @Override
    void clear() {
        GameObject.clearall();
        GameWindow.isAnyKeyPress = false;
    }
}
