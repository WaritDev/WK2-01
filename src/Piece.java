public class Piece {
    private Square location;

    public Piece(Square startLocation) {
        this.location = startLocation;
    }

    public Square getLocation() {
        return location;
    }

    public void setLocation(Square newLocation) {
        this.location = newLocation;
    }
}
