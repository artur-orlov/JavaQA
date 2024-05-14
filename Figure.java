package Figures;

public interface Figure {
    double calculatePerimeter();

    double calculateArea();

    default double calculatePerimeter(double radius) {
        return 2 * Math.PI * radius;
    }

    default double calculateArea(double radius) {
        return Math.PI * (radius * radius);
    }

    default double calculatePerimeter(double sideA, double sideB) {
        return 2 * (sideA + sideB);
    }

    default double calculateArea(double sideA, double sideB) {
        return sideA * sideB;
    }

    default double calculatePerimeter(double sideA, double sideB, double sideC) {
        return sideA + sideB + sideC;
    }

    default double calculateArea(double sideA, double sideB, double sideC) {
        double polyperimeter = calculatePerimeter() / 2;
        return Math.sqrt(polyperimeter * (polyperimeter - sideA) * (polyperimeter - sideB) * (polyperimeter - sideC));
    }
}
