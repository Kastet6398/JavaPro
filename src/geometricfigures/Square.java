package geometricfigures;
public class Square implements GeometricFigure {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
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
