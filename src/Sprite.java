import java.awt.*;

abstract class Sprite {

    float x; //центр спрайта
    float y; //центр спрайта
    float halfWidth;
    float halfHeight;

    float getLeft(){
        return x - halfWidth;
    }

    void setLeft(float left){
        x = left + halfWidth;
    }

    float getRight(){
        return x + halfWidth;
    }

    void setRight(float right) {
        x = right - halfWidth;
    }

    float getTop(){
        return y - halfHeight;
    }

    void setTop(float top) {
        y = top + halfHeight;
    }

    float getBottom() {
        return y + halfHeight;
    }

    void setBottom(float bottom){
        y = bottom - halfHeight;
    }

    float getWidth(){
        return 2f * halfWidth;
    }

    float getHeight(){
        return 2f * halfHeight;
    }

    abstract void update(GameCanvas gameCanvas, float deltaTime);

    abstract void render(GameCanvas gameCanvas, Graphics g);
}
