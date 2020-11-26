package codesmells;

public class Tile {
    private final Coordinate2D coordinate2D;
    private Player player;

    public Tile(Coordinate2D coord, Player player) {
        this.coordinate2D = coord;
        this.player = player;
    }

    public Coordinate2D getCoordinate2D() {
        return coordinate2D;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public boolean isAlreadyPlayed() {
        return !player.equals(Player.UNSPECIFIED);
    }

    public boolean samePlayerOf(Tile t2) {
        return player.equals(t2.player);
    }

    public static class Coordinate2D {
        private final int x;
        private final int y;

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
}
