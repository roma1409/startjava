package com.startjava.lesson_1.game;

public class MyFirstGame {
    public static void main(String[] args) {
        int max = 100;
        int guessNumber = (int) (Math.random() * max) + 1;
        int playerNumber = 50;

        while (playerNumber != guessNumber) {
            if (playerNumber < guessNumber) {
                System.out.println("Данное число больше того, что загадал компьютер");
                playerNumber++;
            } else {
                System.out.println("Данное число меньше того, что загадал компьютер");
                playerNumber--;
            }
        }
        System.out.println("Поздравляю, число угадано!");
    }
}