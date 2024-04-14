package geometricfigures;
public record Square(double side) implements GeometricFigure {
    @Override
    public String toString() {
        return STR."Square{side=\{side}}";
    }

    @Override
    public double calculateArea() {
        return side * side;
    }
}
