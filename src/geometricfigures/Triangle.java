package geometricfigures;

public class Triangle implements GeometricFigure {
    private final double a;
    private final double b;
    private final double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
        return STR."Triangle{a=\{a}, b=\{b}, c=\{c}}";
    }

    @Override
    public double calculateArea() {
        return Math.sqrt((a + b + c) * (-a + b + c) * (a - b + c) * (a + b - c)) / 4;
    }
}
