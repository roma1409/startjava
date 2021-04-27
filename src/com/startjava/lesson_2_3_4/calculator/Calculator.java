package com.startjava.lesson_2_3_4.calculator;

public class Calculator {
    public int calculate(char sign, int firstNumber, int secondNumber) {
        int result = 0;

        switch (sign) {
            case '+' -> result = Math.addExact(firstNumber, secondNumber);
            case '-' -> result = Math.subtractExact(firstNumber, secondNumber);
            case '*' -> result = Math.multiplyExact(firstNumber, secondNumber);
            case '/' -> result = Math.floorDiv(firstNumber, secondNumber);
            case '^' -> result = (int) Math.pow(firstNumber, secondNumber);
            case '%' -> result = Math.floorMod(firstNumber, secondNumber);
        }

        return result;
    }
}