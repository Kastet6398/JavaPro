package geometricfigures;

public class Circle implements GeometricFigure {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
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
