public class Dog extends  Animal{
    public static int count;
    public Dog (String name) {
        super(name);
        count++;
    }

    @Override
    public void run(int distance) {
        if (distance > 0 && distance <= 500) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не сможет пробежать " + distance + " м.");
        }
    }
    public void swim(int distance) {
        if (distance > 0 && distance <= 10) {
            System.out.println(name + " проплыл " + distance + " м.");
        } else {
            System.out.println(name + " не сможет проплыть " + distance + " м.");
        }
    }
}
