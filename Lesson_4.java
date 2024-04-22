import java.util.Arrays;

public class Lesson_4 {
    public static void main(String[] args) {
        printThreeWords();

        checkSumSign(-7, 7);

        printColor(777);

        compareNumbers(7, 7);

        System.out.println(isInRange(13, 7));

        isPositive(0);

        System.out.println(isPositiveCheck(-1));

        printStrokeNTimes("Hello world!", 7);

        System.out.println(isThatLeapYear(2024));

        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        replacingArrayNumers(array);

        int[] array100 = new int[100];
        fillUpTo100(array100);

        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        doubleNumbersLessThanSix(arr);

        int [][] squarearray = new int[15][15];
        diagonalsOfNumbers1(squarearray);

        System.out.println(Arrays.toString((makeArray(7, 7))));

    }

    /*
    TODO: 1. Создайте метод printThreeWords(), который при вызове должен отпечатать в столбец три слова: Orange, Banana, Apple.
     */
    public static void printThreeWords() {
        System.out.println("Orange\n" +
                "Banana\n" +
                "Apple");
    }

    /*
    TODO: 2. Создайте метод checkSumSign(), в теле которого объявите две int переменные a и b, и инициализируйте их
     любыми значениями, которыми захотите. Далее метод должен просуммировать эти переменные, и если их сумма больше или
     равна 0, то вывести в консоль сообщение “Сумма положительная”, в противном случае - “Сумма отрицательная”;
     */
    public static void checkSumSign(int firstVal, int secondVal) {
        System.out.println((firstVal + secondVal) >= 0 ? "Сумма положительная" : "Сумма отрицательная");
    }

    /*
    TODO: 3. Создайте метод printColor() в теле которого задайте int переменную value и инициализируйте ее любым значением.
     Если value меньше 0 (0 включительно), то в консоль метод должен вывести сообщение “Красный”, если лежит в пределах
     от 0 (0 исключительно) до 100 (100 включительно), то “Желтый”, если больше 100 (100 исключительно) - “Зеленый”;
     */
    public static void printColor(int value) {
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else if (value > 100) {
            System.out.println("Зеленый");
        }
    }

    /*
    TODO: 4. Создайте метод compareNumbers(), в теле которого объявите две int переменные a и b, и инициализируйте их
     любыми значениями, которыми захотите. Если a больше или равно b, то необходимо вывести в консоль сообщение “a >= b”,
     в противном случае “a < b”;
     */
    public static void compareNumbers(int a, int b) {
        System.out.println(a >= b ? "a >= b" : "a < b");
    }

    /*
    TODO: 5. Напишите метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах от
     10 до 20 (включительно), если да – вернуть true, в противном случае – false.
     */
    public static boolean isInRange(int a, int b) {
        return ((a + b) >= 10 && (a + b) <= 20);
    }

    /*
    TODO: 6. Напишите метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль,
     положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.
     */
    public static void isPositive(int val) {
        System.out.println(val >= 0 ? "положительное" : "отрицательное");
    }

    /*
    TODO 7. Напишите метод, которому в качестве параметра передается целое число. Метод должен вернуть true,
     если число отрицательное, и вернуть false если положительное.
     */
    public static boolean isPositiveCheck(int val) {
        return val < 0;
    }

    /*
    TODO: 8. Напишите метод, которому в качестве аргументов передается строка и число, метод должен отпечатать
     в консоль указанную строку, указанное количество раз;
     */
    public static void printStrokeNTimes(String stroke, int amount) {
        for (int i = 0; i < amount; i++) {
            System.out.println(stroke);
        }
    }

    /*
    TODO: 9. Напишите метод, который определяет, является ли год високосным, и возвращает boolean (високосный - true,
     не високосный - false). Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
     */
    public static boolean isThatLeapYear(int year) {
        if (year % 400 == 0 && year % 100 != 0) {
            return true;
        } else if ((year % 4 == 0) && (year % 100 != 0)) {
            return true;
        } else {
            return false;
        }
    }

    /*
    TODO: 10. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
     С помощью цикла и условия заменить 0 на 1, 1 на 0;
     */
    //P.S. Несмотря на отсутствие условия на создание метода, предпочту не менять концепцию класса и продолжу создавать методы.
    public static void replacingArrayNumers(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] == 0 ? 1 : 0;
        }
        System.out.println(Arrays.toString(array));
    }

    /*
    TODO: 11. Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 ... 100;
     */
    public static void fillUpTo100(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i+1;
        }
        System.out.println(Arrays.toString(array));
    }

    /*
    TODO: 12. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
     */
    public static void doubleNumbersLessThanSix (int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    /*
    TODO: 13. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью
     цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно).
     Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны,
     то есть [0][0], [1][1], [2][2], ..., [n][n];
     */
    public static void diagonalsOfNumbers1(int[][] array) {
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j || i == array.length-(j+1)) {
                    array[i][j] = 1;
                }
                System.out.printf("%3d" ,array[i][j]);
                counter++;
                if (counter % array.length == 0) {
                    System.out.println("");
                }
            }
        }
    }
    /*
    TODO: 14. Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный массив
     типа int длиной len, каждая ячейка которого равна initialValue.
     */
    public static int[] makeArray(int len, int initialValue) {
        int [] array = new int[len];
        for (int i = 0; i< array.length; i++) {
            array[i] = initialValue;
        }
        return array;
    }
}
