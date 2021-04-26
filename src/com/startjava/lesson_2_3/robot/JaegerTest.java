package com.startjava.lesson_2_3.robot;

public class JaegerTest {
    public static void main(String[] args) {
        Jaeger killer = new Jaeger();
        killer.setName("killer");
        killer.setHeight(1.78d);

        System.out.println(killer.getName());
        killer.setName("super-killer");
        System.out.println(killer.getName());
        System.out.println(killer.getHeight());
        killer.move();
        killer.fire();

        System.out.println("\n============\n");

        Jaeger flyer = new Jaeger("flyer", 0.1d);

        System.out.println(flyer.getName());
        System.out.println(flyer.getHeight());
        flyer.move();
        flyer.fire();
    }
}