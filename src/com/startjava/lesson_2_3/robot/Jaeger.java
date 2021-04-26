package com.startjava.lesson_2_3.robot;

public class Jaeger {
    private String name;
    private double height;

    public Jaeger() {
    }

    public Jaeger(String name, double height) {
        this.name = name;
        this.height = height;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void move() {
        System.out.println("I'm moving.");
    }

    public void fire() {
        System.out.println("I'm firing.");
    }
}