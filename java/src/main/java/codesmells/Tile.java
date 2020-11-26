package codesmells;

public class Tile {
    private final Coordinate2D coordinate2D;
    private char symbol;

    public Tile(Coordinate2D coord, char symbol) {
        this.coordinate2D = coord;
        this.symbol = symbol;
    }

    public Coordinate2D getCoordinate2D() {
        return coordinate2D;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
}
