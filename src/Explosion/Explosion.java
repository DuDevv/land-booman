package Explosion;

import game.FrameCounter;
import game.GameObject;
import game.Vector2D;
import game.physics.BoxCollider;
import player.Player;
import player.PlayerBoom;

import java.awt.*;

public abstract class Explosion extends GameObject {
    abstract public void explosion(FrameCounter existTime, BoxCollider boxCollider, PlayerBoom playerBoom);
}
