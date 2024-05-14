public class Cat extends  Animal {
    boolean satiety;
    public static int count;
    public Cat (String name) {
        super(name);
        this.satiety = satiety;
        count++;
    }

    @Override
    public void run(int distance) {
        if (distance > 0 && distance <= 200) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не сможет пробежать " + distance + " м.");
        }
    }
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать!");
    }
    public void eatFromABowl(int food) {
        if (food <= Bowl.amountOfFood) {
            satiety = true;
            Bowl.amountOfFood -= food;
        } else {
            System.out.println("Маловато еды!");
        }
    }
}
