package geometricfigures;

public record Circle(double radius) implements GeometricFigure {
    @Override
    public String toString() {
        return STR."Circle{radius=\{radius}}";
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}
