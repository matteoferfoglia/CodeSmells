package codesmells;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final Size BOARD_SIZE = new Size(3,3) ;
    private final List<Tile> tilesComposingThisBoard = new ArrayList<>(BOARD_SIZE.getArea());

    public enum Row {
        FIRST(0), SECOND(1), THIRD(2);
        private final int value;
        Row(int value){
            this.value = value;
        }
        public int getIndex(){
            return value;
        }
    }

    public Board() {
        for (int i = 0; i < BOARD_SIZE.getWidth(); i++) {
            for (int j = 0; j < BOARD_SIZE.getLength(); j++) {
                Tile tile = new Tile(new Tile.Coordinate2D(i,j), Player.UNSPECIFIED);
                tilesComposingThisBoard.add(tile);
            }
        }
    }

    public Tile TileAt(Tile.Coordinate2D coord) {
        for (Tile t : tilesComposingThisBoard) {
            if (t.getCoordinate2D().equals(coord)){
                return t;
            }
        }
        return null;
    }

    public void addTile(Tile tile) {
        TileAt(tile.getCoordinate2D()).setPlayer(tile.getPlayer());
    }

    public boolean isTheRowEntirelyPlayed(Row row){
        return TileAt(new Tile.Coordinate2D(row.getIndex(),0)).isAlreadyPlayed()
                && TileAt(new Tile.Coordinate2D(row.getIndex(),1)).isAlreadyPlayed()
                && TileAt(new Tile.Coordinate2D(row.getIndex(),2)).isAlreadyPlayed();
    }

    public boolean isTheRowEntirelyPlayedByTheSamePlayer(Row row){
        if(isTheRowEntirelyPlayed(row)) {
            Tile t1 = TileAt(new Tile.Coordinate2D(row.getIndex(), 0)),
                    t2 = TileAt(new Tile.Coordinate2D(row.getIndex(), 1)),
                    t3 = TileAt(new Tile.Coordinate2D(row.getIndex(), 1));
            return t1.samePlayerOf(t2) && t2.samePlayerOf(t3);
        }
        else
            return false;
    }

    public Player getPlayerFromCoordinate(Tile.Coordinate2D coordinate2D){
        return TileAt(coordinate2D).getPlayer();
    }

}

class Size {
    private final int   LENGTH,
                        WIDTH;

    public Size(int length, int width) {
        LENGTH = length;
        WIDTH = width;
    }

    public int getLength() {
        return LENGTH;
    }

    public int getWidth() {
        return WIDTH;
    }

    public int getArea() {
        return LENGTH*WIDTH;
    }
}
