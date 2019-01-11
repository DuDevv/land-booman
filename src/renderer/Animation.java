package renderer;

import game.FrameCounter;
import game.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Animation extends Renderer {
    ArrayList<BufferedImage> images;
    FrameCounter nextImageCounter;
    boolean isOnce;
    int currentImageIndex;

    public Animation(ArrayList<BufferedImage> images) { // thằng cha nó có hàm tạo dạng này
        this.images = images;
        this.currentImageIndex = 0;
        this.nextImageCounter = new FrameCounter(5);
    }

    public Animation(ArrayList<BufferedImage> images, boolean isOnce) {
        this(images);
        this.isOnce = isOnce;//chi run 1 lan duy nhat
    }

    @Override
    public void renderer(Graphics g, GameObject master) {
        BufferedImage image = this.images.get(currentImageIndex);
        g.drawImage(image, (int) (master.position.x - image.getWidth() * master.anchor.x), (int) (master.position.y - image.getHeight() * master.anchor.y), null);
        if (this.nextImageCounter.run()) {
            this.currentImageIndex++;
            if (this.isOnce && currentImageIndex >= this.images.size()) {
                master.destroy();
            }// dam bao chay 1 lan r xoa
            if (this.currentImageIndex >= this.images.size()) {
                this.currentImageIndex = 0;
            }
            this.nextImageCounter.reset();
        }
    }
}
