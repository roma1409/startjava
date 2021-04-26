package com.startjava.lesson_2_3.game;

import java.util.Scanner;

public class GuessNumberTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("1st name: ");
        String firstName = scanner.nextLine();

        System.out.print("2st name: ");
        String secondName = scanner.nextLine();

        Player firstPlayer = new Player(firstName);
        Player secondPlayer = new Player(secondName);
        GuessNumber game = new GuessNumber(firstPlayer, secondPlayer);

        String answer;
        do {
            game.play();
            do {
                System.out.print("Хотите продолжить игру? [yes/no]: ");
                answer = scanner.nextLine();
            } while(!("yes".equals(answer) || "no".equals(answer)));
        } while("yes".equals(answer));
    }
}