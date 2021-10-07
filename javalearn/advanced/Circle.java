package javalearn.advanced;

public class Circle {
    public static final double PI = 3.14;

    public static double radiansToDegrees(double radians) {
        return radians * 180 / PI;
    }

    protected double r;

    
    public Circle(double radius) {
        this.r = radius;
    }

    public Circle() {
        this(1.0);
    }

    public double area() {
        return this.r * this.r * PI;
    }

    public double circumference() {
        return 2 * PI * this.r;
    }
}