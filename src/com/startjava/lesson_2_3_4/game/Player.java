package com.startjava.lesson_2_3_4.game;

public class Player {
    private final String name;
    private final int[] numbers;

    public Player(String name) {
        this.name = name;
        numbers = new int[10];
    }

    public String getName() {
        return name;
    }

    public int[] getNumbers() {
        return numbers;
    }

    public void setNumber(int index, int playerNumber) {
        numbers[index] = playerNumber;
    }

    public int getNumber(int index) {
        return numbers[index];
    }
}