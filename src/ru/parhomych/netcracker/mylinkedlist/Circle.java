package ru.parhomych.netcracker.mylinkedlist;

import java.util.Random;

public class Circle implements Comparable<Circle>{

    private double radius = 1.0d;
    private String color = "red";

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public static Circle getRandomCircle() {
        Circle instance;

        Random rand = new Random();
        double radius = rand.nextDouble() * 100;
        int sizeOfStr = 1 + rand.nextInt(10);
        char[] charArr = new char[sizeOfStr];
        for (int i = 0; i < sizeOfStr; i++){
            charArr[i] = (char)(rand.nextInt(26) + 97);
        }
        String colorName = String.copyValueOf(charArr);
        instance = new Circle(radius, colorName);

        return instance;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Circle[" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                ", area=" + getArea() +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Circle circle = (Circle) o;

        return color.equals(circle.color) && Double.compare(circle.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        int result = 17;
        long temp;
        temp = Double.doubleToLongBits(radius);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + color.hashCode();
        return result;
    }

    public double getArea(){
        double area = Math.PI * Math.pow(radius, 2);
        return area;
    }
//&& this.getColor().compareTo(o.getColor()) == 0
    @Override
    public int compareTo(Circle o) {
        if (Double.compare(this.radius, o.getRadius()) == 0 ){
            if (this.getColor().compareTo(o.getColor()) == 0){
                return 0;
            } else if (this.getColor().compareTo(o.getColor()) > 0){
                return 1;
            } else {
                return -1;
            }
        } else if (Double.compare(this.radius, o.getRadius()) > 0){
            return 1;
        } else {
            return -1;
        }
    }
}