package renderer;

import game.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SingleImageRenderer extends Renderer {
    BufferedImage image;

    public SingleImageRenderer(BufferedImage image) {
        this.image = image;
    }

    @Override
    public void renderer(Graphics g, GameObject master) {
        g.drawImage(this.image, (int) (master.position.x - image.getWidth() * master.anchor.x), (int) (master.position.y - image.getWidth() * master.anchor.y), null);
    }
}
