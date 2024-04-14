package geometricfigures;

public class Circle implements GeometricFigure {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return STR."Circle{radius=\{radius}}";
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}
