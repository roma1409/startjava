package com.startjava.lesson_2_3.calculator;

import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        String userAnswer;

        do {
            System.out.print("Введите первое число: ");
            int firstNumber = Integer.parseInt(scanner.nextLine());

            System.out.print("Введите знак математической операции: ");
            char sign = scanner.nextLine().charAt(0);
            
            System.out.print("Введите второе число: ");
            int secondNumber = Integer.parseInt(scanner.nextLine());

            int result = calculator.calculate(sign, firstNumber, secondNumber);
            System.out.format("%n%d %c %d = %d%n%n", firstNumber, sign, secondNumber, result);

            do {
                System.out.print("Хотите продолжить вычисления? [yes/no]: ");
                userAnswer = scanner.nextLine();
            } while(!userAnswer.equals("yes") && !userAnswer.equals("no"));

            System.out.println();
        } while(userAnswer.equals("yes"));
    }
}