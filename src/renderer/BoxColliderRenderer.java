package renderer;

import game.GameObject;
import game.physics.BoxCollider;
import game.physics.Physics;

import java.awt.*;

public class BoxColliderRenderer extends Renderer {
    Color color;
    boolean isFill;

    public BoxColliderRenderer() {
        this(Color.BLACK, false);
    }

    public BoxColliderRenderer(Color color, boolean isFill) {
        this.color = color;
        this.isFill = true;
    }

    @Override
    public void renderer(Graphics g, GameObject master) {
        if (master instanceof Physics) {
            Physics masterPhysic = (Physics) master;
            BoxCollider masterBoxCollider = masterPhysic.getBoxCollider();
            if (this.isFill) {
                g.fillRect((int) masterPhysic.getBoxCollider().left(),
                        (int) masterPhysic.getBoxCollider().top(),
                        masterBoxCollider.width,
                        masterBoxCollider.height);
            } else {
                g.drawRect((int) masterPhysic.getBoxCollider().left(),
                        (int) masterPhysic.getBoxCollider().top(),
                        masterBoxCollider.width,
                        masterBoxCollider.height);
            }
        }
    }
}
