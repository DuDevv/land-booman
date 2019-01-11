package renderer;

import game.GameObject;

import java.awt.*;

public class TextRenderer extends Renderer {
    String text = new String();

    public TextRenderer(String text) {
        this.text = text;
    }

    @Override
    public void renderer(Graphics g, GameObject master) {
        g.drawString(text, (int) master.position.x, (int) master.position.y);
    }
}
