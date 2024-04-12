public class Animal {
    private static int count;
    private final String name;
    private final int runLimit;
    private final int swimLimit;

    public Animal(String name, int runLimit, int swimLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
        count++;
    }

    public static int getCount() {
        return count;
    }

    public void run(int distance) {
        if (runLimit == 0) {
            System.out.println(name + " cannot run");
        } else if (distance <= 0) {
            System.out.println(name + " cannot run a negative distance");
        } else if (distance <= runLimit) {
            System.out.println(name + " has run " + distance + " m");
        } else {
            System.out.println(name + " cannot run " + distance + " m");
        }
    }

    public void swim(int distance) {
        if (swimLimit == 0) {
            System.out.println(name + " cannot swim");
        } else if (distance <= 0) {
            System.out.println(name + " cannot swim a negative distance");
        }  else if (distance <= swimLimit) {
            System.out.println(name + " has swam " + distance + " m");
        } else {
            System.out.println(name + " cannot swim " + distance + " m");
        }
    }
}