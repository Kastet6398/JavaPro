public class Cat extends Animal {
    private static int count = 0;
    private static final int RUN_LIMIT = 200;

    public Cat(String name) {
        super(name);
        count++;
    }

    public void run(int distance) {
        if (distance <= 0) {
            System.out.println(getName() + " cannot run a negative distance");
        } else if (distance <= RUN_LIMIT) {
            System.out.println(getName() + " has run " + distance + " m");
        } else {
            System.out.println(getName() + " cannot run " + distance + " m");
        }
    }
    public void swim(int distance) {
        System.out.println(getName() + " cannot swim");
    }
    public static int getCount() {
        return count;
    }
}