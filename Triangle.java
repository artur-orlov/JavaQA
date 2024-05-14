package Figures;

public class Triangle implements Figure, Color, Characteristics {
    private double sideA;
    private double sideB;
    private double sideC;
    private String colorOfFilling;
    private String colorOfBorder;

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public double calculatePerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public double calculateArea() {
        double polyperimeter = calculatePerimeter() / 2;
        return Math.sqrt(polyperimeter * (polyperimeter - sideA) * (polyperimeter - sideB) * (polyperimeter - sideC));
    }

    @Override
    public void setColorOfFilling(String colorOfFilling) {
        this.colorOfFilling = colorOfFilling;
    }

    @Override
    public void setColorOfBorder(String colorOfBorder) {
        this.colorOfBorder = colorOfBorder;
    }

    @Override
    public String getColorOfFilling() {
        return colorOfFilling;
    }

    @Override
    public String getColorOfBorder() {
        return colorOfBorder;
    }
}
