package com.startjava.lesson_2_3_4.game;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    private final int ATTEMPT_QUANTITY = 10;
    private final Player firstPlayer;
    private final Player secondPlayer;
    private int step = 0;
    private int targetNumber;
    private boolean isFirstPlayerWinner;

    public GuessNumber(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    public void play() {
        guessProcess();
        showEnteredNumbers();
        resetProgress();
    }

    private void guessProcess() {
        Random random = new Random();
        targetNumber = random.nextInt(100) + 1;
        System.out.printf("У каждого игрока %d попыток.%n", ATTEMPT_QUANTITY);

        while (step < ATTEMPT_QUANTITY) {
            step++;
            if (tryToGuess(firstPlayer)) {
                isFirstPlayerWinner = true;
                break;
            } else if (step == ATTEMPT_QUANTITY) {
                System.out.printf("У %s закончились попытки.%n", firstPlayer.getName());
            }

            if (tryToGuess(secondPlayer)) {
                break;
            } else if (step == ATTEMPT_QUANTITY) {
                System.out.printf("У %s закончились попытки.%n", secondPlayer.getName());
            }
        }
    }

    private void showEnteredNumbers() {
        int[] firstPlayerNumbers = firstPlayer.getNumbers(step);
        int secondPlayerAttemptQuantity = isFirstPlayerWinner ? step - 1 : step;
        int[] secondPlayerNumbers = secondPlayer.getNumbers(secondPlayerAttemptQuantity);

        System.out.printf("%s: ", firstPlayer.getName());
        Arrays.stream(firstPlayerNumbers)
                .forEach(firstPlayerNumber -> System.out.printf("%d ", firstPlayerNumber));
        System.out.println();
        System.out.printf("%s: ", secondPlayer.getName());
        Arrays.stream(secondPlayerNumbers)
                .forEach(firstPlayerNumber -> System.out.printf("%d ", firstPlayerNumber));
        System.out.println();
    }

    public void resetProgress() {
        firstPlayer.resetNumbers(step);
        firstPlayer.resetNumbers(step);
        isFirstPlayerWinner = false;
        step = 0;
    }

    private boolean tryToGuess(Player player) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Player(%s) attempt: ", player.getName());
        int playerNumber = scanner.nextInt();
        player.setCurrentNumber(step - 1, playerNumber);

        return checkNumber(player);
    }

    private boolean checkNumber(Player player) {
        boolean isNumberCorrect = false;
        int playerNumber = player.getCurrentNumber(step - 1);

        String message;
        if (playerNumber == targetNumber) {
            message = String.format("Игрок %s угадал число %d с %d попытки.", player.getName(), targetNumber, step);
            isNumberCorrect = true;
        } else {
            message = String.format("Данное число %s того, что загадал компьютер.", playerNumber > targetNumber ? "больше" : "меньше");
        }
        System.out.println(message);

        return isNumberCorrect;
    }
}