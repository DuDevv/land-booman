package game;

import tklibs.Setting;

import java.awt.*;

public class Program {
    public static void main(String[] args) {
        GameWindow gameWindow = new GameWindow();
        GameCanvas gameCanvas = new GameCanvas();
        gameCanvas.setPreferredSize(new Dimension(Setting.CANVAS_WIDTH, Setting.CANVAS_HEIGHT));
        gameWindow.add(gameCanvas);
        gameWindow.pack();
        gameCanvas.gameLoop();

    }
}
