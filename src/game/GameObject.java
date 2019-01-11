package game;

import game.physics.BoxCollider;
import game.physics.Physics;
import renderer.Renderer;

import java.awt.*;
import java.util.ArrayList;

public class GameObject {
    //static
    public static ArrayList<GameObject> gameObjects = new ArrayList<>();

    public static void addGameObject(GameObject object) {
        gameObjects.add(object);
    }

    public static <E extends GameObject> E findInactive(Class<E> clazz) {
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject object = gameObjects.get(i);
            if (!object.active &&
                    clazz.isAssignableFrom(object.getClass())) { // object instanceof clazz
                return (E) object;
            }
        }
        return null;
    }

    public static <E extends GameObject> E findIntersected(Class<E> clazz,
                                                           BoxCollider boxCollider) {
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject object = gameObjects.get(i);
            if (clazz.isAssignableFrom(object.getClass()) // object instanceof E
                    && object instanceof Physics
                    // cast object thanh Physics
                    // kiem tra object.getBoxCollider giao voi boxCollider truyen vao
                    && ((Physics) object).getBoxCollider().intersects(boxCollider)
                    && object.active) {
                return (E) object;
            }
        }

        return null;
    }

    public static <E extends GameObject> E recycle(Class<E> clazz) {
        E find = findInactive(clazz);
        if (find != null) {
            find.reset();
            return find;
        }
        try {
            E newInstance = clazz.newInstance();
            addGameObject(newInstance);
            return (newInstance);
        } catch (Exception ex) {
            return null;
        }
    }

    public static void clearall() {
        gameObjects.clear();
    }

    public static void runall() {
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject object = gameObjects.get(i);
            if (object.active == true) object.run();
        }
    }

    public static void renderall(Graphics g) {
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject object = gameObjects.get(i);
            if (object.active == true) object.render(g);
        }
    }

    //non-static
    public Renderer renderer;
    public Vector2D position;
    public Vector2D anchor;
    public Vector2D velocity;
    public boolean active = true;
    public BoxCollider boxCollider;

    public GameObject() {
        this.position = new Vector2D();
        this.anchor = new Vector2D(0.5f, 0.5f);
        this.velocity = new Vector2D();
        boxCollider = null;
    }

    public void run() {
        this.position.addLocationThis(velocity);
    }

    public void render(Graphics g) {
        if (renderer != null)
            this.renderer.renderer(g, this);

        if (this.boxCollider != null) {
            boxCollider.render(g);
        }
    }

    public void destroy() {
        this.active = false;
    }

    public void reset() {
        this.active = true;
    }
}