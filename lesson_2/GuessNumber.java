import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    private Player firstPlayer;
    private Player secondPlayer;

    public GuessNumber(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    public void play() {
        Random random = new Random();
        int number = random.nextInt(99) + 1;
        boolean isNumberCorrect = false;
        System.out.println();

        do {
            this.tryToGuess(this.firstPlayer);
            isNumberCorrect = this.checkNumber(this.firstPlayer, number);
            if (!isNumberCorrect) {
                this.tryToGuess(this.secondPlayer);
                isNumberCorrect = this.checkNumber(this.secondPlayer, number);
            }
        } while(!isNumberCorrect);
    }

    private void tryToGuess(Player player) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Player(%s) attempt: ", player.getName());
        int playerNumber = Integer.parseInt(scanner.nextLine());
        player.setNumber(playerNumber);
    }

    private boolean checkNumber(Player player, int gameNumber) {
        boolean isNumberCorrect = false;
        int playerNumber = player.getNumber();

        if (playerNumber > gameNumber) {
            System.out.println("Данное число больше того, что загадал компьютер");
        } else if (playerNumber < gameNumber) {
            System.out.println("Данное число меньше того, что загадал компьютер");
        } else {
            System.out.printf("Player(%s) is winner.%n", player.getName());
            isNumberCorrect = true;
        }

        return isNumberCorrect;
    }
}