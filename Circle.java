package Figures;

public class Circle implements Figure, Color, Characteristics {
    private double radius;
    private String colorOfFilling;
    private String colorOfBorder;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
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
