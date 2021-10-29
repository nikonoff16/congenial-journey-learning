package javalearn.advanced;

public class PlaneCicle extends Circle {
    private final double cx, cy;
    
    public PlaneCicle(double radius, double x, double y) {
        super(radius);
        this.cx = x;
        this.cy = y;
    }

    public double getCentreX() {
        return this.cx;
    }

    public double getCentreY() {
        return this.cy;
    }

    public boolean isInside(double x, double y) {
        double dx = x - cx, dy = y - cy;

        double distance = Math.sqrt(dx*dx + dy*dy);
        return (distance < r);
    }
}
