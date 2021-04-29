package com.startjava.lesson_2_3_4.calculator;

public class Calculator {
    public int calculate(char sign, int firstNumber, int secondNumber) {
        return switch (sign) {
            case '+' -> Math.addExact(firstNumber, secondNumber);
            case '-' -> Math.subtractExact(firstNumber, secondNumber);
            case '*' -> Math.multiplyExact(firstNumber, secondNumber);
            case '/' -> Math.floorDiv(firstNumber, secondNumber);
            case '^' -> (int) Math.pow(firstNumber, secondNumber);
            case '%' -> Math.floorMod(firstNumber, secondNumber);
            default -> throw new RuntimeException(String.format("'%c' - Unsupported sign for calculation.", sign));
        };
    }
}