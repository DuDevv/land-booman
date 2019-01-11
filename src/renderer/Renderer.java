package renderer;

import game.GameObject;

import java.awt.*;

public abstract class Renderer {
    abstract public void renderer(Graphics g, GameObject master);
}
