package game;

import game.scene.SceneManage;
import game.scene.SceneWelcome;
import tklibs.Setting;

import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel {
    //properties

    //method
    public GameCanvas() {
        SceneManage.signNewScene(new SceneWelcome());
    }

    public void runAll() {
        GameObject.runall();
    }

    public void renderAll() {
        this.repaint();
    }

    public void gameLoop() {
        long lastTimeRun = 0;
        while (true) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastTimeRun > Setting.FPS) {
                runAll();//logic
                renderAll();//showgame
                lastTimeRun = currentTime;
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 1000, 1000);
        GameObject.renderall(g);
    }
}

