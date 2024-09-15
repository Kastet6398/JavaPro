import competition.*;
import geometricfigures.*;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        GeometricFigure[] geometricFigures = {
                new Circle(10),
                new Square(10),
                new Triangle(10, 10, 10)
        };

        System.out.println(getSumArea(geometricFigures));

        System.out.println("-----------------");

        Participant[] participants = {
                new Human("Vasyl"),
                new Cat("Murka"),
                new Robot("ASIMO")
        };

        Obstacle[] obstacles = {
                new RunningTrack(50),
                new Wall(0.5),
                new RunningTrack(150),
                new Wall(2.5)
        };

        for (Participant participant : participants) {
            for (Obstacle obstacle : obstacles) {
                if (!obstacle.overcome(participant)) {
                    break;
                }
            }
        }
    }

    private static double getSumArea(GeometricFigure... geometricFigures) {
        return Stream.of(geometricFigures).mapToDouble(GeometricFigure::calculateArea).sum();
    }
}
