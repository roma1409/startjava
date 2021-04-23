public class ConditionalStatement {
    public static void main(String[] args) {
        byte age = 21;
        if (age > 20) {
            System.out.println("age > 20");
        }

        boolean isMaleGender = true;
        if (isMaleGender) {
            System.out.println("male gender");
        }
        if (!isMaleGender) {
            System.out.println("not male gender");
        }

        double height = 1.81;
        if (height < 1.8) {
            System.out.println("height < 1.8");
        } else {
            System.out.println("height > 1.8");
        }

        char firstLetterName = 'A';
        if (firstLetterName == 'M') {
            System.out.println("M");
        } else if (firstLetterName == 'I') {
            System.out.println("I");
        } else {
            System.out.println("Another 1st letter");
        }
    }
}