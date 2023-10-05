public class Position {
    private int x;
    private int y;

    public void SetX(int x){
        this.x = x;
    }
    public void SetY(int y){
        this.y = y;
    }

    public int GetX(){
        return x;
    }
    public int GetY(){
        return y;
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        Position p = (Position) o;
        return x == p.GetX() && y == p.GetY();
    }

}
