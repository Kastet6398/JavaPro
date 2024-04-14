package geometricfigures;

public record Triangle(double a, double b, double c) implements GeometricFigure {
    @Override
    public String toString() {
        return STR."Triangle{a=\{a}, b=\{b}, c=\{c}}";
    }

    @Override
    public double calculateArea() {
        return Math.sqrt((a + b + c) * (-a + b + c) * (a - b + c) * (a + b - c)) / 4;
    }
}
