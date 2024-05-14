public class Bowl {
    static int amountOfFood;
    public Bowl (int amountOfFood) {
        Bowl.amountOfFood = amountOfFood;
    }
    public static void addMoreFood(int amount) {
        amountOfFood = amount;
    }
}
