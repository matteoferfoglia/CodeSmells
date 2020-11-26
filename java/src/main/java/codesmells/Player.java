package codesmells;

public class Player {
    public static final Player UNSPECIFIED = new Player(' ');
    public static final Player CROSS = new Player('X');
    public static final Player CIRCLE = new Player('O');

    private char actualSymbol;

    public Player(char actualSymbol) {
        this.actualSymbol = actualSymbol;
    }

    public static Player fromChar(char symbol) {
        if(symbol==UNSPECIFIED.actualSymbol)
            return UNSPECIFIED;
        else if(symbol==CROSS.actualSymbol)
            return CROSS;
        else if(symbol==CIRCLE.actualSymbol)
            return CIRCLE;
        else
            throw new IllegalArgumentException("Invalid symbol.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Player) {
            return actualSymbol == ((Player)o).actualSymbol;
        } else {
            return false;
        }
    }

    public char toChar() {
        return actualSymbol;
    }
}
