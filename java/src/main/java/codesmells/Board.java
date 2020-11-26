package codesmells;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Tile> _plays = new ArrayList<>();
    private final int BOARD_SIZE = 3 ;

    public Board() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                Tile tile = new Tile(new Coordinate2D(i,j),' ');
                _plays.add(tile);
            }
        }
    }

    public Tile TileAt(Coordinate2D coord) {
        for (Tile t : _plays) {
            if (t.getCoordinate2D().equals(coord)){
                return t;
            }
        }
        return null;
    }

    public void AddTile(Tile tile) {
        TileAt(tile.getCoordinate2D()).setSymbol(tile.getSymbol());
    }
}
