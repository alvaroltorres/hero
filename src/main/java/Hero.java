import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class Hero {

    private Position position;


    public Hero(int x, int y) {
        this.position = new Position(x, y);

    }; //Hero hero = new Hero(10, 10);

    public Position moveUp() {
        return new Position(position.GetX(), position.GetY() - 1);
    }
    public Position moveRight(){
        return new Position(position.GetX() + 1, position.GetY());
    }
    public Position moveDown(){
        return new Position(position.GetX(), position.GetY() + 1);
    }
    public Position moveLeft(){
        return new Position(position.GetX() - 1, position.GetY());
    }
    public void draw(Screen screen) throws IOException {
        screen.clear();
        screen.setCharacter(position.GetX(), position.GetY(), TextCharacter.fromCharacter('X')[0]);
        screen.refresh();
    }

    public void setPosition(Position position) {
       this.position  = position;
    }
}
