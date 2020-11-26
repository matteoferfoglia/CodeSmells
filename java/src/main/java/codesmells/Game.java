package codesmells;


public class Game {
    private Player lastPlayer = Player.UNSPECIFIED;
    private final Board board = new Board();

    public void play(Tile tile) throws Exception {
        if (isTheFirstMove(lastPlayer)) {
            if (tile.getPlayer().equals(Player.CIRCLE)) {
                throw new Exception("Invalid first player");
            }
        } else if(tile.getPlayer().equals(lastPlayer)) {
            throw new Exception("Invalid next player");
        }
        else if (board.TileAt(tile.getCoordinate2D()).isAlreadyPlayed()) {
            throw new Exception("Invalid position");
        }

        updateGameState(tile);
    }

    private void updateGameState(Tile whatTileHasJustBeenPlayed){
        lastPlayer = whatTileHasJustBeenPlayed.getPlayer();
        board.addTile(whatTileHasJustBeenPlayed);
    }

    private boolean isTheFirstMove(Player p){
        return p.equals(Player.UNSPECIFIED);
    }

    public void play(char symbol, int x, int y) throws Exception{
        //Point of failure: this method is here for backward compatibility with tests
        play(new Tile(new Coordinate2D(x,y), Player.fromChar(symbol)));
    }

    public char Winner() {

        Player winnerPlayer = Player.UNSPECIFIED;

        if (board.isTheRowEntirelyPlayedByTheSamePlayer(Board.Row.FIRST)) {
            winnerPlayer = board.TileAt(new Coordinate2D(0,0)).getPlayer();
        }
        if (board.isTheRowEntirelyPlayedByTheSamePlayer(Board.Row.SECOND)) {
            winnerPlayer = board.TileAt(new Coordinate2D(1,0)).getPlayer();
        }
        if (board.isTheRowEntirelyPlayedByTheSamePlayer(Board.Row.THIRD)) {
            winnerPlayer = board.TileAt(new Coordinate2D(2,0)).getPlayer();
        }

        return winnerPlayer.toChar();
    }
}

