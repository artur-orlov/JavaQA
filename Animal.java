public class Animal {
    String name;
    public static int count;
    public Animal (String name) {
        this.name = name;
        count++;
    }
    public void run(int distance) {
        System.out.println(name + " пробежал " + distance + " м.");
    }
    public void swim(int distance) {
        System.out.println(name + " проплыл " + distance + " м.");
    }
}
