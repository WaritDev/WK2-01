public class Board {
    private static final int NUM_SQUARES = 40;
    private final Square[] squares;

    public Board() {
        squares = new Square[NUM_SQUARES];
        for (int i = 0; i < NUM_SQUARES; i++) {
            squares[i] = new Square("Square " + i, i);
        }
    }

    public Square getStartSquare() {
        return squares[0];
    }

    public Square getSquare(Square oldLoc, int fvTot) {
        int oldLocationIndex = oldLoc.getLocation();
        int newLocationIndex = (oldLocationIndex + fvTot) % NUM_SQUARES;
        return squares[newLocationIndex];
    }
}