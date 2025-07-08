public class Player {
    private final String name;
    private final Piece piece;
    private final Die[] dice;

    public Player(String name, Board board, Die[] dice) {
        this.name = name;
        this.piece = new Piece(board.getStartSquare());
        this.dice = dice;
    }

    public String getName() {
        return name;
    }

    public Piece getPiece() {
        return piece;
    }

    public void takeTurn(Board board) {
        System.out.println("  turn of " + name);

        int fvTot = 0;
        for (Die die : dice) {
            die.roll();
            int faceValue = die.getFaceValue();
            System.out.println("    value: " + faceValue);
            fvTot += faceValue;
        }
        System.out.println("    sum: " + fvTot);

        Square oldLoc = piece.getLocation();
        System.out.println("    from: " + oldLoc.getName());

        Square newLoc = board.getSquare(oldLoc, fvTot);
        System.out.println("    go to: " + newLoc.getName());

        piece.setLocation(newLoc);
        System.out.println("--------------------");
    }
}