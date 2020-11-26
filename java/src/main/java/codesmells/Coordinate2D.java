package codesmells;

public class Coordinate2D {
    private int x;
    private int y;

    public Coordinate2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinate2D)) return false;
        Coordinate2D coordinate2D = (Coordinate2D) o;
        return coordinate2D.x == x && coordinate2D.y == y;
    }
}
