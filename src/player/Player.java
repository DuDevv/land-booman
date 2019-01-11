package player;

import game.FrameCounter;
import game.GameObject;
import game.GameWindow;
import game.physics.BoxCollider;
import game.physics.Physics;
import renderer.BoxColliderRenderer;
import renderer.SingleImageRenderer;
import tklibs.Mathx;
import tklibs.Setting;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends GameObject implements Physics {

    int direction;
    FrameCounter moveCounter;
    FrameCounter bombCounter;

    public Player() {
        this.boxCollider = new BoxCollider(this.position, this.anchor, 40, 40);
        BufferedImage player = SpriteUtils.loadImage("assets/images/players/straight/dinhphi.png");
        this.renderer = new SingleImageRenderer(SpriteUtils.resize(player, 45, 45));
        this.position.set(75, 75);
        this.moveCounter = new FrameCounter(5);
        this.bombCounter = new FrameCounter(60);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void run() {
        super.run();
        this.setDirection();
        this.limitPlayerLocation();
        this.move();
        this.bombing();
    }

    public void limitPlayerLocation() {
        int halfWidth = Setting.WAY_SIZE / 2;
        int halfHeight = Setting.WAY_SIZE / 2;
        this.position.x = (float) Mathx.clamp(this.position.x, halfWidth + 2, Setting.CANVAS_WIDTH - Setting.WAY_SIZE - 5 + halfWidth);
        this.position.y = (float) Mathx.clamp(this.position.y, halfHeight + 2, Setting.CANVAS_HEIGHT - Setting.WAY_SIZE - 5 + halfHeight);
    }

    private void setDirection() {
        if (GameWindow.isUpPress) {
            this.direction = Setting.TOP;
        } else if (GameWindow.isDownPress) {
            this.direction = Setting.BOT;
        } else if (GameWindow.isLeftPress) {
            this.direction = Setting.LEFT;
        } else if (GameWindow.isRightPress) {
            this.direction = Setting.RIGHT;
        } else {
            this.direction = Setting.STAY;
        }
    }

    private void move() {
        if (this.moveCounter.run()) {
            switch (this.direction) {
                case Setting.TOP: {
                    this.position.addLocationThis(0, -Setting.WAY_SIZE);
                    break;
                }
                case Setting.RIGHT: {
                    this.position.addLocationThis(Setting.WAY_SIZE, 0);
                    break;
                }
                case Setting.BOT: {
                    this.position.addLocationThis(0, Setting.WAY_SIZE);
                    break;
                }
                case Setting.LEFT: {
                    this.position.addLocationThis(-Setting.WAY_SIZE, 0);
                    break;
                }
            }
            this.moveCounter.reset();

        }
    }

    public void bombing() {
        if (GameWindow.isFiringPress) {
            PlayerBoom boom = GameObject.recycle(PlayerBoom.class);
            boom.position.set(this.position.x, this.position.y);
            this.bombCounter.reset();
        }
    }

}
