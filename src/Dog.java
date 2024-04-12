public class Dog extends Animal {
    private static int count = 0;
    private static final int RUN_LIMIT = 500;
    private static final int SWIM_LIMIT = 10;

    public Dog(String name) {
        super(name);
        count++;
    }

    public void swim(int distance) {
        if (distance <= 0) {
            System.out.println(getName() + " cannot swim a negative distance");
        } else if (distance <= SWIM_LIMIT) {
            System.out.println(getName() + " has swam " + distance + " m");
        } else {
            System.out.println(getName() + " cannot swim " + distance + " m");
        }
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

    public static int getCount() {
        return count;
    }
}