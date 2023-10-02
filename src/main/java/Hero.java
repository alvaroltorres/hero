import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class Hero {

    private int x;
    private int y;

    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }

    public int getX(int x){
        return x;
    }
    public int getY(int y){
        return y;
    }

    public Hero(int x, int y) {
        this.x = x;
        this.y = y;
    } //Hero hero = new Hero(10, 10);

    public void moveUp(){
        y--;
    }
    public void moveRight(){
        x++;
    }
    public void moveDown(){
        y++;
    }
    public void moveLeft(){
        x--;
    }
    public void draw(Screen screen) throws IOException {
        screen.clear();
        screen.setCharacter(x, y, TextCharacter.fromCharacter('X')[0]);
        screen.refresh();
    }

};
