package game.scene;

public class SceneManage {
    public static Scene currentScene;

    public static void signNewScene(Scene newScene) {
        if (currentScene != null) {
            currentScene.clear();
        }
        newScene.init();
        currentScene = newScene;
    }
}
