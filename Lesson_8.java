package Lesson_8;


public class Lesson_8 {
    public static void main(String[] args) {
        String[][] array = {{"1","0","5","0"}, {"0","1","0","0"}, {"0","0","0","0",}, {"1","1","0","0",}};

        try {
            System.out.println("Сумма чисел в массиве: " + sumOfNumbersInMatrix(array));
        } catch (MyArraySizeException e) {
            System.out.println("Неверный размер массива: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Некорректные данные в массиве: " + e.toString());
        }
    }

    public static int sumOfNumbersInMatrix(String[][] matrix) throws MyArraySizeException, MyArrayDataException {
        if (matrix.length != 4 || matrix[0].length != 4) {
            throw new MyArraySizeException("Размер массива должен быть 4x4");
        }
        int sum = 0;



        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    sum += Integer.parseInt(matrix[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j, "Элемент [" + i + "][" + j + "] не является числом");
                }
            }
        }

        return sum;
    }
}