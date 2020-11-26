package codesmells;


public class Game {
    private Player lastPlayer = Player.UNSPECIFIED;
    private final Board board = new Board();


    public void play(char symbol, int x, int y) throws Exception{
        play(Player.fromCharSymbol(symbol), new Tile.Coordinate2D(x,y));
    }

    public void play(Player player, Tile.Coordinate2D coordinate2D) throws Exception {
        player.move(coordinate2D, lastPlayer, board);
        updateGameState(new Tile(coordinate2D, player));
    }

    private void updateGameState(Tile whatTileHasJustBeenPlayed){
        lastPlayer = whatTileHasJustBeenPlayed.getPlayer();
        board.addTile(whatTileHasJustBeenPlayed);
    }

    public char Winner() {

        Player winnerPlayer = Player.UNSPECIFIED;

        for(Board.Row row : Board.Row.values()){
            Tile.Coordinate2D coordinatesOfFirstTileInThisRow = new Tile.Coordinate2D(row.getIndex(), 0);
            if (board.isTheRowEntirelyPlayedByTheSamePlayer(row)) {
                winnerPlayer = board.getPlayerFromCoordinate(coordinatesOfFirstTileInThisRow);
                break;
            }
        }

        return winnerPlayer.toChar();
    }
}

