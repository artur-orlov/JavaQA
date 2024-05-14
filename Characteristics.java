package Figures;

public interface Characteristics extends Color, Figure {
    default String printAllCharacteristics() {
        return "Perimeter = " + calculatePerimeter() + ", area = " + calculateArea() + ", color of filling : " +
                getColorOfFilling()+ " , color of border : " + getColorOfBorder();
    }
}
