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
            result = (int) Math.pow(firstNumber, secondNumber);
        } else if (operation == '%') {
            result = firstNumber % secondNumber;
        }

        System.out.println(result);
    }
}