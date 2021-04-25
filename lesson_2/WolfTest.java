public class WolfTest {
    public static void main(String[] args) {
        Wolf hunter = new Wolf();
        hunter.isMale = false;
        hunter.name = "hunter";
        hunter.weight = 15.0d;
        hunter.age = 4;
        hunter.color = "red";

        System.out.println(hunter.isMale);
        System.out.println(hunter.name);
        System.out.println(hunter.weight);
        System.out.println(hunter.age);
        System.out.println(hunter.color);

        hunter.walk();
        hunter.sit();
        hunter.run();
        hunter.howl();
        hunter.hunt();
    }
}