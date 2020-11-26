package codesmells;


public class Game {
    private char _lastSymbol = ' ';
    private final Board _board = new Board();

    public void Play(char symbol, int x, int y) throws Exception{
        Play(new Tile(new Coordinate2D(x,y), symbol));
    }

    public void Play(Tile tile) throws Exception {
        //if first move
        if (_lastSymbol == ' ') {
            //if player is X
            if (tile.getSymbol() == 'O') {
                throw new Exception("Invalid first player");
            }
        }
        //if not first move but player repeated
        else if (tile.getSymbol() == _lastSymbol) {
            throw new Exception("Invalid next player");
        }
        //if not first move but play on an already played tile
        else if (_board.TileAt(tile.getCoordinate2D()).getSymbol() != ' ') {
            throw new Exception("Invalid position");
        }

        // update game state
        _lastSymbol = tile.getSymbol();
        _board.AddTile(tile);
    }

    public char Winner() {
        //if the positions in first row are taken
        if (_board.TileAt(new Coordinate2D(0,0)).getSymbol() != ' ' &&
                _board.TileAt(new Coordinate2D(0,1)).getSymbol() != ' ' &&
                _board.TileAt(new Coordinate2D(0,2)).getSymbol() != ' ') {
            //if first row is full with same symbol
            if (_board.TileAt(new Coordinate2D(0,0)).getSymbol() ==
                    _board.TileAt(new Coordinate2D(0,1)).getSymbol() &&
                    _board.TileAt(new Coordinate2D(0,2)).getSymbol() == _board.TileAt(new Coordinate2D(0,1)).getSymbol()) {
                return _board.TileAt(new Coordinate2D(0,0)).getSymbol();
            }
        }

        //if the positions in first row are taken
        if (_board.TileAt(new Coordinate2D(1,0)).getSymbol() != ' ' &&
                _board.TileAt(new Coordinate2D(1,1)).getSymbol() != ' ' &&
                _board.TileAt(new Coordinate2D(1,2)).getSymbol() != ' ') {
            //if middle row is full with same symbol
            if (_board.TileAt(new Coordinate2D(1,0)).getSymbol() ==
                    _board.TileAt(new Coordinate2D(1,1)).getSymbol() &&
                    _board.TileAt(new Coordinate2D(1,2)).getSymbol() ==
                            _board.TileAt(new Coordinate2D(1,1)).getSymbol()) {
                return _board.TileAt(new Coordinate2D(1,0)).getSymbol();
            }
        }

        //if the positions in first row are taken
        if (_board.TileAt(new Coordinate2D(2,0)).getSymbol() != ' ' &&
                _board.TileAt(new Coordinate2D(2,1)).getSymbol() != ' ' &&
                _board.TileAt(new Coordinate2D(2,2)).getSymbol() != ' ') {
            //if middle row is full with same symbol
            if (_board.TileAt(new Coordinate2D(2,0)).getSymbol() ==
                    _board.TileAt(new Coordinate2D(2,1)).getSymbol() &&
                    _board.TileAt(new Coordinate2D(2,2)).getSymbol() ==
                            _board.TileAt(new Coordinate2D(2,1)).getSymbol()) {
                return _board.TileAt(new Coordinate2D(2,0)).getSymbol();
            }
        }

        return ' ';
    }
}

