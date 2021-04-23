public class Cycle {
    public static void main(String[] args) {
        for(int i = 0; i < 21; i++) {
            System.out.println("Index [0, 20]: " + i);
        }
        int i = 6;

        System.out.println();
        while(i >= -6) {
            System.out.println("Number [6, -6] with step 2: " + i);
            i-=2;
        }

        System.out.println();
        int start = 10;
        int end = 20;
        int sum = 0;
        do {
            if (start % 2 == 1) {
                sum += start;
            }
            start++;
        } while (start < end);
        System.out.println("Sum of odd numbers [10, 20]: " + sum);
    }
}