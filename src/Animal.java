public abstract class Animal {
    private static int count;
    private final String name;

    public Animal(String name) {
        this.name = name;
        count++;
    }

    public static int getCount() {
        return count;
    }

    public abstract void run(int distance);
    public abstract void swim(int distance);

    public String getName() {
        return name;
    }
}