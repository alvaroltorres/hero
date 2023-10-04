import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.IOException;

public class Game {

    private Terminal terminal;
    private Screen screen;

    //private int x = 10;
    //private int y = 10;
    private final Hero hero;
    private Arena arena;
    private Position position;

    public Game(int width, int height) throws IOException {
        hero = new Hero(1, 1);
        position = new Position(0, 0);
        arena = new Arena(width, height);
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        this.screen = new TerminalScreen(terminal); //screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null); // we don't need a cursor
        screen.startScreen(); // screens must be started
        screen.doResizeIfNecessary();
        //this.screen = new TerminalScreen(terminal);
    };

    private void draw() throws IOException { // doesn´t catch and handle any ioexception ( pass it to the calling method by declaring that it throws that kind of exception)
        screen.clear();
        arena.draw(screen.newTextGraphics());
        screen.refresh();
    };

    public void run() throws IOException {
        while (true) {
            draw();
            KeyStroke key = screen.readInput();
            if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') screen.close();
            if (key.getKeyType() == KeyType.EOF) break;
            processKey(key);
        }
    };

    private void processKey(KeyStroke key) {
        arena.processKey(key);
    }

}
