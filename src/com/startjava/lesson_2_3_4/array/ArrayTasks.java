package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class ArrayTasks {
    public static void showTwoMinimalElements(int[] numbers) {
        if (numbers.length < 2) {
            throw new RuntimeException(String.format("Array length should be more than 2, actual length is: %d", numbers.length));
        }

        int firstMin = numbers[0];
        int secondMin = numbers[1];

        for (int i = 2; i < numbers.length; i++) {
            int currentNumber = numbers[i];

            if (currentNumber < firstMin) {
                if (firstMin < secondMin) {
                    secondMin = firstMin;
                }
                firstMin = currentNumber;
            } else if (currentNumber < secondMin) {
                secondMin = currentNumber;
            }
        }

        System.out.printf("%s: %d, %d", Arrays.toString(numbers), firstMin, secondMin);
    }

    public static void showIndexesOfOddNumbers(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                System.out.println(i);
            }
        }
    }

    public static void showBiggerNumbersByAbs() {
        int SIZE = 20;
        int MIN = -15;
        int MAX = 14;
        int[] numbers = new int[SIZE];
        int maxNumber = Integer.MIN_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) ((Math.random() * (MAX - MIN)) + MIN);
            maxNumber = Math.max(numbers[i], maxNumber);
        }

        int finalMaxNumber = maxNumber;
        int moreThanMaxByAbsQuantity = Arrays.stream(numbers).reduce(0, (acc, currentNumber) -> {
            if (Math.abs(currentNumber) > finalMaxNumber) {
                return acc + 1;
            } else {
                return acc;
            }
        });
        System.out.println("Max number: " + maxNumber);
        System.out.println("Array: " + Arrays.toString(numbers));
        System.out.println("More than max by abs: " + moreThanMaxByAbsQuantity);
    }

    public static void showAverageValueOfPositiveNumbers(int[] numbers) {
        int sum = 0;
        int quantity = 0;
        for (int currentNumber : numbers) {
            if (currentNumber > 0) {
                sum += currentNumber;
                quantity++;
            }
        }
        System.out.println(sum / quantity);
    }

    public static void showMaxNegativeNumber(int[] numbers) {
        int index = -1;
        int maxNegativeNumber = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0) {
                if (index == -1) {
                    index = i;
                    maxNegativeNumber = numbers[i];
                } else if (maxNegativeNumber > numbers[i]) {
                    index = i;
                    maxNegativeNumber = numbers[i];
                }
            }
        }

        if (index == -1) {
            throw new RuntimeException("There isn't negative numbers: " + Arrays.toString(numbers));
        }
        System.out.printf("[%d] = %d", index, maxNegativeNumber);
    }

    public static void main(String[] args) {
        int[] numbers = {-5, 8, 0, 1, 2, -8, 1};

        showMaxNegativeNumber(numbers);
    }
}
