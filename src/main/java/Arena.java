import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class Arena {
    private Position position;
    private int height;
    private int width;
    private Hero hero;

    public Arena(Position position, int height, int width, Hero hero){
        this.position = position;
        this.height = height;
        this.width = width;
        this.hero = hero;
    }

    public void draw(Screen screen) throws IOException {
        screen.clear();
        screen.setCharacter(height, width,TextCharacter.fromCharacter('X')[0]);
        screen.refresh();
    }

    public void processKey(KeyStroke key) {
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

    };
    public void moveHero(Position position) {
        if (canHeroMove(position))
            hero.setPosition(position);
    }

    private boolean canHeroMove(Position position) {
        Arena arena = new Arena(position, 22, 22, hero);
        int x = arena.position.GetX() + arena.width;
        int y = arena.position.GetY();
        Position toprcorner = new Position(x, y);
        int y1 = arena.position.GetY() + arena.height;
        int x1 = arena.position.GetX();
        Position bottomlcorner = new Position(x1, y1);
        if ((position.GetX() > bottomlcorner.GetX() && position.GetX() < toprcorner.GetX()) && (position.GetY() > toprcorner.GetY() && position.GetY() < bottomlcorner.GetY())) return true;
        else return false;
    }

}
