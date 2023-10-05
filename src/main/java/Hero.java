import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class Hero {

    private Position position;

    public Hero(int x, int y) {
        position = new Position(x, y);

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

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.GetX(), position.GetY()), "X");
    }

    public void setPosition(Position position) {
       this.position  = position;
    }
    public Position getPosition() {
        return position;
    }
}
