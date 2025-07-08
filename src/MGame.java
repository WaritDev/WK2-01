import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MGame {
    private final List<Player> players;
    private final Board board;
    private final int totalRounds;
    private int roundCnt;

    public MGame(String[] playerNames, int totalRounds) {
        this.board = new Board();
        this.totalRounds = totalRounds;

        Die[] dice = {new Die(), new Die()};

        this.players = new ArrayList<>();
        for (String name : playerNames) {
            players.add(new Player(name, board, dice));
        }
    }

    public void playGame() {
        System.out.println("===== Game Start =====");
        // Display game configuration
        System.out.println("Players: " + players.size() + " | Total Rounds: " + totalRounds + " | Dice: 2");
        for (roundCnt = 1; roundCnt <= this.totalRounds; roundCnt++) {
            playRound();
        }
        System.out.println("===== Game End =====");
    }

    private void playRound() {
        System.out.println("--- Round " + roundCnt + " ---");
        for (Player player : players) {
            player.takeTurn(board);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of players (2-8): ");
        int playerCount = scanner.nextInt();
        while (playerCount < 2 || playerCount > 8) {
            System.out.println("Invalid input. The number of players must be between 2 and 8.");
            System.out.print("Please enter the number of players (2-8): ");
            playerCount = scanner.nextInt();
        }

        System.out.print("Enter the total number of rounds: ");
        int roundsToPlay = scanner.nextInt();

        String[] playerNames = new String[playerCount];
        for (int i = 0; i < playerCount; i++) {
            playerNames[i] = "Player " + (i + 1);
        }

        MGame game = new MGame(playerNames, roundsToPlay);
        game.playGame();

        scanner.close();
    }
}