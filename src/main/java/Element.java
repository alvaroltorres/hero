import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class Element {

    protected Position position;

    public Element(int x, int y){
        position = new Position(x, y);
    }

    public void setPosition(Position position) {
        this.position  = position;
    }
    public Position getPosition() {
        return position;
    }

    public abstract void draw(TextGraphics graphics);

}
