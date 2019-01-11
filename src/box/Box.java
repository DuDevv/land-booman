package box;

import game.FrameCounter;
import game.GameObject;
import game.physics.BoxCollider;
import game.physics.Physics;
import renderer.BoxColliderRenderer;
import renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Box extends GameObject implements Physics {

    public Box() {
        BufferedImage image = SpriteUtils.loadImage("assets/images/box/1.png");
        this.boxCollider = new BoxCollider(this.position, this.anchor, 20, 20);
        this.renderer = new SingleImageRenderer(SpriteUtils.resize(image, 45, 45));
        this.position.set(125, 125);

    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
