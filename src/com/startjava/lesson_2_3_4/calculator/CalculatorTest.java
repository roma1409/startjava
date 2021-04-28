package com.startjava.lesson_2_3_4.calculator;

import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        String userAnswer;

        do {
            System.out.print("Введите математическое выражение: ");
            String[] expressionParts = scanner.nextLine().trim().split("\\s");

            int firstNumber = Integer.parseInt(expressionParts[0]);
            char sign = expressionParts[1].charAt(0);
            int secondNumber = Integer.parseInt(expressionParts[2]);

            int result = calculator.calculate(sign, firstNumber, secondNumber);
            System.out.format("%n%d %c %d = %d%n%n", firstNumber, sign, secondNumber, result);

            do {
                System.out.print("Хотите продолжить вычисления? [yes/no]: ");
                userAnswer = scanner.nextLine();
            } while (!userAnswer.equals("yes") && !userAnswer.equals("no"));

            System.out.println();
        } while (userAnswer.equals("yes"));
    }
}