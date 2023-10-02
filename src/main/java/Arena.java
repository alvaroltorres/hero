import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class Arena {
    private int height;
    private int width;

    public Arena(int height, int width, Hero hero){
        this.height = height;
        this.width = width;
        this.hero = hero;
    }

    private Hero hero;

    public void draw(Screen screen) throws IOException {
        screen.clear();
        screen.setCharacter(height, width,TextCharacter.fromCharacter('X')[0]);
        screen.refresh();
    }

    public void processKey(KeyStroke key) {
        hero = new Hero(10, 10);
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
        //if (canHeroMove(position))
            hero.setPosition(position);
    }
    /*
    private boolean canHeroMove(Position position) {
        if (position.GetX() < width && position.GetY() < height) return true;
        else return false;
    }
    */
}
