package codesmells;

public class Player {
    public static final Player UNSPECIFIED = new Player(' ');
    public static final Player CROSS = new Player('X');
    public static final Player CIRCLE = new Player('O');

    private final char actualSymbol;

    public Player(char actualSymbol) {
        this.actualSymbol = actualSymbol;
    }

    public static Player fromCharSymbol(char symbol) {
        if(symbol==UNSPECIFIED.actualSymbol)
            return UNSPECIFIED;
        else if(symbol==CROSS.actualSymbol)
            return CROSS;
        else if(symbol==CIRCLE.actualSymbol)
            return CIRCLE;
        else
            throw new IllegalArgumentException("Invalid symbol.");
    }

    public void move(Tile.Coordinate2D coordinate2D, Player previousPlayer, Board board) throws Exception {

        if (isTheFirstMove(previousPlayer)) {
            if (this.equals(CIRCLE)) {
                throw new Exception("Invalid first player.");
            }
        } else if(this.equals(previousPlayer)) {
            throw new Exception("Invalid next player: cannot be the same than the previous one.");
        }
        else if (board.TileAt(coordinate2D).isAlreadyPlayed()) {
            throw new Exception("Invalid position.");
        }
    }


    private boolean isTheFirstMove(Player p){
        return p.equals(Player.UNSPECIFIED);
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
