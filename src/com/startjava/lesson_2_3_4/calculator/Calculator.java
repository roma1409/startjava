package com.startjava.lesson_2_3_4.calculator;

public class Calculator {
    public int calculate(char sign, int firstNumber, int secondNumber) {
        int result = 0;

        switch (sign) {
            case '+':
                result = Math.addExact(firstNumber, secondNumber);
                break;
            case '-':
                result = Math.subtractExact(firstNumber, secondNumber);
                break;
            case '*':
                result = Math.multiplyExact(firstNumber, secondNumber);
                break;
            case '/':
                result = Math.floorDiv(firstNumber, secondNumber);
                break;
            case '^':
                result = (int) Math.pow(firstNumber, secondNumber);
                break;
            case '%':
                result = Math.floorMod(firstNumber, secondNumber);
                break;
            default:
                throw new RuntimeException(String.format("'%c' - Unsupported sign for calculation.", sign));
        }

        return result;
    }
}