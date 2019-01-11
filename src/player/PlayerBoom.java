package player;

import Explosion.ExplosionCol;
import Explosion.ExplosionRow;
import box.Box;
import game.FrameCounter;
import game.GameObject;
import game.Vector2D;
import game.physics.BoxCollider;
import game.physics.Physics;
import renderer.BoxColliderRenderer;
import renderer.SingleImageRenderer;
import tklibs.AudioUtils;
import tklibs.Setting;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
public class PlayerBoom extends GameObject implements Physics {
    FrameCounter waitTime;
    FrameCounter existTime;

    FrameCounter existBombTime;
    BoxCollider bombBoxCollider;

    public PlayerBoom() {
        this.boxCollider = new BoxCollider(this.position, this.anchor, 20, 20);
        BufferedImage playerBoom = SpriteUtils.loadImage("assets/images/player-bullets/bomb.png");
        this.renderer = new SingleImageRenderer(SpriteUtils.resize(playerBoom, 20, 20));
        this.waitTime = new FrameCounter(100);
        this.existTime = new FrameCounter(1);
        this.existBombTime = new FrameCounter(3);

    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void run() {
        super.run();
        this.checkExplosion();
        //this.exploding();
    }

    @Override
    public void reset() {
        super.reset();
        this.existTime.reset();
        // this.waitTime.reset();
    }

    public void checkExplosion() {
        if (waitTime.run()) {
            this.destroy();
            ExplosionCol explosionCol = new ExplosionCol();
            explosionCol.position.set(this.position);
            GameObject.addGameObject(explosionCol);
            ExplosionRow explosionRow = new ExplosionRow();
            explosionRow.position.set(this.position);
            GameObject.addGameObject(explosionRow);
            this.waitTime.reset();
        }

    }

//    public void exploding() {
//        this.explosionCol.exploding(this);
//}
}

