import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;
import java.util.List;

public class Arena {
    //private Position position;
    private int height;
    private int width;
    private Hero hero;
    //private List<Wall> walls;

    public Arena(int width, int height){
        //this.position = position;
        this.height = height;
        this.width = width;
        hero = new Hero(width / 2, height / 2);

        //this.walls = createWalls();
    }

    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        hero.draw(graphics);

        //for (Wall wall : walls)
           // wall.draw(graphics);
        /*
        screen.clear();
        screen.setCharacter(height, width,TextCharacter.fromCharacter('X')[0]);
        screen.refresh();
         */
    }

    public void processKey(KeyStroke key) {
        if (key.getKeyType() == KeyType.ArrowUp) moveHero(hero.moveUp());
        if (key.getKeyType() == KeyType.ArrowRight) moveHero(hero.moveRight());
        if (key.getKeyType() == KeyType.ArrowDown) moveHero(hero.moveDown());
        if (key.getKeyType() == KeyType.ArrowLeft) moveHero(hero.moveLeft());
        /*
        hero = new Hero(1, 1);
        switch (key.getKeyType()) {
            case ArrowUp:
                moveHero(hero.moveUp());
                break;
            case ArrowDown:
                moveHero(hero.moveDown());
                break;
            case ArrowLeft:
                moveHero(hero.moveLeft());
                break;
            case ArrowRight:
                moveHero(hero.moveRight());
                break;
            default:
                break;
        }
        */
    };
    public void moveHero(Position position) {
        if (canHeroMove(position))
            hero.setPosition(position);
    }

    private boolean canHeroMove(Position position) {
        /*
        Arena arena = new Arena(position, 22, 22, hero);
        int x = arena.position.GetX() + arena.width;
        int y = arena.position.GetY();
        Position toprcorner = new Position(x, y);
        int y1 = arena.position.GetY() + arena.height;
        int x1 = arena.position.GetX();
        Position bottomlcorner = new Position(x1, y1);
        if ((position.GetX() > bottomlcorner.GetX() && position.GetX() < toprcorner.GetX()) && (position.GetY() > toprcorner.GetY() && position.GetY() < bottomlcorner.GetY())) return true;
        */
        if (position.GetX() < 0) return false;
        if (position.GetX() > width - 1) return false;
        if (position.GetY() < 0) return false;
        if (position.GetY() > height - 1) return false;
        return true;
    }
    /*
    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }
        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }
        return walls;
    }
    */

}
