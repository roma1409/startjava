package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

    public static void showMostFrequentNumber(int[] numbers) {
        if (numbers.length == 0) {
            throw new RuntimeException("Provide not empty array.");
        }

        Map<Integer, Integer> rates = new HashMap<>();
        int maxFrequency = 0;
        int maxFrequentNumber = 0;

        for (int number : numbers) {
            int value = 0;

            if (rates.containsKey(number)) {
                value = rates.get(number);
            }

            rates.put(number, ++value);

            if (maxFrequency < value) {
                maxFrequency++;
                maxFrequentNumber = number;
            }
        }

        System.out.printf("'%d' is found %d times in array: %s", maxFrequentNumber, maxFrequency, Arrays.toString(numbers));
    }

    public static void showMostFrequentNumber2(int[] numbers) {
        if (numbers.length == 0) {
            throw new RuntimeException("Provide not empty array.");
        }

        int maxFrequency = 0;
        int maxFrequentNumber = 0;

        for (int i = 0, numbersLength = numbers.length; i < numbersLength; i++) {
            int currentFrequency = 1;
            int number = numbers[i];

            for (int j = i + 1; j < numbersLength; j++) {
                if (number == numbers[j]) {
                    currentFrequency++;
                }
            }
            if (maxFrequency < currentFrequency) {
                maxFrequency = currentFrequency;
                maxFrequentNumber = number;
            }
        }

        System.out.printf("'%d' is found %d times in array: %s", maxFrequentNumber, maxFrequency, Arrays.toString(numbers));
    }

    public static void showMaxNumber(int[] numbers) {
        if (numbers.length == 0) {
            throw new RuntimeException("Provide not empty array.");
        }
        int maxNumberIndex = 0;
        for (int i = 1, length = numbers.length; i < length; i++) {
            if (numbers[maxNumberIndex] < numbers[i]) {
                maxNumberIndex = i;
            }
        }
        System.out.printf("Max number is: [%d] = %d", maxNumberIndex, numbers[maxNumberIndex]);
    }

    public static void changeMinMaxElements(int[] numbers) {
        if (numbers.length < 2) {
            throw new RuntimeException("Provide array with length more than 1.");
        }

        int maxNumberIndex = 0;
        int minNumberIndex = 0;
        for (int i = 1, length = numbers.length; i < length; i++) {
            if (numbers[maxNumberIndex] < numbers[i]) {
                maxNumberIndex = i;
            }
            if (numbers[minNumberIndex] > numbers[i]) {
                minNumberIndex = i;
            }
        }

        int[] copy = Arrays.copyOf(numbers, numbers.length);

        int tmp = copy[maxNumberIndex];
        copy[maxNumberIndex] = copy[minNumberIndex];
        copy[minNumberIndex] = tmp;

        System.out.printf("Before: %s%n", Arrays.toString(numbers));
        System.out.printf("After: %s%n", Arrays.toString(copy));
    }

    public static void shiftArrayBySteps(int[] numbers, int steps) {
        int[] result = Arrays.copyOf(numbers, numbers.length);
        if (steps != 0) {
            for (int i = 0; i < Math.abs(steps); i++) {
                if (steps > 0) {
                    for (int length = numbers.length, j = length - 1; j > 0; j--) {
                        result[j] = result[j - 1];
                    }
                } else {
                    for (int length = numbers.length, j = 0; j < length - 1; j++) {
                        result[j] = result[j + 1];
                    }
                }
            }

            if (steps > 0) {
                Arrays.fill(result, 0, steps, 0);
            } else {
                Arrays.fill(result, -steps + 1, numbers.length, 0);
            }
        }

        System.out.printf("Before: %s%n", Arrays.toString(numbers));
        System.out.printf("After: %s%n", Arrays.toString(result));
    }

    public static void showUniqueNumbers(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            boolean isUnique = true;
            for (int j = 0; j < numbers.length; j++) {
                if (i != j && numbers[i] == numbers[j]) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                System.out.println(numbers[i]);
            }
        }
    }

    public static void reverse(int[] numbers) {
        int[] reversedNumbers = Arrays.copyOf(numbers, numbers.length);
        for (int i = 0, length = numbers.length / 2; i < length; i++) {
            int tmp = reversedNumbers[i];
            reversedNumbers[i] = reversedNumbers[numbers.length - 1 - i];
            reversedNumbers[numbers.length - 1 - i] = tmp;
        }
        System.out.printf("Before: %s%n", Arrays.toString(numbers));
        System.out.printf("After: %s%n", Arrays.toString(reversedNumbers));
    }

    public static void showMaxByAbsNumber(int[] numbers) {
        if (numbers.length == 0) {
            throw new RuntimeException("Pass not empty array.");
        }

        int maxByAbs = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (Math.abs(maxByAbs) < Math.abs(numbers[i])) {
                maxByAbs = numbers[i];
            }
        }
        System.out.println(maxByAbs);
    }

    public static void showSumOfEvenPositiveNumbers(int[] numbers) {
        int sum = 0;

        for (int number : numbers) {
            if (number % 2 == 0 && number > 0) {
                sum += number;
            }
        }

        System.out.println(sum);
    }

    public static void findMaxNumberWithEvenIndex(int[] numbers) {
        if (numbers.length == 0) {
            throw new RuntimeException("Pass not empty array.");
        }

        int maxNumber = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (i % 2 == 0 && maxNumber < numbers[i]) {
                maxNumber = numbers[i];
            }
        }
        System.out.println(maxNumber);
    }

    public static void showLessThanAverageNumbers(int[] numbers) {
        int average = Arrays.stream(numbers).reduce(0, Integer::sum) / numbers.length;
        System.out.println("Average: " + average);
        Arrays.stream(numbers).filter(number -> number < average).forEach(System.out::println);
    }

    public static void insert(int[] numbers, int index, int value) {
        int[] newArray = new int[numbers.length + 1];
        System.arraycopy(numbers, 0, newArray, 0, index);
        newArray[index] = value;
        System.arraycopy(numbers, index, newArray, index + 1, numbers.length - index);

        System.out.println("Before: " + Arrays.toString(numbers));
        System.out.println("After: " + Arrays.toString(newArray));
    }

    public static void separateToPositiveAndNegative(int[] numbers) {
        int positiveQuantity = 0;
        int negativeQuantity = 0;
        for (int number : numbers) {
            positiveQuantity = number > 0 ? positiveQuantity + 1 : positiveQuantity;
            negativeQuantity = number < 0 ? negativeQuantity + 1 : negativeQuantity;
        }
        int[] positiveNumbers = new int[positiveQuantity];
        int[] negativeNumbers = new int[negativeQuantity];
        for (int i = 0, j = 0, k = 0; i < numbers.length; i++) {
            if (numbers[i] > 0) {
                positiveNumbers[j++] = numbers[i];
            }
            if (numbers[i] < 0) {
                negativeNumbers[k++] = numbers[i];
            }
        }
        System.out.println("+: " + Arrays.toString(positiveNumbers));
        System.out.println("-: " + Arrays.toString(negativeNumbers));
    }

    public static void selectionSort(int[] numbers) {
        int[] copy = Arrays.copyOf(numbers, numbers.length);
        for (int i = 0; i < copy.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < copy.length; j++) {
                if (copy[j] < copy[minIndex]) {
                    minIndex = j;
                }
            }
            int tmp = copy[i];
            copy[i] = copy[minIndex];
            copy[minIndex] = tmp;
        }

        System.out.println("Before: " + Arrays.toString(numbers));
        System.out.println("After: " + Arrays.toString(copy));
    }

    public static void bubbleSort(int[] numbers) {
        int[] copy = Arrays.copyOf(numbers, numbers.length);

        boolean alreadySorted = false;
        while (!alreadySorted) {
            alreadySorted = true;
            for (int i = 0; i < copy.length - 1; i++) {
                if (copy[i + 1] < copy[i]) {
                    int tmp = copy[i + 1];
                    copy[i + 1] = copy[i];
                    copy[i] = tmp;
                    alreadySorted = false;
                }
            }
        }

        System.out.println("Before: " + Arrays.toString(numbers));
        System.out.println("After: " + Arrays.toString(copy));
    }

    public static void multipleNumbers() {
        int[] multipleNumbers = new int[100];
        for (int i = 2; i < multipleNumbers.length; i++) {
            System.out.printf("%d: ", i);
            for (int j = 2; j < 10; j++) {
                if (i % j == 0) {
                    multipleNumbers[i]++;
                    System.out.printf("%d ", j);
                }
            }
            System.out.println();
        }
    }

    public static void count(int[] numbers) {
        int positiveQuantity = 0;
        int negativeQuantity = 0;
        int zeroQuantity = 0;
        for (int number : numbers) {
            if (number > 0) {
                positiveQuantity++;
            } else if (number < 0) {
                negativeQuantity++;
            } else {
                zeroQuantity++;
            }
        }
        System.out.printf("'+': %d, '-': %d, '0': %d", positiveQuantity, negativeQuantity, zeroQuantity);
    }

    public static void showSumAndMultiplication(int[] numbers) {
        if (numbers.length == 0) {
            throw new RuntimeException("Pass not empty array.");
        }

        int sum = 0;
        int multiplication = 1;
        for (int number : numbers) {
            multiplication *= number;
            sum += number;
        }
        System.out.printf("'+': %d, '*': %d", sum, multiplication);
    }

    public static void main(String[] args) {
        int[] numbers = {-5, 8, 0, 1, 2, -8, 1};

        showSumAndMultiplication(numbers);
    }
}
