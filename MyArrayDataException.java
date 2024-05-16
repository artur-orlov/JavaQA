package Lesson_8;

public class MyArrayDataException extends Exception {
    private final int row;
    private final int col;

    public MyArrayDataException(int row, int col, String message) {
        super(message);
        this.row = row;
        this.col = col;
    }
    @Override
    public String toString() {
        return "MyArrayDataException: Row: " + row + ", Col: " + col + ", Message: " + super.toString();
    }
}