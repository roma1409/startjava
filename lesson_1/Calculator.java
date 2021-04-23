public class Calculator {
    public static void main(String[] args) {
        int firstNumber = 10;
        int secondNumber = 5;
        char operation = '+';
        int result = 0;

        if (operation == '+') {
            result = firstNumber + secondNumber;
        } else if (operation == '-') {
            result = firstNumber - secondNumber;
        } else if (operation == '*') {
            result = firstNumber * secondNumber;
        } else if (operation == '/') {
            result = firstNumber / secondNumber;
        } else if (operation == '^') {
            result = 1;
            for (int i = 0; i < secondNumber; i++) {
                result *= firstNumber;
            }
        } else if (operation == '%') {
            result = firstNumber % secondNumber;
        }

        System.out.println(result);
    }
}