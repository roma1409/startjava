package com.startjava.lesson_2_3_4.game;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GuessNumber {
    private final int ATTEMPT_QUANTITY = 10;
    private final Player firstPlayer;
    private final Player secondPlayer;
    private int step = 0;
    private boolean isFirstPlayerWinner;

    public GuessNumber(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    public void play() {
        guessProcess();
        renderResult();
    }

    public void resetProgress() {
        Arrays.fill(firstPlayer.getNumbers(), 0, step, 0);
        Arrays.fill(secondPlayer.getNumbers(), 0, step, 0);
        isFirstPlayerWinner = false;
        step = 0;
    }

    private void guessProcess() {
        Random random = new Random();
        int targetNumber = random.nextInt(100) + 1;
        System.out.printf("%nУ каждого игрока %d попыток.%n", ATTEMPT_QUANTITY);

        while (step < ATTEMPT_QUANTITY) {
            step++;
            if (tryToGuess(firstPlayer, targetNumber, step)) {
                isFirstPlayerWinner = true;
                break;
            } else if (step == ATTEMPT_QUANTITY) {
                System.out.printf("У %s закончились попытки.%n", firstPlayer.getName());
            }

            if (tryToGuess(secondPlayer, targetNumber, step)) {
                break;
            } else if (step == ATTEMPT_QUANTITY) {
                System.out.printf("У %s закончились попытки.%n", secondPlayer.getName());
            }
        }
    }

    private void renderResult() {
        int[] firstPlayerNumbers = Arrays.copyOf(firstPlayer.getNumbers(), step);
        int[] secondPlayerNumbers = Arrays.copyOf(secondPlayer.getNumbers(), isFirstPlayerWinner ? step - 1 : step);

        String formattedFirstPlayerNumbers = numbersToString(firstPlayerNumbers);
        String formattedSecondPlayerNumbers = numbersToString(secondPlayerNumbers);

        System.out.printf("%s - %s%n", firstPlayer.getName(), formattedFirstPlayerNumbers);
        System.out.printf("%s - %s%n", secondPlayer.getName(), formattedSecondPlayerNumbers);
    }

    private String numbersToString(int[] numbers) {
        return Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));
    }

    private boolean tryToGuess(Player player, int targetNumber, int step) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Player(%s) attempt: ", player.getName());
        int playerNumber = scanner.nextInt();
        player.setNumber(step - 1, playerNumber);

        return checkNumber(player, targetNumber, step);
    }

    private boolean checkNumber(Player player, int targetNumber, int step) {
        boolean isNumberCorrect = false;
        int playerNumber = player.getNumber(step - 1);

        if (playerNumber > targetNumber) {
            System.out.println("Данное число больше того, что загадал компьютер.");
        } else if (playerNumber < targetNumber) {
            System.out.println("Данное число меньше того, что загадал компьютер.");
        } else {
            System.out.printf("Игрок %s угадал число %d с %d попытки.%n", player.getName(), targetNumber, step);
            isNumberCorrect = true;
        }

        return isNumberCorrect;
    }
}