import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.IOException;

public class Game {
    public Game() throws IOException {
        //Screen screen = null;
        try {
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            this.screen = new TerminalScreen(terminal); //screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null); // we don't need a cursor
            screen.startScreen(); // screens must be started
            screen.doResizeIfNecessary();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //this.screen = new TerminalScreen(terminal);
    };

    private void draw() throws IOException { // doesn´t catch and handle any ioexception ( pass it to the calling method by declaring that it throws that kind of exception)
        screen.clear();
        screen.setCharacter(x, y, TextCharacter.fromCharacter('X')[0]);
        screen.refresh();
    };

    public void run() throws IOException {
        draw();
    };
    private Terminal terminal;
    private Screen screen;

    private int x = 10;
    private int y = 10;
}
