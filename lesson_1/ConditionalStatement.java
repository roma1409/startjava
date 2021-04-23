public class ConditionalStatement {
    public static void main(String[] args) {
        byte age = 21;
        boolean isMaleGender = true;
        double height = 1.81;
        char firstLetter = 'A';

        if (age > 20) {
            System.out.println("age > 20");
        }

        if (isMaleGender) {
            System.out.println("male gender");
        }

        if (!isMaleGender) {
            System.out.println("not male gender");
        }

        if (height < 1.8) {
            System.out.println("height < 1.8");
        } else {
            System.out.println("height > 1.8");
        }

        if (firstLetter == 'M') {
            System.out.println("M");
        } else if (firstLetter == 'I') {
            System.out.println("I");
        } else {
            System.out.println("Another 1st letter");
        }
    }
}