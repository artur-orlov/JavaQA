package Figures;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(7);
        circle.setColorOfBorder("Black");
        circle.setColorOfFilling("White");
        Rectangle rectangle = new Rectangle(7,4);
        rectangle.setColorOfBorder("Green");
        rectangle.setColorOfFilling("Red");
        Triangle triangle = new Triangle(7,7,7);
        triangle.setColorOfBorder("Orange");
        triangle.setColorOfFilling("Blue");

        System.out.println(circle.printAllCharacteristics() + "\n" +
                rectangle.printAllCharacteristics() + "\n" +
                triangle.printAllCharacteristics());



    }
}