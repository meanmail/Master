import javax.swing.*;
import java.awt.*;

class GameCanvas extends JPanel {

    private static final int SLEEPING_TIME = 17;

    private GameWindow gameWindow;
    private long lastTime;

    GameCanvas(GameWindow gameWindow){
        this.gameWindow = gameWindow;
        lastTime = System.nanoTime();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        long currentTime = System.nanoTime();
        float deltaTime = (currentTime - lastTime) * 1e-9f;
        lastTime = currentTime;

        gameWindow.onDrawFrame(this, g, deltaTime);
        try {
            Thread.sleep(SLEEPING_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();
    }

    int getLeft(){
        return 0;
    }

    int getRight(){
        return getWidth() - 1;
    }

    int getTop(){
        return 0;
    }

    int getBottom(){
        return getHeight() - 1;
    }
}
