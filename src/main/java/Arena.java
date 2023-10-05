import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    //private Position position;
    private final int height;
    private final int width;
    private final Hero hero;
    private final List<Wall> walls;
    private final List<Coin> coins;
    private final List<Monster> monsters;

    public Arena(int width, int height){
        //this.position = position;
        this.height = height;
        this.width = width;
        hero = new Hero(width / 2, height / 2);

        this.walls = createWalls();
        this.coins = createCoins();
        this.monsters = createMonsters();
    }

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

    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            coins.add(new Coin(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1));
        return coins;
    }

    private List<Monster> createMonsters() {
        Random random = new Random();
        ArrayList<Monster> monsters = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            monsters.add(new Monster(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1));
        return monsters;
    }

    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#808080"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        hero.draw(graphics);

        for (Wall wall : walls)
            wall.draw(graphics);
        for (Coin coin : coins)
            coin.draw(graphics);
        for (Monster monster : monsters)
            monster.draw(graphics);
        /*
        screen.clear();
        screen.setCharacter(height, width,TextCharacter.fromCharacter('X')[0]);
        screen.refresh();
         */
    }

    public void processKey(KeyStroke key) {
        if (key.getKeyType() == KeyType.ArrowUp)
            moveHero(hero.moveUp());
        if (key.getKeyType() == KeyType.ArrowRight)
            moveHero(hero.moveRight());
        if (key.getKeyType() == KeyType.ArrowDown)
            moveHero(hero.moveDown());
        if (key.getKeyType() == KeyType.ArrowLeft)
            moveHero(hero.moveLeft());

        retrieveCoins();
        moveMonsters();

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

        for (Wall wall : walls)
            if (wall.getPosition().equals(position)) return false;

        return true;
    }

    private void retrieveCoins() {
        for (Coin coin : coins)
            if (hero.getPosition().equals(coin.position)){
                coins.remove(coin);
                break;
            }
    }

    private void moveMonsters(){
        for (Monster monster : monsters){
            Position monsterPosition = monster.move();
            if (canHeroMove(monsterPosition)){
                monster.setPosition(monsterPosition);
            }
        }
    }

}
