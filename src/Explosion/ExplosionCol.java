package Explosion;

import Explosion.Explosion;
import box.Box;
import game.FrameCounter;
import game.GameObject;
import game.Vector2D;
import game.physics.BoxCollider;
import player.PlayerBoom;
import tklibs.Setting;

public class ExplosionCol extends GameObject {
    public PlayerBoom playerBoom;
    public FrameCounter existTime;

    public ExplosionCol(FrameCounter existTime, BoxCollider boxCollider, PlayerBoom playerBoom) {
        this.existTime = existTime;
        this.boxCollider = boxCollider;
        this.playerBoom = playerBoom;
    }

    public ExplosionCol() {
        super();
        this.existTime = new FrameCounter(50);
        this.boxCollider = new BoxCollider(this.position, this.anchor, 10, 50);

    }

//    @Override
//    public void explosion(FrameCounter existTime, BoxCollider boxCollider, PlayerBoom playerBoom) {}

    @Override
    public void run() {
        super.run();
        boxCollider.height = Setting.WAY_SIZE * 3;
        this.checkIntersect();
        if (this.existTime.run()) {
            this.destroy();
            this.existTime.reset();
        }
    }

//    public void exploding(){
//       if (playerBoom.checkExplosion()){
//
//           if (this.existTime.run() && boxCollider.height <= 150) {
//
//           }
//           this.existTime.reset();
//           this.checkIntersect(playerBoom);
//       }
//    }

    private void checkIntersect() {
        Box box = GameObject.findIntersected(Box.class, this.boxCollider);
        if (box != null) {
            box.destroy();
        }
    }


}
