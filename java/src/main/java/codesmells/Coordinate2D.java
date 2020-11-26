package codesmells;

public class Coordinate2D {
    private int x;
    private int y;

    public Coordinate2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object other) {
        if(other instanceof Coordinate2D) {
            Coordinate2D otherCoordinate = (Coordinate2D)other;
            return otherCoordinate.x == x && otherCoordinate.y == y;
        } else {
            return false ;
        }
    }
}
