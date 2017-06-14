package ru.games.game_circles_Ball;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class GameWindow extends JFrame {

    private static final int POS_X = 600;
    private static final int POS_Y = 200;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final String TITLE = "Circles";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GameWindow::new);
    }

    private final int INITIAL_BALLS_COUNT = 10;
    private final List<Sprite> sprites = new ArrayList<>();

    private GameWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(POS_X, POS_Y);
        setSize(WIDTH, HEIGHT);
//        setResizable(false);
        setTitle(TITLE);
        GameCanvas gameCanvas = new GameCanvas(this);
        add(gameCanvas);
        initGame();
        setVisible(true);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                sprites.add(new Ball());
            }
        });
    }

    private void initGame(){
        for (int i = 0; i < INITIAL_BALLS_COUNT; i++) {
            sprites.add(new Ball());
        }
    }

    private float time;

    void onDrawFrame(GameCanvas gameCanvas, Graphics g, float deltaTime) {
        float fps = 1f / deltaTime;
        time += deltaTime;
        if(time >= 1f) {
            System.out.println((int) fps);
            time = 0f;
        }
        update(gameCanvas, deltaTime);
        render(gameCanvas, g);
    }

    private void update(GameCanvas gameCanvas, float deltaTime){
        for (Sprite sprite : sprites) {
            sprite.update(gameCanvas, deltaTime);
        }
    }

    private void render(GameCanvas gameCanvas, Graphics g){
        for (Sprite sprite : sprites) {
            sprite.render(gameCanvas, g);
        }
    }
}