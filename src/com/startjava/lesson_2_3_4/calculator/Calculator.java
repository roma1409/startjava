package com.startjava.lesson_2_3_4.calculator;

public class Calculator {
    public int calculate(char sign, int firstNumber, int secondNumber) {
        int result = 0;

        switch(sign) {
            case '+':
                result = firstNumber + secondNumber;
                break;
            case '-':
                result = firstNumber - secondNumber;
                break;
            case '*':
                result = firstNumber * secondNumber;
                break;
            case '/':
                result = firstNumber / secondNumber;
                break;
            case '^':
                result = 1;
                for (int i = 0; i < secondNumber; i++) {
                    result *= firstNumber;
                }
                break;
            case '%':
                result = firstNumber % secondNumber;
                break;
        }

        return result;
    }
}