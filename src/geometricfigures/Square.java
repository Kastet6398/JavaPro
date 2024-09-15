package geometricfigures;
public class Square implements GeometricFigure {
    private final double side;

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    @Override
    public String toString() {
        return STR."Square{side=\{side}}";
    }

    @Override
    public double calculateArea() {
        return side * side;
    }
}
