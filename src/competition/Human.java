package competition;

public class Human implements Participant {
    private static final double MAX_LENGTH = 1024;
    private static final double MAX_HEIGHT = 2;
    private final String name;

    public String getName() {
        return name;
    }

    public Human(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return STR."Human{name='\{name}'}";
    }

    @Override
    public boolean run(double length) {
        if (length <= MAX_LENGTH) {
            System.out.println(STR."Human \{name} is running.");
            return true;
        } else {
            System.out.println(STR."Human \{name} cannot run \{length} m.");
            return false;
        }
    }

    @Override
    public boolean jump(double height) {
        if (height <= MAX_HEIGHT) {
            System.out.println(STR."Human \{name} is jumping.");
            return true;
        } else {
            System.out.println(STR."Human \{name} cannot jump \{height} m.");
            return false;
        }
    }
}
