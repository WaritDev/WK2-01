import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MGame {
    private final List<Player> players;
    private final Board board;
    private final int totalRounds;
    private int roundCnt;

    public MGame(String[] playerNames, int totalRounds, int numberOfDice) {
        this.board = new Board();
        this.totalRounds = totalRounds;

        Die[] dice = new Die[numberOfDice];
        for (int i = 0; i < numberOfDice; i++) {
            dice[i] = new Die();
        }

        this.players = new ArrayList<>();
        for (String name : playerNames) {
            players.add(new Player(name, board, dice));
        }
    }

    public void playGame() {
        System.out.println("===== Game Start =====");
        System.out.println("Players: " + players.size() + " | Total Rounds: " + totalRounds);
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

        System.out.print("Enter the number of players: ");
        int playerCount = scanner.nextInt();

        System.out.print("Enter the total number of rounds: ");
        int roundsToPlay = scanner.nextInt();

        System.out.print("Enter the number of dice: ");
        int diceCount = scanner.nextInt();

        String[] playerNames = new String[playerCount];
        for (int i = 0; i < playerCount; i++) {
            playerNames[i] = "Player " + (i + 1);
        }

        MGame game = new MGame(playerNames, roundsToPlay, diceCount);
        game.playGame();
        scanner.close();
    }
}