import java.util.ArrayList;
import java.util.List;

public class MGame {
    private final List<Player> players;
    private final Board board;
    private int roundCnt;
    private static final int TOTAL_ROUNDS = 5;

    public MGame(String[] playerNames) {
        board = new Board();
        Die[] dice = new Die[]{new Die(), new Die()};

        players = new ArrayList<>();
        for (String name : playerNames) {
            players.add(new Player(name, board, dice));
        }
    }

    public void playGame() {
        System.out.println("===== Start =====");
        for (roundCnt = 1; roundCnt <= TOTAL_ROUNDS; roundCnt++) {
            playRound();
        }
        System.out.println("===== End =====");
    }

    private void playRound() {
        System.out.println("+++ Lap " + roundCnt + " +++");
        for (Player player : players) {
            player.takeTurn(board);
        }
    }

    public static void main(String[] args) {
        String[] names = {"Player A", "Player B", "Player C"};
        MGame game = new MGame(names);

        game.playGame();
    }
}