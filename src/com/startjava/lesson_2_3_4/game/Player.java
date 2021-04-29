package com.startjava.lesson_2_3_4.game;

import java.util.Arrays;

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

    public int[] getNumbers(int newLength) {
        return Arrays.copyOf(numbers, newLength);
    }

    public void setCurrentNumber(int index, int number) {
        numbers[index] = number;
    }

    public int getCurrentNumber(int index) {
        return numbers[index];
    }

    public void resetNumbers(int toIndex) {
        Arrays.fill(numbers, 0, toIndex, 0);
    }
}