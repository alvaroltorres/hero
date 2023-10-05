import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.Random;

public class Monster extends Element{
    public Monster(int x, int y) {
        super(x, y);
    }

    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#023020"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#FF0000"));
        graphics.enableModifiers(SGR.ITALIC);
        graphics.putString(new TerminalPosition(position.GetX(), position.GetY()), "~@~");
    }

    public Position move(){
        // we can have 4 positions to where monster moves and we can choose to decide it randomly
        switch (new Random().nextInt(4)) {
            case 0:
                return new Position(position.GetX(), position.GetY() - 1);
            case 1:
                return new Position(position.GetX() + 1, position.GetY());
            case 2:
                return new Position(position.GetX(), position.GetY() + 1);
            case 3:
                return new Position(position.GetX() - 1, position.GetY());
        }
        return new Position(position.GetX(), position.GetY());
    }

}
