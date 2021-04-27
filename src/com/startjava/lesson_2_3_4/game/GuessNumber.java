package com.startjava.lesson_2_3_4.game;

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
        int targetNumber = random.nextInt(100) + 1;
        System.out.println();

        do {
            if (tryToGuess(firstPlayer, targetNumber)) {
                break;
            }
            if (tryToGuess(secondPlayer, targetNumber)) {
                break;
            }
        } while(true);
    }

    private boolean tryToGuess(Player player, int targetNumber) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Player(%s) attempt: ", player.getName());
        int playerNumber = scanner.nextInt();
        player.setNumber(playerNumber);

        return checkNumber(player, targetNumber);
    }

    private boolean checkNumber(Player player, int targetNumber) {
        boolean isNumberCorrect = false;
        int playerNumber = player.getNumber();

        if (playerNumber > targetNumber) {
            System.out.println("Данное число больше того, что загадал компьютер");
        } else if (playerNumber < targetNumber) {
            System.out.println("Данное число меньше того, что загадал компьютер");
        } else {
            System.out.printf("Player(%s) is winner.%n", player.getName());
            isNumberCorrect = true;
        }

        return isNumberCorrect;
    }
}