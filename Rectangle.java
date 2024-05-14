package Figures;

public class Rectangle implements Figure, Color, Characteristics {
    private double sideA;
    private double sideB;
    private String colorOfFilling;
    private String colorOfBorder;

    public Rectangle(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (sideA + sideB);
    }

    @Override
    public double calculateArea() {
        return sideA * sideB;
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
