public class MyFirstGame {
    public static void main(String[] args) { 
        int min = 1;
        int max = 100;
        int guessNumber = (int) ((Math.random() * (max - min)) + min);
        int userNumber = 50;

        while (userNumber != guessNumber){
            if (userNumber < guessNumber) {
                System.out.println("Данное число больше того, что загадал компьютер");
                userNumber++;
            } else {
                System.out.println("Данное число меньше того, что загадал компьютер");
                userNumber--;
            }
        }
        System.out.println("Поздравляю, число угадано!");
    }
}