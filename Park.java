public class Park {
    public static void main(String[] args) {
        Attraction rocket = new Attraction("Rocket", "everyday", 50);
        Attraction houseOfHorror = new Attraction("House Of Horror", "everynight", 100);
        rocket.info();
        houseOfHorror.info();

    }

    static class Attraction {
        private String title = this.title;
        private String workingHours = this.workingHours;
        private int price = this.price;
        public Attraction(String title, String workingHours, int price) {
            this.title = title;
            this.workingHours = workingHours;
            this.price = price;
        }
        public void info() {
            System.out.println("\nНазвание: " + title + "\nВремя работы: " + workingHours + "\nЦена: " + price + " рублей");
        }

    }

}
