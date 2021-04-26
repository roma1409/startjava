package com.startjava.lesson_2_3.animal;

public class WolfTest {
    public static void main(String[] args) {
        Wolf hunter = new Wolf();
        hunter.setName("hunter");
        hunter.setWeight(15.0d);
        hunter.setAge((byte) 4);
        hunter.setColor("red");

        System.out.println(hunter.isMale());
        System.out.println(hunter.getName());
        System.out.println(hunter.getWeight());
        System.out.println(hunter.getAge());
        System.out.println(hunter.getColor());

        hunter.walk();
        hunter.sit();
        hunter.run();
        hunter.howl();
        hunter.hunt();
    }
}